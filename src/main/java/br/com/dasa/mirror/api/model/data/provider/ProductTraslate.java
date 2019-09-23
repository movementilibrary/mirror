package br.com.dasa.mirror.api.model.data.provider;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idProdutoOrigem",
        "idProduto",
        "idCorporativo"
})
public class ProductTraslate {

    @JsonProperty("idProdutoOrigem")
    private String idProdutoOrigem;
    @JsonProperty("idProduto")
    private long idProduto;
    @JsonProperty("idCorporativo")
    private long idCorporativo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idProdutoOrigem")
    public String getIdProdutoOrigem() {
        return idProdutoOrigem;
    }

    @JsonProperty("idProdutoOrigem")
    public void setIdProdutoOrigem(String idProdutoOrigem) {
        this.idProdutoOrigem = idProdutoOrigem;
    }

    @JsonProperty("idProduto")
    public long getIdProduto() {
        return idProduto;
    }

    @JsonProperty("idProduto")
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    @JsonProperty("idCorporativo")
    public long getIdCorporativo() {
        return idCorporativo;
    }

    @JsonProperty("idCorporativo")
    public void setIdCorporativo(long idCorporativo) {
        this.idCorporativo = idCorporativo;
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