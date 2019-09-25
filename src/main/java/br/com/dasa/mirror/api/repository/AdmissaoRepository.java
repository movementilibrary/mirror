package br.com.dasa.mirror.api.repository;

import java.util.Optional;

import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;

public interface AdmissaoRepository {

	Optional<FromToAdmission> admissaoRepository(Admission admission);
}
