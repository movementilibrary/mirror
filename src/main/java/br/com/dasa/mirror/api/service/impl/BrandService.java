package br.com.dasa.mirror.api.service.impl;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.amazonaws.services.logs.model.ResourceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.dasa.mirror.api.model.Brand;
import br.com.dasa.mirror.api.model.Unit;

@Service
public class BrandService {
	
    @Autowired
    ResourceLoader resourceLoader;

    private static final Logger LOGGER = LoggerFactory.getLogger(Brand.class);


    public Integer convertBrandGlieseToBrandDataProvider(String idGliese) {
        Optional<Integer> idDataProvider = null;
        Gson gson = new Gson();

        try {
            final Resource resource = this.resourceLoader.getResource("classpath:marca");
            final InputStream inputStream = resource.getInputStream();
            File file = File.createTempFile("marca", ".tmp");
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String json = new String(Files.readAllBytes(file.toPath()));
            inputStream.close();

            Type listaMarcaDeserializa = new TypeToken<ArrayList<Unit>>() {
            }.getType();

            List<Unit> listaUnit = gson.fromJson(json, listaMarcaDeserializa);

            idDataProvider = Optional.of(listaUnit.stream()
                    .filter(g -> idGliese.equals(g.getIdGliese()))
                    .map(Unit::getIdDataProvider)
                    .findAny()
                    .orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar marca desejada")));

        } catch (Exception exception) {
            LOGGER.error("Não foi possivel encontrar arquivo ");
        }

        return idDataProvider.orElseThrow(() -> new RuntimeException("Arquivo não encontrado"));
    }

}
