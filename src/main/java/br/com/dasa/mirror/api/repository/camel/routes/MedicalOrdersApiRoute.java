package br.com.dasa.mirror.api.repository.camel.routes;

import br.com.dasa.mirror.api.repository.camel.integrations.CamelHttpRequestFactory;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER;

@Component
public class MedicalOrdersApiRoute extends SpringRouteBuilder {

    @Autowired
    private CamelHttpRequestFactory camelHttpRequestFactory;

    @Value("${url.api.dasa.admission}")
    private String urlGlieseAdmissao;

    @Override
    public void configure() {
        CamelHttpRequestFactory.CamelHttpRequest findRequest = camelHttpRequestFactory.getRequest(ROUTE_LOAD_MEDICAL_ORDER.name());

        from(ROUTE_LOAD_MEDICAL_ORDER.getRoute()).routeId(ROUTE_LOAD_MEDICAL_ORDER.getRoute())
            .doTry()
                .toD(urlGlieseAdmissao + findRequest.getUri()+"${exchangeProperty.queryParam}/medicalorders")
                 .process(exchange -> {
                     String body = exchange.getIn().getBody(String.class);
                     exchange.getIn().setBody(body);
                 })
            .endDoTry()
            .doCatch(HttpOperationFailedException.class)
                .process(exchange -> exchange.getIn().setBody(Optional.empty()))
            .end();
    }
}
