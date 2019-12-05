package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.Status;

import java.util.List;
import java.util.Objects;

public class Exams {


    private String uuid;

    private String examCode;

    private String sample;

    private String sampleDescription;

    private String status;

    private String unitRealizationId;

    private String realizationDate;

    private String price;

    private List<AdditionalProperties> additionalProperties;


	public Exams() {
	}


    public Exams(String uuid, String examCode, String sample, String sampleDescription, String status, String unitRealizationId, String realizationDate, String price, List<AdditionalProperties> additionalProperties) {
        this.uuid = uuid;
        this.examCode = examCode;
        this.sample = sample;
        this.sampleDescription = sampleDescription;
        this.status = status;
        this.unitRealizationId = unitRealizationId;
        this.realizationDate = realizationDate;
        this.price = price;
        this.additionalProperties = additionalProperties;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
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

    public String getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(String realizationDate) {
        this.realizationDate = realizationDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<AdditionalProperties> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exams)) return false;
        Exams exams = (Exams) o;
        return Objects.equals(uuid, exams.uuid) &&
                Objects.equals(examCode, exams.examCode) &&
                Objects.equals(sample, exams.sample) &&
                Objects.equals(sampleDescription, exams.sampleDescription) &&
                status == exams.status &&
                Objects.equals(unitRealizationId, exams.unitRealizationId) &&
                Objects.equals(realizationDate, exams.realizationDate) &&
                Objects.equals(price, exams.price) &&
                Objects.equals(additionalProperties, exams.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, examCode, sample, sampleDescription, status, unitRealizationId, realizationDate, price, additionalProperties);
    }

    @Override
    public String toString() {
        return "Exams{" +
                "uuid='" + uuid + '\'' +
                ", examCode='" + examCode + '\'' +
                ", sample='" + sample + '\'' +
                ", sampleDescription='" + sampleDescription + '\'' +
                ", status=" + status +
                ", unitRealizationId='" + unitRealizationId + '\'' +
                ", realizationDate='" + realizationDate + '\'' +
                ", price='" + price + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
