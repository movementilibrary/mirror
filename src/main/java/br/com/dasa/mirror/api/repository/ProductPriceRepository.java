package br.com.dasa.mirror.api.repository;

import br.com.dasa.mirror.api.model.from.to.admission.Exams;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;

import java.util.Optional;

public interface ProductPriceRepository {

	Optional<FromToAdmission> ProductRepository(Exams exams);
}
