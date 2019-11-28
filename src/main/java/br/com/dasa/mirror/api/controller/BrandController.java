package br.com.dasa.mirror.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.mirror.api.service.BrandService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping()
    @ApiOperation(httpMethod = "GET", value = "Responsável por buscar ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 404, message = "O resource requisitado não foi encontrado"),
            @ApiResponse(code = 500, message = "Um erro interno foi detectado")})
    public Integer converteMarcaGlieseParaMarcaData(@RequestParam String id) {
        return brandService.convertBrandGlieseToBrandDataProvider(id).getIdDataProvider();
    }


}
