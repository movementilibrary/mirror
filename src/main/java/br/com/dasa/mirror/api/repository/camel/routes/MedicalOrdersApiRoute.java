package br.com.dasa.mirror.api.repository.camel.routes;

import br.com.dasa.mirror.api.repository.camel.integrations.CamelHttpRequestFactory;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.ROUTE_LOAD_PRODUTO_PRECO;

@Component
public class MedicalOrdersApiRoute extends SpringRouteBuilder {

    @Autowired
    private CamelHttpRequestFactory camelHttpRequestFactory;

    @Value("${url.api.dasa.admission}")
    private String urlGlieseData;

    @Override
    public void configure() {
        CamelHttpRequestFactory.CamelHttpRequest findRequest = camelHttpRequestFactory.getRequest(ROUTE_LOAD_PRODUTO_PRECO.name());

        from(ROUTE_LOAD_PRODUTO_PRECO.getRoute()).routeId(ROUTE_LOAD_PRODUTO_PRECO.getRoute())
            .doTry()
                .toD(urlGlieseData + findRequest.getUri()+"${exchangeProperty.queryParam}")
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
