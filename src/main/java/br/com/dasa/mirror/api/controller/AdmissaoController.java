package br.com.dasa.mirror.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dasa.mirror.api.model.Response;
import br.com.dasa.mirror.api.service.AdmissaoService;

@Controller
@RequestMapping("/rest")
public class AdmissaoController {

	@Autowired
	AdmissaoService admissaoService;

	@RequestMapping(value = "/sendMessageAdmissoes", method = RequestMethod.POST)
	public @ResponseBody Response sendMessageAdmissoes(@RequestBody String json) {
		Response response = new Response();
		try {
			response = admissaoService.admissaoValues(json);
		} catch (final Exception e) {
			response.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDescricao(e.getMessage());
		}
		return response;
	}
}
