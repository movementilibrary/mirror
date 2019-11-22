package br.com.dasa.mirror.api.exceptions;

public class ApiExceptions extends RuntimeException {

	private static final long serialVersionUID = -4720855666987004409L;
	private final String descricaoErro;

    public ApiExceptions(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }

    public ApiExceptions(String s, String descricaoErro) {
        super(s);
        this.descricaoErro = descricaoErro;
    }

    public ApiExceptions(String s, Throwable throwable, String descricaoErro) {
        super(s, throwable);
        this.descricaoErro = descricaoErro;
    }

    public String getDescricaoErro() {
        return descricaoErro;
    }
}
