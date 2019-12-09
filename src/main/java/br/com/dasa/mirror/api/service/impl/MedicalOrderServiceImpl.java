package br.com.dasa.mirror.api.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Exams;
import br.com.dasa.mirror.api.model.MedicalOrders;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import br.com.dasa.mirror.api.service.MedicalOrderService;

@Service
public class MedicalOrderServiceImpl implements MedicalOrderService {

    private static final Logger LOGGER = Logger.getLogger(MedicalOrderServiceImpl.class.getName());

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    @Autowired
    QueryTranslate queryBuilder;

    public void gerenciaMedicalOrder(Admission admission) {
        List<MedicalOrders> listaResponseMedicalOrders =
                atualizaListaDeExamesMedicalOrders(admission, buscaMedicalOrdersPeloUuid(admission.getUuid()));
        atualizaMedialOrder(admission.getUuid(), listaResponseMedicalOrders);
    }

    /**
     * Metodo para buscar o idProduto do gliese-data e data provider.
     *
     * @param
     * @return listaMedicalOrders
     */
    public List<MedicalOrders> buscaMedicalOrdersPeloUuid(String uuid) {
        LOGGER.log(Level.INFO, "INICIO busca Agendamento");
        List<MedicalOrders> medicalOrders = null;
        try {
            DefaultExchange defaultExchange = new DefaultExchange(camelContext);
            defaultExchange.setProperty("queryParam", uuid);
            Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER_FIND.getRoute(),
                    defaultExchange);
            ObjectMapper mapper = new ObjectMapper();
            if (resultExchange.getIn().getBody() != null) {
                medicalOrders = mapper.readValue(resultExchange.getIn().getBody().toString(), new TypeReference<List<MedicalOrders>>() {
                });
            } else {
                LOGGER.log(Level.INFO, "[INFO] metodo busca Agendamento: Não existe produto para esse exame:");
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "[ERRO] metodo busca agendamento: " + e.getStackTrace());
        }
        LOGGER.log(Level.INFO, "FIM do busca Agendamento");
        return medicalOrders;
    }

    /**
     * Metodo responsável por sobrescrever exames da admissao do gliese com os exames do agendamento
     *
     * @param admission
     * @param responseMedicalOrders
     */
    public List<MedicalOrders> atualizaListaDeExamesMedicalOrders(Admission admission, List<MedicalOrders> responseMedicalOrders) {
        List<MedicalOrders> listaResponseMedicalOrders = responseMedicalOrders.stream()
                .filter(e -> e.getExams().removeAll(e.getExams()))
                .collect(Collectors.toList());

        for (MedicalOrders medicalOrder : admission.getMedicalOrders()) {
            for (Exams exame : medicalOrder.getExams()) {
                listaResponseMedicalOrders.stream()
                        .filter(s -> s.getExams().add(exame))
                        .collect(Collectors.toList());
            }
        }
        return listaResponseMedicalOrders;
    }

    /**
     * Metodo Responsável por Atualizar
     */
    public void atualizaMedialOrder(String uuid, List<MedicalOrders> listaResponseMedicalOrders) {
        LOGGER.log(Level.INFO, "INICIO envio ResponseMedicalOrders");
        Gson gson = new Gson();

        try {
            DefaultExchange defaultExchange = new DefaultExchange(camelContext);
            defaultExchange.setProperty("queryParam", uuid);
            defaultExchange.getIn().setBody(gson.toJson(listaResponseMedicalOrders));
            producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.getRoute(),
                    defaultExchange);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "[ERRO] metodo envia atualização medicaOrder: " + e.getStackTrace());
        }
        LOGGER.log(Level.INFO, "FIM do envio ResponseMedicalOrders");
    }

}
