package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.Status;
import com.amazonaws.services.ecs.model.ScaleUnit;

import java.util.List;
import java.util.Objects;

public class Exams {

	private String id;

	private String examCode;

	private String sample;

	private String sampleDescription;

	private Status status;

	private UnitRealization unitRealization;

	private String realizationDate;

	private String price;

	private List<AdditionalProperties> additionalProperties;


	public Exams() {
	}

	public Exams(String id, String examCode, String sample, String sampleDescription, Status status, UnitRealization unitRealization, String realizationDate, String price, List<AdditionalProperties> additionalProperties) {
		this.id = id;
		this.examCode = examCode;
		this.sample = sample;
		this.sampleDescription = sampleDescription;
		this.status = status;
		this.unitRealization = unitRealization;
		this.realizationDate = realizationDate;
		this.price = price;
		this.additionalProperties = additionalProperties;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UnitRealization getUnitRealization() {
		return unitRealization;
	}

	public void setUnitRealization(UnitRealization unitRealization) {
		this.unitRealization = unitRealization;
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
}
