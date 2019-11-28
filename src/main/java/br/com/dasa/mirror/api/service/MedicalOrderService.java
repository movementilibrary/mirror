package br.com.dasa.mirror.api.service;

import java.util.List;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.ResponseMedicalOrders;

public interface MedicalOrderService {

	public void gerenciaMedicalOrder(Admission admission);

	public List<ResponseMedicalOrders> buscaMedicalOrdersPeloUuid(String uuid);

	public List<ResponseMedicalOrders> atualizaListaDeExamesMedicalOrders(Admission admission,
			List<ResponseMedicalOrders> responseMedicalOrders);

	public void atualizaMedialOrder(String uuid, List<ResponseMedicalOrders> listaResponseMedicalOrders);
}
