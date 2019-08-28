package br.com.dasa.mirror.api.repository.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

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

	private static final Logger LOGGER = Logger.getLogger(AdmissaoRepositoryImpl.class.getName());

	@Override
	public Response admissaoRepository(String json) throws Exception {
		Response response = new Response();
		response.setDescricao("Mensagem recebida com sucesso");
		
		LOGGER.log( Level.INFO, "Mensagem recebida com sucesso: "+json);
		return response;
	}

}
