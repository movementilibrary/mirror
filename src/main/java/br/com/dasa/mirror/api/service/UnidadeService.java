package br.com.dasa.mirror.api.service;

import br.com.dasa.mirror.api.model.Unidade;
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
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UnidadeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Unidade.class);


    public Integer buscaUnidade(String idGliese) {
        Integer idDataProvider = null;
        try {
            Gson gson = new Gson();
            BufferedReader json = new BufferedReader(new FileReader("src/main/java/br/com/dasa/mirror/api/dataprovider/unidade"));

            Type listaUnidadeDeserializa = new TypeToken<ArrayList<Unidade>>() {
            }.getType();

            List<Unidade> listaUnidade = gson.fromJson(json, listaUnidadeDeserializa);

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
