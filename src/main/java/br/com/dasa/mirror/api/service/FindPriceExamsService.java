package br.com.dasa.mirror.api.service;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Exams;

public interface FindPriceExamsService {

	public String findPriceToGlieseData(Admission admission, Exams exams);
}
