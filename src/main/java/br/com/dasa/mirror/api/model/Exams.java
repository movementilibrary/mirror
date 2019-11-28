package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.Status;

import java.util.List;

public class Exams {


    private String uuid;

	private List<AdditionalProperties> additionalProperties;

	private String examCode;

	private String price;

	private String realizationDate;

	private String sample;

	private String sampleDescription;

	private Status status;

	private String unitRealization;


	public Exams() {
	}


    public Exams(String uuid, List<AdditionalProperties> additionalProperties, String examCode, String price, String realizationDate, String sample, String sampleDescription, Status status, String unitRealization) {
        this.uuid = uuid;
        this.additionalProperties = additionalProperties;
        this.examCode = examCode;
        this.price = price;
        this.realizationDate = realizationDate;
        this.sample = sample;
        this.sampleDescription = sampleDescription;
        this.status = status;
        this.unitRealization = unitRealization;
    }

    public String getUUid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUnitRealization() {
        return unitRealization;
    }

    public void setUnitRealization(String unitRealization) {
        this.unitRealization = unitRealization;
    }
}
