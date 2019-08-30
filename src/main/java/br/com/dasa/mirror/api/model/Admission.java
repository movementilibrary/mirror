package br.com.dasa.mirror.api.model;

public class Admission {
	
	private String originId;

	private Patient patient;

	private Payments[] payments;

	private Questions[] questions;

	private String unitId;

	private Orders[] orders;

	private Scheduling scheduling;

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Payments[] getPayments() {
		return payments;
	}

	public void setPayments(Payments[] payments) {
		this.payments = payments;
	}

	public Questions[] getQuestions() {
		return questions;
	}

	public void setQuestions(Questions[] questions) {
		this.questions = questions;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public Orders[] getOrders() {
		return orders;
	}

	public void setOrders(Orders[] orders) {
		this.orders = orders;
	}

	public Scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(Scheduling scheduling) {
		this.scheduling = scheduling;
	}

	@Override
	public String toString() {
		return "Admission [originId = " + originId + ", patient = " + patient + ", payments = " + payments
				+ ", questions = " + questions + ", unitId = " + unitId + ", orders = " + orders + ", scheduling = "
				+ scheduling + "]";
	}
}
