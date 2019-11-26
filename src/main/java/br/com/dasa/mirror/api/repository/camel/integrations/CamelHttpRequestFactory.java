package br.com.dasa.mirror.api.repository.camel.integrations;


import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.*;
import static org.springframework.http.HttpMethod.GET;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class CamelHttpRequestFactory {
    private static final String APPLICATION_JSON = "application/json";
    
    private static final String PRODUTOS_TRADUCAO = "/api/exams/getTranslate?";
    private static final String PRODUTO_PRECO = "/api/exams/unitDisponibility?";
    private static final String MEDICAL_ORDERS = "/api/admissions/";
    
    private static Map<String, CamelHttpRequest> camelHttpRequestMap;

    static {
        camelHttpRequestMap = new HashMap<>();

        putRequest(ROUTE_LOAD_PRODUTO_TRADUCAO.name(), PRODUTOS_TRADUCAO, GET.name(), APPLICATION_JSON, APPLICATION_JSON);
        putRequest(ROUTE_LOAD_PRODUTO_PRECO.name(), PRODUTO_PRECO, GET.name(), APPLICATION_JSON, APPLICATION_JSON);
        putRequest(ROUTE_LOAD_MEDICAL_ORDER.name(), MEDICAL_ORDERS, GET.name(), APPLICATION_JSON, APPLICATION_JSON);
    }

    public CamelHttpRequest getRequest(String requestKey) {
        return camelHttpRequestMap.get(requestKey);
    }

    private static void putRequest(String key, String uri, String method, String accept, String contentType) {
        camelHttpRequestMap.put(key, new CamelHttpRequest(uri, method, accept, contentType));
    }

    public static class CamelHttpRequest {
        private final String uri;
        private final String method;
        private final String accept;
        private final String contentType;

        public CamelHttpRequest(String uri, String method, String accept, String contentType) {
            this.uri = uri;
            this.method = method;
            this.accept = accept;
            this.contentType = contentType;
        }

        public String getUri() {
            return uri;
        }

        public String getMethod() {
            return method;
        }

        public String getAccept() {
            return accept;
        }

        public String getContentType() {
            return contentType;
        }
    }
}
