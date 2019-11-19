package br.com.dasa.mirror.api.service;

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
import br.com.dasa.mirror.api.model.ProductTraslate;
import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Exams;
import br.com.dasa.mirror.api.model.Orders;
import br.com.dasa.mirror.api.repository.AdmissaoRepository;
import br.com.dasa.mirror.api.repository.translator.FromToAdmissionTranslator;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;

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
	@Autowired
    private FindPriceExamsService findPriceExamsService;

	@Override
	public Optional<Admission> admissaoRepository(Admission admission) {
		LOGGER.log(Level.INFO, "Mensagem recebida com sucesso: " + admission.toString());
		Optional<Admission> result = fromToGlieseToV2(admission);
		return result;
	}

	public Optional<Admission> fromToGlieseToV2(Admission admission) {
		convertIdGlieseToIdDataProvider(admission);
		convertExamsToIdProduct(admission);
		return Optional.ofNullable(admission);
	}

	private Admission convertExamsToIdProduct(Admission admission) {
		for (Orders orders : admission.getOrders()) {
			for (Exams exams : orders.getExams()) {
				ProductTraslate[] productTraslates = findProdutoTraducao(exams);
				for (ProductTraslate productTraslate : productTraslates) {
					exams.setExameCode(String.valueOf(productTraslate.getIdProduto()));
					exams.setPrice(findPriceExamsService.findPriceToGlieseData(admission, exams));
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
			if(resultExchange.getIn().getBody() != null) {
				productTraslates = mapper.readValue(resultExchange.getIn().getBody().toString(), ProductTraslate[].class);
			} else {
				LOGGER.log(Level.INFO, "[INFO] metodo findProdutoTraducao: Não existe produto para esse exame:"+exams.getExameCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.INFO, "[ERRO] metodo findProdutoTraducao: " + e.getStackTrace());
		}
		LOGGER.log(Level.INFO, "FIM do findProdutoTraducao");
		return productTraslates;
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
