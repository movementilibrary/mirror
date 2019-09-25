package br.com.dasa.mirror.api.model.from.to.admission;

public class Patient {

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

	@Override
	public String toString() {
		return "Patient [cip = " + cip + ", mdmId = " + mdmId + "]";
	}
}
