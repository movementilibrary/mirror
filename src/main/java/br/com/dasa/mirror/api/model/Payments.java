package br.com.dasa.mirror.api.model;

public class Payments {
	private String method;

	private AdditionalProperties[] additionalProperties;

	private String type;

	private String value;

	private String transactionId;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public AdditionalProperties[] getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(AdditionalProperties[] additionalProperties) {
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

	@Override
	public String toString() {
		return "Payments [method = " + method + ", additionalProperties = " + additionalProperties + ", type = " + type
				+ ", value = " + value + ", transactionId = " + transactionId + "]";
	}
}
