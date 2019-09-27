package br.com.dasa.mirror.api.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.services.logs.model.ResourceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.dasa.mirror.api.model.Brand;
import br.com.dasa.mirror.api.model.Unit;

@Service
public class BrandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Brand.class);


    public Integer convertBrandGlieseToBrandDataProvider(String idGliese) {
        Optional<Integer> idDataProvider = null;
        try {
            Gson gson = new Gson();
            BufferedReader json = new BufferedReader(new FileReader("src/main/resources/dataprovider/marca"));

            Type listaMarcaDeserializa = new TypeToken<ArrayList<Unit>>() {
            }.getType();

            List<Unit> listaUnit = gson.fromJson(json, listaMarcaDeserializa);

            idDataProvider = Optional.of(listaUnit.stream()
                    .filter(g -> idGliese.equals(g.getIdGliese()))
                    .map(Unit::getIdDataProvider)
                    .findAny()
                    .orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar marca desejada")));

        } catch (FileNotFoundException exception) {
            LOGGER.error("Não foi possivel encontrar arquivo ");
        }

        return idDataProvider.orElseThrow(() -> new RuntimeException("Não foi possivel encontrar arquivo"));
    }

}
