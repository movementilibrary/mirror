package br.com.dasa.mirror.api.model;

import java.util.List;
import java.util.Objects;

public class Payments {
	private String method;

	private List<AdditionalProperties> additionalProperties;

	private String type;

	private String value;

	private String transactionId;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<AdditionalProperties> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Payments() {
	}

	public Payments(String method, List<AdditionalProperties> additionalProperties, String type, String value, String transactionId) {
		this.method = method;
		this.additionalProperties = additionalProperties;
		this.type = type;
		this.value = value;
		this.transactionId = transactionId;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Payments)) return false;
		Payments payments = (Payments) o;
		return Objects.equals(method, payments.method) &&
				Objects.equals(additionalProperties, payments.additionalProperties) &&
				Objects.equals(type, payments.type) &&
				Objects.equals(value, payments.value) &&
				Objects.equals(transactionId, payments.transactionId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(method, additionalProperties, type, value, transactionId);
	}


	@Override
	public String toString() {
		return "Payments{" +
				"method='" + method + '\'' +
				", additionalProperties=" + additionalProperties +
				", type='" + type + '\'' +
				", value='" + value + '\'' +
				", transactionId='" + transactionId + '\'' +
				'}';
	}
}
