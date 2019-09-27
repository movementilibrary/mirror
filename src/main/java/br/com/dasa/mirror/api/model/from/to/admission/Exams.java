package br.com.dasa.mirror.api.model.from.to.admission;

public class Exams {

    private String realizationDate;

    private String sampleDescription;

    private String price;

    private String unitRealizationId;

    private String exameCode;

    private AdditionalProperties[] AdditionalProperties;

    private String sample;

    private String status;

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

    public AdditionalProperties[] getAdditionalProperties() {
        return AdditionalProperties;
    }

    public void setAdditionalProperties(AdditionalProperties[] AdditionalProperties) {
        this.AdditionalProperties = AdditionalProperties;
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

}
