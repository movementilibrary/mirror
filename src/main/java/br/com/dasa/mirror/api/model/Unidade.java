package br.com.dasa.mirror.api.model;

public class Unidade {

    private String nome;
    private Integer idDataProvider;
    private String idGliese;


    public Unidade() {
    }

    public Unidade(String nome, Integer idDataProvider, String idGliese) {
        this.nome = nome;
        this.idDataProvider = idDataProvider;
        this.idGliese = idGliese;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdDataProvider() {
        return idDataProvider;
    }

    public void setIdDataProvider(Integer idDataProvider) {
        this.idDataProvider = idDataProvider;
    }

    public String getIdGliese() {
        return idGliese;
    }

    public void setIdGliese(String idGliese) {
        this.idGliese = idGliese;
    }
}
