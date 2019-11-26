package br.com.dasa.mirror.api.service.impl;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.model.*;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MedicalOrderService {

    private static final Logger LOGGER = Logger.getLogger(MedicalOrderService.class.getName());

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    @Autowired
    QueryTranslate queryBuilder;


    public void gerenciaMedicalOrder(Admission admission) {
        List<MedicalOrders> listaMedicalOrders =
                atualizaExamesMedicalOrders(admission, buscaMedicalOrdersPeloUuid(admission.getUuid()));
        atualizaMedialOrder(listaMedicalOrders);
    }


    /**
     * Metodo para buscar o idProduto do gliese-data e data provider.
     *
     * @param
     * @return listaMedicalOrders
     */
    public List<MedicalOrders> buscaMedicalOrdersPeloUuid(String uuid) {
        LOGGER.log(Level.INFO, "INICIO busca Agendamento");
        List<MedicalOrders> listaMedicalOrders = null;
        try {
            DefaultExchange defaultExchange = new DefaultExchange(camelContext);
            defaultExchange.setProperty("queryParam", uuid);
            Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER_FIND.getRoute(),
                    defaultExchange);
            ObjectMapper mapper = new ObjectMapper();
            if (resultExchange.getIn().getBody() != null) {
                listaMedicalOrders = mapper.readValue(resultExchange.getIn().getBody().toString(), new TypeReference<List<MedicalOrders>>() {
                });
            } else {
                LOGGER.log(Level.INFO, "[INFO] metodo busca Agendamento: Não existe produto para esse exame:");
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "[ERRO] metodo busca agendamento: " + e.getStackTrace());
        }
        LOGGER.log(Level.INFO, "FIM do busca Agendamento");
        return listaMedicalOrders;
    }

    /**
     * Metodo responsável por sobrescrever exames da admissao do gliese com os exames do agendamento
     *
     * @param admission
     * @param medicalOrders
     */
    public List<MedicalOrders> atualizaExamesMedicalOrders(Admission admission, List<MedicalOrders> medicalOrders) {

        List<MedicalOrders> listaMedicalOrders = medicalOrders.stream()
                .filter(e -> e.getExams().removeAll(e.getExams()))
                .collect(Collectors.toList());

        for (MedicalOrders medicalOrder : admission.getMedicalOrders()) {
            for (Exams exame : medicalOrder.getExams()) {

                listaMedicalOrders.stream()
                        .filter(s -> s.getExams().add(exame))
                        .collect(Collectors.toList());
            }

        }
        return listaMedicalOrders;
    }

    /**
     * Metodo Responsável por Atualizar
     */

    public void atualizaMedialOrder(List<MedicalOrders> listaMedicalOrders) {
        LOGGER.log(Level.INFO, "INICIO envio MedicalOrders");

        for (MedicalOrders medicaOrder : listaMedicalOrders) {

            try {
                DefaultExchange defaultExchange = new DefaultExchange(camelContext);
                defaultExchange.setProperty("queryParam", medicaOrder.getId());
                producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.getRoute(), defaultExchange);


            } catch (Exception e) {
                LOGGER.log(Level.INFO, "[ERRO] metodo envia atualização medicaOrder: " + e.getStackTrace());
            }
            LOGGER.log(Level.INFO, "FIM do envio MedicalOrders");

        }
    }


}
