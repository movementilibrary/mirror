package br.com.dasa.mirror.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.service.AdmissaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Optional;

@RestController
public class AdmissionController {

	private static final Logger LOG = LoggerFactory.getLogger(AdmissionController.class);

	@Autowired
	AdmissaoService admissaoService;

	@PostMapping(value = "/admission/consumer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "Responsável por consumir Admissão e de para com data provider")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 404, message = "O resource requisitado não foi encontrado"),
			@ApiResponse(code = 500, message = "Um erro interno foi detectado") })
	public ResponseEntity<Admission> fromToAdmissions(@RequestBody Admission admission) {
		try {
			Optional<Admission> admissao = admissaoService.admissaoValues(admission);
			if (admissao.isPresent()) {
				return new ResponseEntity<Admission>(admissao.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return new ResponseEntity<Admission>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Admission>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
