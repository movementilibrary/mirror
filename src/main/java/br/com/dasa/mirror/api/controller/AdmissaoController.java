package br.com.dasa.mirror.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonSyntaxException;

import br.com.dasa.mirror.api.model.Admission;
import br.com.dasa.mirror.api.model.Response;
import br.com.dasa.mirror.api.service.AdmissaoService;

@Controller
@RequestMapping("/rest")
public class AdmissaoController {

	@Autowired
	AdmissaoService admissaoService;

	@RequestMapping(value = "/consumidorAdmissoes", method = RequestMethod.POST)
	public @ResponseBody Response consumidorAdmissoes(@RequestBody Admission admission) {
		Response response = new Response();
		try {
			response = admissaoService.admissaoValues(admission);
		} catch (JsonSyntaxException e) {
			throw new JsonSyntaxException("Erro no formato do JSON enviado, favor verificar o seu conteúdo!");
		} catch (Exception e) {
			response.setCodigo(HttpStatus.BAD_REQUEST.value());
			response.setDescricao(e.getMessage());
			return response;
		}
		return response;
	}
}
