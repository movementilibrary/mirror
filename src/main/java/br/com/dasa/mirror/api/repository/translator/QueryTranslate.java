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

    private final String QUERY;

    public QueryTranslate() {
        String jsonString = String.format(TEMPLATE);
        QUERY = jsonString;
    }

    public String getQuery(Exams exams) {
        return QUERY.replaceAll("#exams", exams.getExameCode()).replaceAll("#marca", marca).replaceAll("#sistema", sistema);
    }
}
