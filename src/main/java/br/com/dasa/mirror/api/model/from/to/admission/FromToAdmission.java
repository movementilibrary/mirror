package br.com.dasa.mirror.api.model.from.to.admission;

/**
 * 
 * @author Thiago.Tavares
 *
 */
public class FromToAdmission {

	public enum Status {
		SEND_SUCCESS, SEND_ERROR
	}

	private String json;
	private Status status;

	public FromToAdmission(Status status, String json) {
		this.json = json;
		this.status = status;
	}

	public FromToAdmission() {

	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
