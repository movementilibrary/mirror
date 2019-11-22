package br.com.dasa.mirror.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "exames", "idUnidade", "idUnidadeOrigem", "nomeUnidade" })
public class ProductPrice {

	@JsonProperty("exames")
	private List<Exame> exames = null;
	@JsonProperty("idUnidade")
	private long idUnidade;
	@JsonProperty("idUnidadeOrigem")
	private String idUnidadeOrigem;
	@JsonProperty("nomeUnidade")
	private String nomeUnidade;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("exames")
	public List<Exame> getExames() {
		return exames;
	}

	@JsonProperty("exames")
	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	@JsonProperty("idUnidade")
	public long getIdUnidade() {
		return idUnidade;
	}

	@JsonProperty("idUnidade")
	public void setIdUnidade(long idUnidade) {
		this.idUnidade = idUnidade;
	}

	@JsonProperty("idUnidadeOrigem")
	public String getIdUnidadeOrigem() {
		return idUnidadeOrigem;
	}

	@JsonProperty("idUnidadeOrigem")
	public void setIdUnidadeOrigem(String idUnidadeOrigem) {
		this.idUnidadeOrigem = idUnidadeOrigem;
	}

	@JsonProperty("nomeUnidade")
	public String getNomeUnidade() {
		return nomeUnidade;
	}

	@JsonProperty("nomeUnidade")
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
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