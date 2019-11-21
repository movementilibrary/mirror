package br.com.dasa.mirror.api.repository;

import java.util.Optional;

import br.com.dasa.mirror.api.model.Admission;

public interface AdmissaoRepository {

	Optional<Admission> admissaoRepository(Admission admission);
}
