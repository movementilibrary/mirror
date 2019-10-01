package br.com.dasa.mirror.api.repository.impl;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dasa.mirror.api.enumeration.CamelRoutesEnum;
import br.com.dasa.mirror.api.model.data.provider.ProductTraslate;
import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.model.from.to.admission.Exame;
import br.com.dasa.mirror.api.model.from.to.admission.Exams;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;
import br.com.dasa.mirror.api.model.from.to.admission.Orders;
import br.com.dasa.mirror.api.model.from.to.admission.ProductPrice;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;
import br.com.dasa.mirror.api.repository.translator.FromToAdmissionTranslator;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import br.com.dasa.mirror.api.service.impl.BrandService;
import br.com.dasa.mirror.api.service.impl.UnitService;

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

	@Autowired
	private UnitService unitService;

	private static final Logger LOGGER = Logger.getLogger(AdmissaoRepositoryImpl.class.getName());
	@Autowired
	private BrandService brandService;

	@Override
	public Optional<FromToAdmission> admissaoRepository(Admission admission) {
		LOGGER.log(Level.INFO, "Mensagem recebida com sucesso: " + admission.toString());
		Optional<FromToAdmission> result = fromToGlieseToV2(admission);
		return result;
	}

	public Optional<FromToAdmission> fromToGlieseToV2(Admission admission) {
		convertIdGlieseToIdDataProvider(admission);
		convertExamsToIdProduct(admission);
		return Optional.ofNullable(translator.translateAdmission(admission));
	}

	private Admission convertExamsToIdProduct(Admission admission) {
		for (Orders orders : admission.getOrders()) {
			for (Exams exams : orders.getExams()) {
				ProductTraslate[] productTraslates = findProdutoTraducao(exams);
				for (ProductTraslate productTraslate : productTraslates) {
					exams.setExameCode(String.valueOf(productTraslate.getIdProduto()));
					exams.setPrice(findProdutoPreco(admission.getBrandId(), exams.getExameCode()));
				}
			}
		}
		return admission;
	}

	/**
	 * Metodo para buscar o idProduto do gliese-data e data provider.
	 * 
	 * @param exams
	 * @return ProductTraslate[]
	 */
	private ProductTraslate[] findProdutoTraducao(Exams exams) {
		LOGGER.log(Level.INFO, "INICIO do findProdutoTraducao");
		ProductTraslate[] productTraslates = {};
		try {
			DefaultExchange defaultExchange = new DefaultExchange(camelContext);
			defaultExchange.setProperty("queryParam", queryBuilder.getQuery(exams));
			Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_PRODUTO_TRADUCAO.getRoute(),
					defaultExchange);
			ObjectMapper mapper = new ObjectMapper();
			productTraslates = mapper.readValue(resultExchange.getIn().getBody().toString(), ProductTraslate[].class);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.INFO, "[ERRO] metodo findProdutoTraducao: " + e.getStackTrace());
		}
		LOGGER.log(Level.INFO, "FIM do findProdutoTraducao");
		return productTraslates;
	}
	
	/**
	 * Metodo para buscar o preco do gliese-data e data provider.
	 * 
	 * @param exams
	 * @return ProductTraslate[]
	 */
	private String findProdutoPreco(String idBrand, String idExam) {
		LOGGER.log(Level.INFO, "INICIO do findProdutoPreco idBrand:"+idBrand+" idExam:"+idExam);
		ProductPrice[] productPrices = {};
		String preco = "";
		try {
			DefaultExchange defaultExchange = new DefaultExchange(camelContext);
			defaultExchange.setProperty("queryParam", queryBuilder.getQueryProduto(idBrand, idExam));
			Exchange resultExchange = producerTemplate.send(CamelRoutesEnum.ROUTE_LOAD_PRODUTO_PRECO.getRoute(),
					defaultExchange);
			ObjectMapper mapper = new ObjectMapper();
			productPrices = mapper.readValue(resultExchange.getIn().getBody().toString(), ProductPrice[].class);
			for (ProductPrice productPrice : productPrices) {
				for (Exame exame : productPrice.getExames()) {
					 preco = String.valueOf(exame.getPreco());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.INFO, "[ERRO] metodo findProdutoPreco: " + e.getStackTrace());
		}
		LOGGER.log(Level.INFO, "FIM do findProdutoPreco - Preco: "+preco);
		return preco;
	}

	/**
	 * Metodo resposável por receber Id Unit do Gliese e converter para Id Unit Data
	 * Provider
	 * 
	 * @author michel marciano
	 * @param admission
	 * @return
	 */
	public Admission convertIdGlieseToIdDataProvider(Admission admission) {
		admission.setBrandId(brandService.convertBrandGlieseToBrandDataProvider(admission.getBrandId()).toString());
		admission.setUnitId(unitService.convertUnityGlieseToUnityDataProvider(admission.getUnitId()).toString());
		return admission;
	}

}
