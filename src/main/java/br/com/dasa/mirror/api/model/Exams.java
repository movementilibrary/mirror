package br.com.dasa.mirror.api.model;

import java.util.List;
import java.util.Objects;

public class Exams {

	private List<AdditionalProperties> additionalProperties;

	private String examCode;

	private String price;

	private String realizationDate;

	private String sample;

	private String sampleDescription;

	private String status;

	private String unitRealizationId;

	private String uuid;

	public Exams() {
	}

	public Exams(List<AdditionalProperties> additionalProperties, String examCode, String price, String realizationDate, String sample, String sampleDescription, String status, String unitRealizationId, String uuid) {
		this.additionalProperties = additionalProperties;
		this.examCode = examCode;
		this.price = price;
		this.realizationDate = realizationDate;
		this.sample = sample;
		this.sampleDescription = sampleDescription;
		this.status = status;
		this.unitRealizationId = unitRealizationId;
		this.uuid = uuid;
	}

	public List<AdditionalProperties> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(String realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getSampleDescription() {
		return sampleDescription;
	}

	public void setSampleDescription(String sampleDescription) {
		this.sampleDescription = sampleDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnitRealizationId() {
		return unitRealizationId;
	}

	public void setUnitRealizationId(String unitRealizationId) {
		this.unitRealizationId = unitRealizationId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Exams)) return false;
		Exams exams = (Exams) o;
		return Objects.equals(additionalProperties, exams.additionalProperties) &&
				Objects.equals(examCode, exams.examCode) &&
				Objects.equals(price, exams.price) &&
				Objects.equals(realizationDate, exams.realizationDate) &&
				Objects.equals(sample, exams.sample) &&
				Objects.equals(sampleDescription, exams.sampleDescription) &&
				Objects.equals(status, exams.status) &&
				Objects.equals(unitRealizationId, exams.unitRealizationId) &&
				Objects.equals(uuid, exams.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalProperties, examCode, price, realizationDate, sample, sampleDescription, status, unitRealizationId, uuid);
	}

	@Override
	public String toString() {
		return "Exams{" +
				"additionalProperties=" + additionalProperties +
				", examCode='" + examCode + '\'' +
				", price='" + price + '\'' +
				", realizationDate='" + realizationDate + '\'' +
				", sample='" + sample + '\'' +
				", sampleDescription='" + sampleDescription + '\'' +
				", status='" + status + '\'' +
				", unitRealizationId='" + unitRealizationId + '\'' +
				", uuid='" + uuid + '\'' +
				'}';
	}
}
