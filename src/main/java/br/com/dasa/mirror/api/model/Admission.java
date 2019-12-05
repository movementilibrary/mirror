package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.AdmissionStatus;

import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Thiago.Tavares
 *
 */
public class Admission {

    private String originId;

    private String unitId;

    private String cip;

    private String mdmId;

	private String uuid;

    private AdmissionStatus admissionStatus;

	private String brandId;

	private List<Payments> payments;

	private List<Questions> questions;

	private Scheduling scheduling;

	private List<MedicalOrders> medicalOrders;


	public Admission() {
	}


	public Admission(String originId, String unitId, String cip, String mdmId, String uuid, AdmissionStatus admissionStatus, String brandId, List<Payments> payments, List<Questions> questions, Scheduling scheduling, List<MedicalOrders> medicalOrders) {
		this.originId = originId;
		this.unitId = unitId;
		this.cip = cip;
		this.mdmId = mdmId;
		this.uuid = uuid;
		this.admissionStatus = admissionStatus;
		this.brandId = brandId;
		this.payments = payments;
		this.questions = questions;
		this.scheduling = scheduling;
		this.medicalOrders = medicalOrders;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getMdmId() {
		return mdmId;
	}

	public void setMdmId(String mdmId) {
		this.mdmId = mdmId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
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

	public Scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(Scheduling scheduling) {
		this.scheduling = scheduling;
	}

	public List<MedicalOrders> getMedicalOrders() {
		return medicalOrders;
	}

	public void setMedicalOrders(List<MedicalOrders> medicalOrders) {
		this.medicalOrders = medicalOrders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Admission)) return false;
		Admission admission = (Admission) o;
		return Objects.equals(originId, admission.originId) &&
				Objects.equals(unitId, admission.unitId) &&
				Objects.equals(cip, admission.cip) &&
				Objects.equals(mdmId, admission.mdmId) &&
				Objects.equals(uuid, admission.uuid) &&
				admissionStatus == admission.admissionStatus &&
				Objects.equals(brandId, admission.brandId) &&
				Objects.equals(payments, admission.payments) &&
				Objects.equals(questions, admission.questions) &&
				Objects.equals(scheduling, admission.scheduling) &&
				Objects.equals(medicalOrders, admission.medicalOrders);
	}

	@Override
	public int hashCode() {
		return Objects.hash(originId, unitId, cip, mdmId, uuid, admissionStatus, brandId, payments, questions, scheduling, medicalOrders);
	}


	@Override
	public String toString() {
		return "Admission{" +
				"originId='" + originId + '\'' +
				", unitId='" + unitId + '\'' +
				", cip='" + cip + '\'' +
				", mdmId='" + mdmId + '\'' +
				", uuid='" + uuid + '\'' +
				", admissionStatus=" + admissionStatus +
				", brandId='" + brandId +
				", payments=" + payments +
				", questions=" + questions +
				", scheduling=" + scheduling +
				", medicalOrders=" + medicalOrders +
				'}';
	}
}
