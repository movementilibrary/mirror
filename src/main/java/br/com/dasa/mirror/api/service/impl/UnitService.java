package br.com.dasa.mirror.api.service.impl;

import br.com.dasa.mirror.api.model.Unit;
import com.amazonaws.services.logs.model.ResourceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Unit.class);


    public Integer convertUnityGlieseToUnityDataProvider(String idGliese) {
        Optional<Integer> idDataProvider = null;
        String path = new File("").getAbsolutePath();
        LOGGER.info("meu diretorio atual" + path);
        try {
            Gson gson = new Gson();
            BufferedReader json = new BufferedReader(new FileReader("src/main/resources/unidade.txt"));

            Type listaUnidadeDeserializa = new TypeToken<ArrayList<Unit>>() {
            }.getType();

            List<Unit> listaUnit = gson.fromJson(json, listaUnidadeDeserializa);

            idDataProvider = Optional.of(listaUnit.stream()
                    .filter(g -> idGliese.equals(g.getIdGliese()))
                    .map(Unit::getIdDataProvider)
                    .findAny()
                    .orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar unidade desejada")));

        } catch (FileNotFoundException exception) {
            LOGGER.error("Não foi possivel encontrar arquivo ");
        }
      return idDataProvider.orElseThrow(() -> new RuntimeException("Arquivo não encontrado"));
    }

}
