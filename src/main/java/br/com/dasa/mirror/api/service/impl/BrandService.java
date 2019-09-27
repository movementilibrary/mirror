package br.com.dasa.mirror.api.service.impl;

import br.com.dasa.mirror.api.model.Brand;
import br.com.dasa.mirror.api.model.Unit;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Brand.class);


    public Integer convertBrandGlieseToBrandDataProvider(String idGliese) {
        Integer idDataProvider = null;
        try {
            Gson gson = new Gson();
            BufferedReader json = new BufferedReader(new FileReader("src/main/resources/dataprovider/marca"));

            Type listaMarcaDeserializa = new TypeToken<ArrayList<Unit>>() {
            }.getType();

            List<Unit> listaUnit = gson.fromJson(json, listaMarcaDeserializa);

            idDataProvider = listaUnit.stream()
                    .filter(g -> idGliese.equals(g.getIdGliese()))
                    .map(Unit::getIdDataProvider)
                    .findAny()
                    .orElse(null);

        } catch (Exception e) {
            LOGGER.error("Não foi possivel encontar unidade desejada ");
        }
      return idDataProvider;
    }

}
