package br.com.dasa.mirror.api.service.serviceImpl;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Exams;
import br.com.dasa.mirror.api.model.MedicalOrders;
import br.com.dasa.mirror.api.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalOrderService {

    public void buscaMedicalOrdersPeloUuid(Admission admission) {
        //TODO: buscar agendamento pelo UUID, envia para metodo sobrescreve Exames

    }


    /**
     * Metodo responsável por sobrescrever exames da admissao do gliese com os exames do agendamento
     *
     * @param admission
     * @param medicalOrders
     */
    public List<MedicalOrders> sobrescreveExamesMedicalOrders(Admission admission, List<MedicalOrders> medicalOrders) {

        List<MedicalOrders> listaMedicalOrders = medicalOrders.stream()
                .filter(e -> e.getExams().removeAll(e.getExams()))
                .collect(Collectors.toList());

        for (Orders order : admission.getOrders()) {
            for (Exams exame : order.getExams()) {

                listaMedicalOrders.stream()
                        .filter(s -> s.getExams().add(exame))
                        .collect(Collectors.toList());
            }

        }
        return listaMedicalOrders;

    }

}
