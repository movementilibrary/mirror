package br.com.dasa.mirror.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.mirror.api.model.Admission;

@RestController
public class AdmissionController {

	@Autowired
	AdmissaoService admissaoService;

	@PostMapping(value = "/admission/consumer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "Responsável por consumir Admissão e de para com data provider")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso"),
			@ApiResponse(code = 404, message = "O resource requisitado não foi encontrado"),
			@ApiResponse(code = 500, message = "Um erro interno foi detectado")
	})
	public Admission fromToAdmissions(@RequestBody Admission admission) {
		return admissaoService.
	}
}
