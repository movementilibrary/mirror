package br.com.dasa.mirror.api.model;

public class Doctor {

	private String identifierValue;

	private String state;

	private String identifierKind;


	public Doctor() {
	}

	public Doctor(String identifierValue, String state, String identifierKind) {
		this.identifierValue = identifierValue;
		this.state = state;
		this.identifierKind = identifierKind;
	}


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
}
