package br.com.dasa.mirror.api.assembler;

import static java.lang.String.format;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.dasa.mirror.api.controller.FromToAdmissionEndpoint;
import br.com.dasa.mirror.api.model.from.to.admission.FromToAdmission;

@Component
public class FromToAdmissionResourceAssembler
		extends ResourceAssemblerSupport<FromToAdmission, FromToAdmissionResource> {

	private static final String CONSUMER_SELF = "/admission/consumer";
	private static final String OF_ADMISSION = "/admission/";

	public FromToAdmissionResourceAssembler() {
		super(FromToAdmissionEndpoint.class, FromToAdmissionResource.class);
	}

	@Override
	public FromToAdmissionResource toResource(FromToAdmission fromToAdmission) {
		final FromToAdmissionResource fromToAdmissionResource = new FromToAdmissionResource();
		fromToAdmissionResource.setStatus(fromToAdmission.getStatus());

		if (fromToAdmission.getJsonFromTo() != null) {
			fromToAdmissionResource.add(new Link(format(CONSUMER_SELF, fromToAdmission.getJsonFromTo())));
			fromToAdmissionResource.add(new Link(format(OF_ADMISSION), "owner"));
		}

		return fromToAdmissionResource;
	}
}
