package br.com.dasa.mirror.api.service;

import br.com.dasa.mirror.api.model.Marca;
import br.com.dasa.mirror.api.model.Unidade;
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
public class MarcaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Marca.class);


    public Integer buscaMarca(String idGliese) {
        Integer idDataProvider = null;
        try {
            Gson gson = new Gson();
            BufferedReader json = new BufferedReader(new FileReader("src/main/java/br/com/dasa/mirror/api/dataprovider/marca"));

            Type listaMarcaDeserializa = new TypeToken<ArrayList<Unidade>>() {
            }.getType();

            List<Unidade> listaUnidade = gson.fromJson(json, listaMarcaDeserializa);

            idDataProvider = listaUnidade.stream()
                    .filter(g -> idGliese.equals(g.getIdGliese()))
                    .map(Unidade::getIdDataProvider)
                    .findAny()
                    .orElse(null);

        } catch (Exception e) {
            LOGGER.error("Não foi possivel encontar unidade desejada ");
        }
      return idDataProvider;
    }

}
