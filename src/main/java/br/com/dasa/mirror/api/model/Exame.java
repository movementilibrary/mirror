package br.com.dasa.mirror.api.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "coberturaConvenio", "codigoNegociacao", "idProduto", "idReferenciaOrigem", "mnemonicoOrigem",
		"nome", "preco" })
public class Exame {

	@JsonProperty("coberturaConvenio")
	private boolean coberturaConvenio;
	@JsonProperty("codigoNegociacao")
	private String codigoNegociacao;
	@JsonProperty("idProduto")
	private long idProduto;
	@JsonProperty("idReferenciaOrigem")
	private String idReferenciaOrigem;
	@JsonProperty("mnemonicoOrigem")
	private String mnemonicoOrigem;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("preco")
	private long preco;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("coberturaConvenio")
	public boolean isCoberturaConvenio() {
		return coberturaConvenio;
	}

	@JsonProperty("coberturaConvenio")
	public void setCoberturaConvenio(boolean coberturaConvenio) {
		this.coberturaConvenio = coberturaConvenio;
	}

	@JsonProperty("codigoNegociacao")
	public String getCodigoNegociacao() {
		return codigoNegociacao;
	}

	@JsonProperty("codigoNegociacao")
	public void setCodigoNegociacao(String codigoNegociacao) {
		this.codigoNegociacao = codigoNegociacao;
	}

	@JsonProperty("idProduto")
	public long getIdProduto() {
		return idProduto;
	}

	@JsonProperty("idProduto")
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	@JsonProperty("idReferenciaOrigem")
	public String getIdReferenciaOrigem() {
		return idReferenciaOrigem;
	}

	@JsonProperty("idReferenciaOrigem")
	public void setIdReferenciaOrigem(String idReferenciaOrigem) {
		this.idReferenciaOrigem = idReferenciaOrigem;
	}

	@JsonProperty("mnemonicoOrigem")
	public String getMnemonicoOrigem() {
		return mnemonicoOrigem;
	}

	@JsonProperty("mnemonicoOrigem")
	public void setMnemonicoOrigem(String mnemonicoOrigem) {
		this.mnemonicoOrigem = mnemonicoOrigem;
	}

	@JsonProperty("nome")
	public String getNome() {
		return nome;
	}

	@JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonProperty("preco")
	public long getPreco() {
		return preco;
	}

	@JsonProperty("preco")
	public void setPreco(long preco) {
		this.preco = preco;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
