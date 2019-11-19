package br.com.dasa.mirror.api.service.serviceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import br.com.dasa.mirror.api.service.AdmissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.google.gson.Gson;

import br.com.dasa.mirror.api.model.Admission;

@Service
public class ConsumerSQSService {

	@Autowired
	AdmissaoService admissaoService;
	
	@Value("${access.key}")
	private String accessKey;

	@Value("${secret.key}")
	private String secretKey;

	@Value("${queue.name}")
	private String queueName;
	
	private static final Logger LOGGER = Logger.getLogger(ConsumerSQSService.class.getName());

	public void consumerSQS() {
		LOGGER.log(Level.INFO, "[LOG] consumerSQS");
		SQSConnection connection = null;
		BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
		try {
			connection = new SQSConnectionFactory.Builder(Region.getRegion(Regions.US_EAST_1)).build()
					.createConnection(creds);

			Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			MessageConsumer consumer = session.createConsumer(session.createQueue(queueName));

			consumer.setMessageListener(new MessageListenerSQS());
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class MessageListenerSQS implements MessageListener {
		@Override
		public void onMessage(Message message) {
			try {
				LOGGER.log(Level.INFO, "[LOG] onMessage- Recebendo mensagem"+ ((TextMessage) message).getText());
				String json = ((TextMessage) message).getText();
				Gson gson = new Gson();
				Admission admission = gson.fromJson(json, Admission.class);
				admissaoService.admissaoValues(admission);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
