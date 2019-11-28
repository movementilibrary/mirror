package br.com.dasa.mirror.api.controller;

import br.com.dasa.mirror.api.model.Brand;
import br.com.dasa.mirror.api.model.Unit;
import br.com.dasa.mirror.api.service.impl.BrandService;
import br.com.dasa.mirror.api.service.impl.UnitService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/unit")
public class UnitContoller {

    private static final Logger LOG = LoggerFactory.getLogger(AdmissionController.class);

    @Autowired
    private UnitService unitService;

    @GetMapping()
    @ApiOperation(httpMethod = "GET", value = "Responsável por buscar ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 404, message = "O resource requisitado não foi encontrado"),
            @ApiResponse(code = 500, message = "Um erro interno foi detectado")})
    public Integer converteUnidadeGlieseParaUnidadeDataProvider(@RequestParam String id) {
        return unitService.convertUnityGlieseToUnityDataProvider(id).getIdDataProvider();
    }

}
