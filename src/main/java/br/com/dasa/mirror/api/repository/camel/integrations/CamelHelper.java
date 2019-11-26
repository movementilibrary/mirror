package br.com.dasa.mirror.api.repository.camel.integrations;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Thiago.Tavares
 * @since 26-11-2019
 */
@SuppressWarnings("unchecked")
public class CamelHelper {

    private static final String ONLY_KEEPS_URI = "^([a-z][a-z0-9+\\-.]*:(\\/\\/[^/?#]+)?)";

    public static Boolean hasException(Exchange exchange) {
        return ofNullable(exchange.getException())
                .orElse((Exception)exchange.getProperties().get("CamelExceptionCaught")) != null;
    }

    public static <T extends Exception> Optional<T> getException(Exchange exchange, Class<T> exception) {
        T camelExceptionCaught = (T) ofNullable(exchange.getException())
                .orElse((T) exchange.getProperties().get("CamelExceptionCaught"));

        if (camelExceptionCaught != null && camelExceptionCaught.getClass().equals(exception)) {
            return Optional.of(camelExceptionCaught);
        }

        return Optional.empty();
    }

    public static Long getElapsedTime(Exchange exchange) {
        return (Long) exchange.getProperties().getOrDefault("elapsedTime", 0l);
    }

    public static String getBody(Exchange exchange) {
        Optional<HttpOperationFailedException> httpException = getException(exchange, HttpOperationFailedException.class);
        if (httpException.isPresent()) {
            return httpException.get().getResponseBody();
        }
        return exchange.getIn().getBody(String.class);
    }

    public static Integer getStatus(Exchange exchange) {
        Optional<HttpOperationFailedException> httpException = getException(exchange, HttpOperationFailedException.class);
        if (httpException.isPresent()) {
            return httpException.get().getStatusCode();
        }
        Integer httpStatus = ofNullable(exchange.getIn().getHeader("CamelHttpResponseCode", Integer.class))
                .orElse(exchange.getOut() != null ? exchange.getOut().getHeader("CamelHttpResponseCode", Integer.class) : 0);

        return httpStatus == null ? 0 : httpStatus;
    }

    public static String getHttpMethod(Exchange exchange) {
        CamelHttpRequestFactory.CamelHttpRequest request = (CamelHttpRequestFactory.CamelHttpRequest) exchange.getProperties().get("http_request");
        Message message = ofNullable(exchange.getOut()).orElse(exchange.getIn());
        if (message.getHeader("CamelHttpMethod") == null) {
            return request.getMethod();
        }
        return message.getHeader("CamelHttpMethod") + "";
    }

    public static String getUri(Exchange exchange) {
        Optional<HttpOperationFailedException> exception = getException(exchange, HttpOperationFailedException.class);
        if (exception.isPresent()) {
            return exception.get().getUri();
        }
        final String camelToEndpoint = Optional.ofNullable((String)exchange.getProperty("CamelToEndpoint")).orElse("");

        return camelToEndpoint.replaceAll(ONLY_KEEPS_URI, StringUtils.EMPTY);
    }
}
