package br.com.dasa.mirror.api.service.impl;

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
import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Brand;
import br.com.dasa.mirror.api.model.Exams;
import br.com.dasa.mirror.api.model.MedicalOrders;
import br.com.dasa.mirror.api.model.ProductTraslate;
import br.com.dasa.mirror.api.model.Unit;
import br.com.dasa.mirror.api.repository.translator.QueryTranslate;
import br.com.dasa.mirror.api.service.AdmissaoService;
import br.com.dasa.mirror.api.service.BrandService;
import br.com.dasa.mirror.api.service.MedicalOrderService;
import br.com.dasa.mirror.api.service.UnitService;

@Repository
public class AdmissaoServiceImpl implements AdmissaoService {

	private static final Logger LOGGER = Logger.getLogger(AdmissaoServiceImpl.class.getName());
	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private CamelContext camelContext;

	@Autowired
	QueryTranslate queryBuilder;

	@Autowired
	private UnitService unitService;

	@Autowired
	private MedicalOrderService medicalOrderService;

	@Autowired
	private BrandService brandService;
	
	@Override
	public Optional<Admission> admissaoValues(Admission admission) {
		LOGGER.log(Level.INFO, "Mensagem recebida com sucesso");
		return fromToGlieseToV2(admission);
	}

	public Optional<Admission> fromToGlieseToV2(Admission admission) {
		convertIdGlieseToIdDataProvider(admission);
		convertExamsToIdProduct(admission);
		medicalOrderService.gerenciaMedicalOrder(admission);
		return Optional.ofNullable(admission);
	}

	private Admission convertExamsToIdProduct(Admission admission) {
		for (MedicalOrders medicalOrder : admission.getMedicalOrders()) {
			for (Exams exams : medicalOrder.getExams()) {
				ProductTraslate[] productTraslates = findProdutoTraducao(exams);
				for (ProductTraslate productTraslate : productTraslates) {
					exams.setExamCode(String.valueOf(productTraslate.getIdProduto()));
				}
			}
		}
		return admission;
	}

	/**
	 * Metodo para buscar o idProduto do gliese-data e data provider.
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
			if (resultExchange.getIn().getBody() != null) {
				productTraslates = mapper.readValue(resultExchange.getIn().getBody().toString(),
						ProductTraslate[].class);
			} else {
				LOGGER.log(Level.INFO, "[INFO] metodo findProdutoTraducao: Não existe produto para esse exame:"
						+ exams.getExamCode());
			}
		} catch (Exception e) {
			LOGGER.log(Level.INFO, "[ERRO] metodo findProdutoTraducao: " + e.getStackTrace());
		}
		LOGGER.log(Level.INFO, "FIM do findProdutoTraducao");
		return productTraslates;
	}

	/**
	 * Metodo resposável por receber Id Unit do Gliese e converter para Id Unit Data
	 * Provider
	 * @author michel marciano
	 * @param admission
	 * @return Admission
	 */
	public Admission convertIdGlieseToIdDataProvider(Admission admission) {
		Brand brandId = brandService.convertBrandGlieseToBrandDataProvider(admission.getBrandId());
		Unit unitId = unitService.convertUnityGlieseToUnityDataProvider(admission.getUnitId());
		admission.setBrandId(brandId.getIdDataProvider().toString());
		admission.setUnitId(unitId.getIdDataProvider().toString());
		return admission;
	}
}
