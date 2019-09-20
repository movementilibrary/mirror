package br.com.dasa.mirror.api.service;

import java.util.Optional;

import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;

public interface AdmissaoService {

	Optional<FromToAdmission> admissaoValues(Admission admission);
}
