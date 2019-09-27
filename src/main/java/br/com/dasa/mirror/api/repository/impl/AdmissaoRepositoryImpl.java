package br.com.dasa.mirror.api.repository.impl;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.model.data.provider.ProductTraslate;
import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.Exams;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;
import br.com.dasa.mirror.api.model.from.to.admission.Orders;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;
import br.com.dasa.mirror.api.repository.translator.FromToAdmissionTranslator;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class AdmissaoRepositoryImpl implements AdmissaoRepository {

    @Autowired
    private FromToAdmissionTranslator translator;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    @Autowired
    QueryTranslate queryBuilder;


    private static final Logger LOGGER = Logger.getLogger(AdmissaoRepositoryImpl.class.getName());

    @Override
    public Optional<FromToAdmission> admissaoRepository(Admission admission) {
        LOGGER.log(Level.INFO, "Mensagem recebida com sucesso: " + admission.toString());
        Optional<FromToAdmission> result = fromToGlieseToV2(admission);
        return result;
    }

    public Optional<FromToAdmission> fromToGlieseToV2(Admission admission) {
        fromToExams(admission);
        return Optional.ofNullable(translator.translateAdmission(admission));
    }

    private Optional<FromToAdmission> fromToExams(Admission admission) {
        for (Orders orders : admission.getOrders()) {
            for (Exams exams : orders.getExams()) {
                ProductTraslate[] productTraslates = findProdutoTraducao(exams);

                for (ProductTraslate productTraslate : productTraslates) {
                    long ipProduto = productTraslate.getIdProduto();

                }


//                double produtoPreco = findProductPrice(idMarca, idProduto);

            }
        }
        return null;
    }

    private ProductTraslate[] findProdutoTraducao(Exams exams) {
        DefaultExchange defaultExchange = new DefaultExchange(camelContext);
        defaultExchange.setProperty("queryParam", queryBuilder.getQuery(exams));
        Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_PRODUTO_TRADUCAO.getRoute(), defaultExchange);
        ObjectMapper mapper = new ObjectMapper();
        ProductTraslate[] productTraslates = {};
        try {
            productTraslates = mapper.readValue(resultExchange.getIn().getBody().toString(), ProductTraslate[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productTraslates;
    }

//    private double findProductPrice(int idMarca, int idProduto, int idUnidade) {
//        DefaultExchange defaultExchange = new DefaultExchange(camelContext);
//        defaultExchange.setProperty("queryParam", queryBuilder.getQueryProduto(idMarca, idProduto));
//        Exchange exchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_PRODUTO_PRECO.getRoute(), defaultExchange);
//        return Double.parseDouble();
//
//
//    }
}
