package br.com.dasa.mirror.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.mirror.api.assembler.FromToAdmissionResource;
import br.com.dasa.mirror.api.assembler.FromToAdmissionResourceAssembler;
import br.com.dasa.mirror.api.commons.NotFoundException;
import br.com.dasa.mirror.api.model.from.to.admission.Admission;
import br.com.dasa.mirror.api.service.AdmissaoService;

@RestController
public class FromToAdmissionEndpoint {

	@Autowired
	private FromToAdmissionResourceAssembler assembler;

	@Autowired
	AdmissaoService admissaoService;

	@PostMapping(value = "/admission/consumer", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<FromToAdmissionResource> fromToAdmissions(@RequestBody Admission admission) {
		return new Resource<>(assembler.toResource(admissaoService.admissaoValues(admission)
                .orElseThrow(NotFoundException::new)));
	}
}
