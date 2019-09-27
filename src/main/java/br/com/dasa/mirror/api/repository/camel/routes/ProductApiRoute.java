package br.com.dasa.mirror.api.repository.camel.routes;

import br.com.dasa.mirror.api.repository.camel.integrations.CamelHttpRequestFactory;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.ROUTE_LOAD_PRODUTO_TRADUCAO;

@Component
public class ProductApiRoute extends SpringRouteBuilder {

    @Autowired
    private CamelHttpRequestFactory camelHttpRequestFactory;

    @Value("${url.api.dasa.dataprovider}")
    private String urlDataProvider;

    @Override
    public void configure() {
        CamelHttpRequestFactory.CamelHttpRequest findRequest = camelHttpRequestFactory.getRequest(ROUTE_LOAD_PRODUTO_TRADUCAO.name());

        from(ROUTE_LOAD_PRODUTO_TRADUCAO.getRoute()).routeId(ROUTE_LOAD_PRODUTO_TRADUCAO.getRoute())
            .setHeader("Authorization", simple("Basic ZHAtYXBpLWNvbnN1bWVyOkFJa2NvdkxWMU1aY1huaFJ4aUoyaVhiYTUyMXU1NWdk"))
            .setHeader("Postman-Token", simple("fc7d4d55-0c4b-4026-968f-acff9d407054"))
            .doTry()
                .toD(urlDataProvider + findRequest.getUri()+"${exchangeProperty.queryParam}")
                 .process(exchange -> {
                     String body = exchange.getIn().getBody(String.class);
                     //Optional<Traducao> traducao = JsonHelper.fromJson(body, Traducao.class);
                     exchange.getIn().setBody(body);
                 })
            .endDoTry()
            .doCatch(HttpOperationFailedException.class)
                .process(exchange -> exchange.getIn().setBody(Optional.empty()))
            .end();
    }
}
