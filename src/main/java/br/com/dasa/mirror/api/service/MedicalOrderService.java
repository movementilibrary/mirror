package br.com.dasa.mirror.api.service;

import java.util.List;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.MedicalOrders;

public interface MedicalOrderService {

	public void gerenciaMedicalOrder(Admission admission);

	public List<MedicalOrders> buscaMedicalOrdersPeloUuid(String uuid);

	public List<MedicalOrders> atualizaListaDeExamesMedicalOrders(Admission admission,
			List<MedicalOrders> responseMedicalOrders);

	public void atualizaMedialOrder(String uuid, List<MedicalOrders> listaResponseMedicalOrders);
}
