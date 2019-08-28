package br.com.dasa.mirror.api.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import br.com.dasa.mirror.api.model.Response;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;

@Repository
public class AdmissaoRepositoryImpl implements AdmissaoRepository {

	@Value("${sqs.url}")
	private String sqsURL;

	@Value("${access.key}")
	private String accessKey;

	@Value("${secret.key}")	
	private String secretKey;

	@Override
	public Response admissaoRepository(String json) throws Exception {
		Response response = new Response();
		BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
		AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(creds);
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(provider).withRegion(Regions.US_EAST_1)
				.build();

		sqs.sendMessage(new SendMessageRequest(sqsURL, json));
		response.setDescricao("Registro inserido com sucesso");
		return response;
	}

}
