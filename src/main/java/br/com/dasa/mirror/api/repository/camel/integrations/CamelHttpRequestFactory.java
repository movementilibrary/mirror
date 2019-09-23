package br.com.dasa.mirror.api.repository.camel.integrations;


import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

import static br.com.dasa.mirror.api.enumeration.CamelRoutesEnum.ROUTE_LOAD_PRODUTO_TRADUCAO;
import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.http.HttpMethod.*;

@Component
public class CamelHttpRequestFactory {
    private static final String APPLICATION_JSON = "application/json";
    private static final String TEXT_PLAIN = "text/plain";
    private static final String APPLICATION_XML = "application/xml";
    private static final String APPLICATION_FORM_ENCODED = "application/x-www-form-urlencoded";

    private static final String PRODUTOS_TRADUCAO = "/api/v1/produtos/traducao?";

    private static Map<String, CamelHttpRequest> camelHttpRequestMap;

    static {
        camelHttpRequestMap = new HashMap<>();

        putRequest(ROUTE_LOAD_PRODUTO_TRADUCAO.name(), PRODUTOS_TRADUCAO, GET.name(), APPLICATION_JSON, APPLICATION_JSON);
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
