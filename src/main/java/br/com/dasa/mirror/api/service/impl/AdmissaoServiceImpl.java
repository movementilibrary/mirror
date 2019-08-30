package br.com.dasa.mirror.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Response;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;
import br.com.dasa.mirror.api.service.AdmissaoService;

@Service
public class AdmissaoServiceImpl implements AdmissaoService {

	@Autowired
	AdmissaoRepository admissaoRepository;

	@Override
	public Response admissaoValues(Admission admission) throws Exception {
		return admissaoRepository.admissaoRepository(admission);
	}
}
