package br.com.dasa.mirror.api.repository.translator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.dasa.mirror.api.model.from.to.admission.Exams;

@Component
public class QueryTranslate {

    @Value("${url.api.dasa.marca}")
    private String marca;

    @Value("${url.api.dasa.sistema}")
    private String sistema;

    private String TEMPLATE = "idSistema=#sistema&idMarca=#marca&idsOrigem=#exams";
    private final String PRODUCT_PRICE_TEMPLATE = "idBrand=#brand&idExams=#exams";

    private final String QUERY;
    private final String QUERY_PRODUTO;

    public QueryTranslate() {
        String jsonString = String.format(TEMPLATE);
        String jsonPreco = String.format(PRODUCT_PRICE_TEMPLATE);
        QUERY = jsonString;
        QUERY_PRODUTO = jsonPreco;
    }


    public String getQuery(Exams exams) {
        return QUERY.replaceAll("#exams", exams.getExameCode()).replaceAll("#marca", marca).replaceAll("#sistema", sistema);
    }

    public String getQueryProduto(String idBrand, String idExame) {
        return QUERY_PRODUTO.replaceAll("#brand", idBrand).replaceAll("#exams", idExame);
    }
}
