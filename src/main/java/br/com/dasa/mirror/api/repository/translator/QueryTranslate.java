package br.com.dasa.mirror.api.repository.translator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.dasa.mirror.api.model.Exams;

@Component
public class QueryTranslate {

	@Value("${url.api.dasa.marca}")
	private String marca;

	@Value("${url.api.dasa.sistema}")
	private String sistema;

	private static final String TEMPLATE = "idSistema=#sistema&idMarca=#marca&idsOrigem=#exams";
	private static final String PRODUCT_PRICE_TEMPLATE = "idBrand=#brand&idExams=#exams";

	private String query = null;
	private String queryProduto = null;

	public QueryTranslate() {
		String jsonString = String.format(TEMPLATE);
		String jsonPreco = String.format(PRODUCT_PRICE_TEMPLATE);
		query = jsonString;
		queryProduto = jsonPreco;
	}

	public String getQuery(Exams exams) {
		return query.replace("#exams", exams.getExameCode()).replace("#marca", marca).replace("#sistema", sistema);
	}

	public String getQueryProduto(String idBrand, String idExame) {
		return queryProduto.replace("#brand", idBrand).replace("#exams", idExame);
	}
}
