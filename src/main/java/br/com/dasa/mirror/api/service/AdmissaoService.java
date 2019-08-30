package br.com.dasa.mirror.api.service;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Response;

public interface AdmissaoService {

	Response admissaoValues(Admission admission) throws Exception;
}
