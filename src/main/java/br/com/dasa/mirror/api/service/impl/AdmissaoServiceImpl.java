package br.com.dasa.mirror.api.service.impl;


import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;

import br.com.dasa.mirror.api.service.AdmissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissaoServiceImpl implements AdmissaoService {

    @Autowired
    AdmissaoRepository admissaoRepository;

    @Override
    public Optional<Admission> admissaoValues(Admission admission) {
        return admissaoRepository.admissaoRepository(admission);
    }
}