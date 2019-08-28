package br.com.dasa.mirror.api.repository;


import br.com.dasa.mirror.api.model.Response;

public interface AdmissaoRepository {

	Response admissaoRepository(String json) throws Exception;
}
