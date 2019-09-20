package br.com.dasa.mirror.api.assembler;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;

@JsonPropertyOrder({
        "status",
        "request"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FromToAdmissionResource extends ResourceSupport {

    private FromToAdmission.Status status;
    private RequestResource request;

    public FromToAdmission.Status getStatus() {
        return status;
    }

    public void setStatus(FromToAdmission.Status status) {
        this.status = status;
    }

    public RequestResource getRequest() {
        return request;
    }

    public void setRequest(RequestResource request) {
        this.request = request;
    }
}
