package br.com.dasa.mirror.api.model;

import java.util.List;

public class Exams {

	private String realizationDate;

	private String sampleDescription;

	private String price;

	private String unitRealizationId;

	private String exameCode;

	private List<AdditionalProperties> additionalProperties;

	private String sample;

	private String status;

	private String uuid;

	public Exams() {
	}

	public Exams(String realizationDate, String sampleDescription, String price, String unitRealizationId,
			String exameCode, List<AdditionalProperties> additionalProperties,
			String sample, String status, String uuid) {
		this.realizationDate = realizationDate;
		this.sampleDescription = sampleDescription;
		this.price = price;
		this.unitRealizationId = unitRealizationId;
		this.exameCode = exameCode;
		this.additionalProperties = additionalProperties;
		this.sample = sample;
		this.status = status;
		this.uuid = uuid;
	}

	public String getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(String realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getSampleDescription() {
		return sampleDescription;
	}

	public void setSampleDescription(String sampleDescription) {
		this.sampleDescription = sampleDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUnitRealizationId() {
		return unitRealizationId;
	}

	public void setUnitRealizationId(String unitRealizationId) {
		this.unitRealizationId = unitRealizationId;
	}

	public String getExameCode() {
		return exameCode;
	}

	public void setExameCode(String exameCode) {
		this.exameCode = exameCode;
	}

	public List<AdditionalProperties> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
