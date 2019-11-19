package br.com.dasa.mirror.api.repository.translator;

import static java.util.Objects.isNull;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.FromToAdmission;
import br.com.dasa.mirror.api.model.FromToAdmission.Status;

@Component
public class FromToAdmissionTranslator {

	public FromToAdmission translateAdmission(Admission admission) {
		if (isNull(admission))
			return null;

		Gson gson = new Gson();
		String json = gson.toJson(admission);
		return new FromToAdmission(Status.SEND_SUCCESS, json);
	}

}
