package br.com.dasa.mirror.api.model;

import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Thiago.Tavares
 *
 */
public class Admission {

	private String brandId;

	private String originId;

	private Patient patient;

	private List<Payments> payments;

	private List <Questions> questions;

	private String unitId;

	private List<Orders> orders;

	private Scheduling scheduling;


	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

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

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(Scheduling scheduling) {
		this.scheduling = scheduling;
	}

	public Admission() {
	}

	public Admission(String brandId, String originId, Patient patient, List<Payments> payments, List<Questions> questions, String unitId, List<Orders> orders, Scheduling scheduling) {
		this.brandId = brandId;
		this.originId = originId;
		this.patient = patient;
		this.payments = payments;
		this.questions = questions;
		this.unitId = unitId;
		this.orders = orders;
		this.scheduling = scheduling;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Admission)) return false;
		Admission admission = (Admission) o;
		return Objects.equals(brandId, admission.brandId) &&
				Objects.equals(originId, admission.originId) &&
				Objects.equals(patient, admission.patient) &&
				Objects.equals(payments, admission.payments) &&
				Objects.equals(questions, admission.questions) &&
				Objects.equals(unitId, admission.unitId) &&
				Objects.equals(orders, admission.orders) &&
				Objects.equals(scheduling, admission.scheduling);
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId, originId, patient, payments, questions, unitId, orders, scheduling);
	}

	@Override
	public String toString() {
		return "Admission{" +
				"brandId='" + brandId + '\'' +
				", originId='" + originId + '\'' +
				", patient=" + patient +
				", payments=" + payments +
				", questions=" + questions +
				", unitId='" + unitId + '\'' +
				", orders=" + orders +
				", scheduling=" + scheduling +
				'}';
	}
}
