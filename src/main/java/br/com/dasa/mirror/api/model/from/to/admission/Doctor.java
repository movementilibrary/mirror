package br.com.dasa.mirror.api.model.from.to.admission;

public class Doctor {

	private String identifierValue;

	private String state;

	private String identifierKind;

	public String getIdentifierValue() {
		return identifierValue;
	}

	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIdentifierKind() {
		return identifierKind;
	}

	public void setIdentifierKind(String identifierKind) {
		this.identifierKind = identifierKind;
	}

	@Override
	public String toString() {
		return "Doctor [identifierValue = " + identifierValue + ", state = " + state + ", identifierKind = "
				+ identifierKind + "]";
	}
}
