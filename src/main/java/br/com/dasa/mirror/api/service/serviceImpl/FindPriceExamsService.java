package br.com.dasa.mirror.api.service.serviceImpl;

import java.io.IOException;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.exceptions.ApiExceptions;
import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Exame;
import br.com.dasa.mirror.api.model.Exams;
import br.com.dasa.mirror.api.model.ProductPrice;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import org.springframework.stereotype.Service;

@Service
public class FindPriceExamsService {

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private CamelContext camelContext;

	@Autowired
	QueryTranslate queryBuilder;

	private static final Logger LOGGER = LoggerFactory.getLogger(FindPriceExamsService.class);

	public String findPriceToGlieseData(Admission admission, Exams exams) {
		String preco = findProdutoPreco(admission.getBrandId(), exams.getExameCode());
		return preco;
	}

	public String findProdutoPreco(String idBrand, String idExam) {
		LOGGER.info("INICIO do findProdutoPreco idBrand:" + idBrand + " idExam:" + idExam);

		ProductPrice[] productPrices = {};
		String preco = "";
		try {
			DefaultExchange defaultExchange = new DefaultExchange(camelContext);
			defaultExchange.setProperty("queryParam", queryBuilder.getQueryProduto(idBrand, idExam));
			Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_PRODUTO_PRECO.getRoute(),
					defaultExchange);

			ObjectMapper mapper = new ObjectMapper();
			if (resultExchange.getIn().getBody() != null) {
				productPrices = mapper.readValue(resultExchange.getIn().getBody().toString(), ProductPrice[].class);
				for (ProductPrice productPrice : productPrices) {
					for (Exame exame : productPrice.getExames()) {
						preco = String.valueOf(exame.getPreco());
					}
				}
			} else {
				LOGGER.info("[INFO] metodo findProdutoPreco: O preço do exame não foi encontrado.");
			}
		} catch (ApiExceptions | IOException e) {
			LOGGER.error("[ERRO] metodo findProdutoPreco: " + e.getMessage());
			throw new ApiExceptions(null + e.getMessage());
		}
		return preco;
	}
}
