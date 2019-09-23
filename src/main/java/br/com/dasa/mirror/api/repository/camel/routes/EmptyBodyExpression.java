package br.com.dasa.mirror.api.repository.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;

public class EmptyBodyExpression implements Expression {

	@Override
	public <T> T evaluate(Exchange exchange, Class<T> type) {
		return null;
	}

	public static EmptyBodyExpression emptyBody() {
		return new EmptyBodyExpression();
	}

}
