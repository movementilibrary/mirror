package br.com.dasa.mirror.api.assembler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.dasa.mirror.api.model.from.to.admission.Request;

@JsonPropertyOrder({ "currentSituation" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestResource {

	private Request.CurrentSituation currentSituation;

	public RequestResource() {
	}

	public RequestResource(Request.CurrentSituation currentSituation) {
		this.currentSituation = currentSituation;
	}

	public Request.CurrentSituation getCurrentSituation() {
		return currentSituation;
	}

	public void setCurrentSituation(Request.CurrentSituation currentSituation) {
		this.currentSituation = currentSituation;
	}
}
