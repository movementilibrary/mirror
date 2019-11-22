package br.com.dasa.mirror.api.repository;

import br.com.dasa.mirror.api.model.Exams;
import br.com.dasa.mirror.api.model.FromToAdmission;

import java.util.Optional;

public interface ProductPriceRepository {

	Optional<FromToAdmission> productRepository(Exams exams);
}
