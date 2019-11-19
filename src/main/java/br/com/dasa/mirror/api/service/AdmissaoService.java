package br.com.dasa.mirror.api.service;

import br.com.dasa.mirror.api.model.Admission;


import java.util.Optional;

public interface AdmissaoService {

    Optional<Admission> admissaoValues(Admission admission);
}
