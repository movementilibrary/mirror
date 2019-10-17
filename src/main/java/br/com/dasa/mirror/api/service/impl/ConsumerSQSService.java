package br.com.dasa.mirror.api.service.impl;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class ConsumerSQSService {

	@Value("${access.key}")
	private String accessKey;

	@Value("${secret.key}")
	private String secretKey;

	@Value("${bucket.name}")
	private String bucketName;

	@Value("${app.aws.sqs.mock.endpoint}")
    private String awsSqsMockEndpoint;

    @Bean
    @Primary
    public AmazonSQSAsync awsSqsClientMock(){
        return AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsSqsMockEndpoint, "elasticmq"))
                .build();
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(AmazonSQSAsync amazonSQSAsync, QueueMessageHandler queueMessageHandler) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setAmazonSqs(amazonSQSAsync);
        simpleMessageListenerContainer.setMessageHandler(queueMessageHandler);
        simpleMessageListenerContainer.setMaxNumberOfMessages(10);
        simpleMessageListenerContainer.setTaskExecutor(threadPoolTaskExecutor());
        return simpleMessageListenerContainer;
    }

    @Bean
    public QueueMessageHandler queueMessageHandler(AmazonSQSAsync amazonSQSAsync) {
        QueueMessageHandlerFactory queueMessageHandlerFactory = new QueueMessageHandlerFactory();
        queueMessageHandlerFactory.setAmazonSqs(amazonSQSAsync);
        QueueMessageHandler queueMessageHandler = queueMessageHandlerFactory.createQueueMessageHandler();
        return queueMessageHandler;
    }


    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.initialize();
        return executor;
    }
    
	public void onMessage() {
		BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
		AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(creds);

		SQSConnectionFactory connectionFactory = SQSConnectionFactory.builder().withAWSCredentialsProvider(provider)
				.withRegion(RegionUtils.getRegion(Regions.US_EAST_1.getName())).build();
		SQSConnection connection;
		try {
			connection = connectionFactory.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Queue queue = session.createQueue("admissoes-dev");
			// Create a consumer for the 'MyQueue'.
			MessageConsumer consumer = session.createConsumer(queue);

			// Instantiate and set the message listener for the consumer.
			//consumer.setMessageListener(new ConsumerSQSService());

			// Start receiving incoming messages.
			connection.start();

			// Wait for 1 second. The listener onMessage() method is invoked when a message
			// is received.
			Thread.sleep(1000);
			
			Message receivedMessage = consumer.receive(1000);
			// Cast the received message as TextMessage and display the text
			if (receivedMessage != null) {
				System.out.println("Received: " + ((TextMessage) receivedMessage).getText());
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
