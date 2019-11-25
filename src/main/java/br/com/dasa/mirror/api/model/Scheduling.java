package br.com.dasa.mirror.api.model;

import java.util.List;
import java.util.Objects;

public class Scheduling {

	private String date;

	private List<AdditionalProperties> additionalProperties;
	private String schedulingId;


	public Scheduling() {
	}


	public Scheduling(String date, List<AdditionalProperties> additionalProperties, String schedulingId) {
		this.date = date;
		this.additionalProperties = additionalProperties;
		this.schedulingId = schedulingId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<AdditionalProperties> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public String getSchedulingId() {
		return schedulingId;
	}

	public void setSchedulingId(String schedulingId) {
		this.schedulingId = schedulingId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Scheduling)) return false;
		Scheduling that = (Scheduling) o;
		return Objects.equals(date, that.date) &&
				Objects.equals(additionalProperties, that.additionalProperties) &&
				Objects.equals(schedulingId, that.schedulingId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, additionalProperties, schedulingId);
	}

	@Override
	public String toString() {
		return "Scheduling{" +
				"date='" + date + '\'' +
				", additionalProperties=" + additionalProperties +
				", schedulingId='" + schedulingId + '\'' +
				'}';
	}
}
