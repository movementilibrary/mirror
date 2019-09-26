package br.com.dasa.mirror.api.model;

public class Brand {

    private String nome;
    private Integer idDataProvider;
    private Integer idGliese;


    public Brand() {
    }

    public Brand(String nome, Integer idDataProvider, Integer idGliese) {
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

    public Integer getIdGliese() {
        return idGliese;
    }

    public void setIdGliese(Integer idGliese) {
        this.idGliese = idGliese;
    }
}
