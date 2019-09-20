package br.com.dasa.mirror.api.repository.impl;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;
import br.com.dasa.mirror.api.repository.translator.FromToAdmissionTranslator;

@Repository
public class AdmissaoRepositoryImpl implements AdmissaoRepository {

	@Autowired
	private FromToAdmissionTranslator translator;

	private static final Logger LOGGER = Logger.getLogger(AdmissaoRepositoryImpl.class.getName());

	@Override
	public Optional<FromToAdmission> admissaoRepository(Admission admission) {
		LOGGER.log(Level.INFO, "Mensagem recebida com sucesso: " + admission.toString());
		return Optional.ofNullable(translator.translate(admission));
	}

}
