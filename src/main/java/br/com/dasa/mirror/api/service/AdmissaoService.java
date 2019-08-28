package br.com.dasa.mirror.api.service;

import br.com.dasa.mirror.api.model.Response;

public interface AdmissaoService {

	Response admissaoValues(String body) throws Exception;
}
