package br.com.dasa.mirror.api.repository;

import java.util.Optional;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.FromToAdmission;

public interface AdmissaoRepository {

	Optional<Admission> admissaoRepository(Admission admission);
}
