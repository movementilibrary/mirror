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

	private String jsonFromTo;
	private Status status;

	public FromToAdmission(Status status, String jsonFromTo) {
		this.jsonFromTo = jsonFromTo;
		this.status = status;
	}

	public FromToAdmission() {

	}

	public String getJsonFromTo() {
		return jsonFromTo;
	}

	public void setJsonFromTo(String jsonFromTo) {
		this.jsonFromTo = jsonFromTo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
