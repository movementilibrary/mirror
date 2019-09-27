package br.com.dasa.mirror.api.assembler;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;

/**
 * 
 * @author Thiago.Tavares
 *
 */
@JsonPropertyOrder({ "status", "json", "request" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FromToAdmissionResource extends ResourceSupport {

	private String json;
	private FromToAdmission.Status status;
	private RequestResource request;

	public FromToAdmission.Status getStatus() {
		return status;
	}

	public void setStatus(FromToAdmission.Status status) {
		this.status = status;
	}

	public RequestResource getRequest() {
		return request;
	}

	public void setRequest(RequestResource request) {
		this.request = request;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
