package br.com.dasa.mirror.api.enumeration;

public enum  ApiEnunsExceptions  {

    ERRO_AO_BUSCAR_ARQUIVO("erro ao buscar arquivo");

    private String descricao;

     ApiEnunsExceptions(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
