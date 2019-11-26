package br.com.dasa.mirror.api.repository.camel.routes;

import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER_FIND;
import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.ROUTE_LOAD_MEDICAL_ORDER_REGISTRY;

import java.util.Optional;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import br.com.dasa.mirror.api.repository.camel.integrations.CamelHttpRequestFactory;

@Component
public class MedicalOrdersApiRoute extends SpringRouteBuilder {

    @Autowired
    private CamelHttpRequestFactory camelHttpRequestFactory;

    @Value("${url.api.dasa.admission}")
    private String urlGlieseAdmissao;

    @Override
    public void configure() {
    	
        CamelHttpRequestFactory.CamelHttpRequest request = camelHttpRequestFactory.getRequest(ROUTE_LOAD_MEDICAL_ORDER_FIND.name());
        
        from(ROUTE_LOAD_MEDICAL_ORDER_FIND.getRoute()).routeId(ROUTE_LOAD_MEDICAL_ORDER_FIND.getRoute())
                .doTry()
                .toD(urlGlieseAdmissao + request.getUri()+"${exchangeProperty.queryParam}"+"/medicalorders")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    exchange.getIn().setBody(body);
                })
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                .process(exchange -> exchange.getIn().setBody(Optional.empty()))
                .end();

        from(ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.getRoute()).routeId(ROUTE_LOAD_MEDICAL_ORDER_REGISTRY.getRoute())
	        .setHeader(Exchange.HTTP_METHOD, constant(HttpMethod.PUT.name()))
	        .setHeader(Exchange.CONTENT_TYPE, constant(request.getContentType()))
                .doTry()
                .toD(urlGlieseAdmissao + request.getUri()+"${exchangeProperty.queryParam}"+"/medicalorders")
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
