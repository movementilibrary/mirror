package br.com.dasa.mirror.api.model;

public class Patient {

	private String uuid;

	private String cip;

	private String mdmId;

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getMdmId() {
		return mdmId;
	}

	public void setMdmId(String mdmId) {
		this.mdmId = mdmId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Patient() {
	}

	public Patient(String uuid, String cip, String mdmId) {
		this.uuid = uuid;
		this.cip = cip;
		this.mdmId = mdmId;
	}



	@Override
	public String toString() {
		return "Patient [cip = " + cip + ", mdmId = " + mdmId + "]";
	}
}
