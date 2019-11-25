package br.com.dasa.mirror.api.service.impl;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.model.*;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    /**
     * Metodo responsável por sobrescrever exames da admissao do gliese com os exames do agendamento
     *
     * @param admission
     * @param medicalOrders
     */
    public List<MedicalOrders> sobrescreveExamesMedicalOrders(Admission admission, List<MedicalOrders> medicalOrders) {
        buscaMedicalOrdersPeloUuid(admission);

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
     * Metodo para buscar o idProduto do gliese-data e data provider.
     * @param
     * @return ProductTraslate[]
     */
    public ProductTraslate[] buscaMedicalOrdersPeloUuid(Admission admission) {
        LOGGER.log(Level.INFO, "INICIO busca Agendamento");
        ProductTraslate[] productTraslates = {};
        try {
            DefaultExchange defaultExchange = new DefaultExchange(camelContext);
            defaultExchange.setProperty("queryParam", queryBuilder.getQueryUuid(admission.getUuid()));
            Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER.getRoute(),
                    defaultExchange);
            ObjectMapper mapper = new ObjectMapper();
            if (resultExchange.getIn().getBody() != null) {
                productTraslates = mapper.readValue(resultExchange.getIn().getBody().toString(),
                        ProductTraslate[].class);
            } else {
                LOGGER.log(Level.INFO, "[INFO] metodo busca Agendamento: Não existe produto para esse exame:");
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "[ERRO] metodo busca agendamento: " + e.getStackTrace());
        }
        LOGGER.log(Level.INFO, "FIM do busca Agendamento");
        return productTraslates;
    }

}
