package br.com.dasa.mirror.api.repository.impl;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.exceptions.ApiExceptions;
import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.Exame;
import br.com.dasa.mirror.api.model.from.to.admission.ExameJson;
import br.com.dasa.mirror.api.model.from.to.admission.Exams;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.logging.Level;

@Repository
public class FindPriceExams {


    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CamelContext camelContext;

    @Autowired
    QueryTranslate queryBuilder;


    private static final Logger LOGGER = LoggerFactory.getLogger(FindPriceExams.class);


    public String findPriceToGlieseData(Admission admission, Exams exams) {
        String preco = findProdutoPreco(admission.getBrandId(), exams.getExameCode());
        return preco;
    }

    public String findProdutoPreco(String idBrand, String idExam) {

        LOGGER.info("INICIO do findProdutoPreco idBrand:" + idBrand + " idExam:" + idExam);

        ExameJson[] exameJsons = {};

        String preco = "";
        String descricaoExame;

        try {
            DefaultExchange defaultExchange = new DefaultExchange(camelContext);
            defaultExchange.setProperty("queryParam", queryBuilder.getQueryProduto(idBrand, idExam));
            Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_PRODUTO_PRECO.getRoute(),
                    defaultExchange);

            ObjectMapper mapper = new ObjectMapper();
            exameJsons = mapper.readValue(resultExchange.getIn().getBody().toString(), ExameJson[].class);


            for (ExameJson exameJson : exameJsons) {
                for (Exame exame : exameJson.getExames()) {
                    preco = String.valueOf(exame.getPreco());
                    descricaoExame = exame.getNome();

                }

            }

        } catch (ApiExceptions | IOException e) {
            LOGGER.error("[ERRO] metodo findProdutoPreco: " + e.getMessage());
            throw new ApiExceptions(null + e.getMessage());
        }

        return preco;
    }
}
