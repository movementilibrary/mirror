package br.com.dasa.mirror.api.exceptions;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {

	private static final long serialVersionUID = -8413165984704612410L;
	private static String DEFAULT_MESSAGE = "Resource not found.";
	private Set<String> errors;

	public NotFoundException(String message, Object[] params) {
		super(message, params);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public NotFoundException(Set<String> errors) {
		super(StringUtils.join(errors, ", "));
		this.errors = errors;
	}

	public Set<String> getErrors() {
		return errors;
	}

}
