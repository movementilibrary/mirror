package br.com.dasa.mirror.api.repository.translator;

import br.com.dasa.mirror.api.model.data.provider.ProductTraslate;
import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission.Status;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class FromToAdmissionTranslator {

	public FromToAdmission translateProdutoTraducao(ProductTraslate[] traducao) {
		if (isNull(traducao))
			return null;

		Gson gson = new Gson();
		String json = gson.toJson(traducao);
		return new FromToAdmission(Status.SEND_SUCCESS, json);
	}

	public FromToAdmission translateAdmission(Admission admission) {
		if (isNull(admission))
			return null;

		Gson gson = new Gson();
		String json = gson.toJson(admission);
		return new FromToAdmission(Status.SEND_SUCCESS, json);
	}

}
