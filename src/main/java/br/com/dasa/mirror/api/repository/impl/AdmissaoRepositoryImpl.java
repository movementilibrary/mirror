package br.com.dasa.mirror.api.repository.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import br.com.dasa.mirror.api.model.Admission;
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
	public Response admissaoRepository(Admission admission) {
		Response response = new Response();
		response.setDescricao("Mensagem recebida com sucesso");
		Gson gson = new Gson();
		String json = gson.toJson(admission);
		LOGGER.log(Level.INFO, "Mensagem recebida com sucesso: " + json);
		return response;
	}

}
