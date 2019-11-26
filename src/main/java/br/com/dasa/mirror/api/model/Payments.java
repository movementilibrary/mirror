package br.com.dasa.mirror.api.model;

import br.com.dasa.mirror.api.enumeration.PaymentMethod;
import br.com.dasa.mirror.api.enumeration.PaymentType;

import java.util.List;
import java.util.Objects;

public class Payments {

	private PaymentMethod method;

	private List<AdditionalProperties> additionalProperties;

	private PaymentType type;

	private String value;

	private String transactionId;

	private String uuid;


	public Payments() {
	}

	public Payments(PaymentMethod method, List<AdditionalProperties> additionalProperties, PaymentType type, String value, String transactionId, String uuid) {
		this.method = method;
		this.additionalProperties = additionalProperties;
		this.type = type;
		this.value = value;
		this.transactionId = transactionId;
		this.uuid = uuid;
	}

	public PaymentMethod getMethod() {
		return method;
	}

	public void setMethod(PaymentMethod method) {
		this.method = method;
	}

	public List<AdditionalProperties> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(List<AdditionalProperties> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
				Objects.equals(transactionId, payments.transactionId) &&
				Objects.equals(uuid, payments.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(method, additionalProperties, type, value, transactionId, uuid);
	}

	@Override
	public String toString() {
		return "Payments{" +
				"method='" + method + '\'' +
				", additionalProperties=" + additionalProperties +
				", type='" + type + '\'' +
				", value='" + value + '\'' +
				", transactionId='" + transactionId + '\'' +
				", uuid='" + uuid + '\'' +
				'}';
	}
}
