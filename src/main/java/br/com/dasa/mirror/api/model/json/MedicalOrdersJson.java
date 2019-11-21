package br.com.dasa.mirror.api.model.json;

import java.util.List;

import br.com.dasa.mirror.api.model.MedicalOrders;

public class MedicalOrdersJson {

	private List<MedicalOrders> medicalOrders;

	public List<MedicalOrders> getMedicalOrders() {
		return medicalOrders;
	}

	public void setMedicalOrders(List<MedicalOrders> medicalOrders) {
		this.medicalOrders = medicalOrders;
	}

}
