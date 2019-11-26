package br.com.dasa.mirror.api.repository.camel.routes;

import br.com.dasa.mirror.api.repository.camel.integrations.CamelHttpRequestFactory;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.*;

@Component
public class MedicalOrdersApiRoute extends SpringRouteBuilder {

    @Autowired
    private CamelHttpRequestFactory camelHttpRequestFactory;

    @Value("${url.api.dasa.admission}")
    private String urlGlieseAdmissao;

    @Override
    public void configure() {
        CamelHttpRequestFactory.CamelHttpRequest findRequest = camelHttpRequestFactory.getRequest(ROUTE_LOAD_MEDICAL_ORDER_FIND.name());
        CamelHttpRequestFactory.CamelHttpRequest registryRequest = camelHttpRequestFactory.getRequest(ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.name());
        from(ROUTE_LOAD_MEDICAL_ORDER_FIND.getRoute()).routeId(ROUTE_LOAD_MEDICAL_ORDER_FIND.getRoute())
                .doTry()
                .toD(urlGlieseAdmissao + findRequest.getUri()+"${exchangeProperty.queryParam}"+"/medicalorders")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    exchange.getIn().setBody(body);
                })
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                .process(exchange -> exchange.getIn().setBody(Optional.empty()))
                .end();

        from(ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.getRoute()).routeId(ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.getRoute())
                .doTry()
                .toD(urlGlieseAdmissao + registryRequest.getUri()+"${exchangeProperty.queryParam}"+"/medicalorders")
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
