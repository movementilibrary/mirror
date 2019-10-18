package br.com.dasa.mirror.api.service.impl;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.logs.model.ResourceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.dasa.mirror.api.enumeration.TypeFile;
import br.com.dasa.mirror.api.model.Unit;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Service
public class UnitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Unit.class);

//	@Autowired
//	private AwsS3Service awsS3Service;

	@Autowired
	ResourceLoader resourceLoader;

	public Integer convertUnityGlieseToUnityDataProvider(String idGliese) {
		Optional<Integer> idDataProvider = null;
		try {
			Gson gson = new Gson();
			//StringBuilder json = awsS3Service.acessS3Aws(TypeFile.UNIT);

			final Resource resource = this.resourceLoader.getResource("classpath:unidade");
			final InputStream inputStream = resource.getInputStream();
			File file = File.createTempFile("unidade", ".tmp");
			Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			String json = new String(Files.readAllBytes(file.toPath()));

			inputStream.close();

			Type listaUnidadeDeserializa = new TypeToken<ArrayList<Unit>>() {
			}.getType();

			List<Unit> listaUnit = gson.fromJson(json, listaUnidadeDeserializa);

			idDataProvider = Optional.of(listaUnit.stream().filter(g -> idGliese.equals(g.getIdGliese()))
					.map(Unit::getIdDataProvider).findAny()
					.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar unidade desejada")));

		} catch (Exception exception) {
			LOGGER.error("Não foi possivel encontrar arquivo ");
		}
		return idDataProvider.orElseThrow(() -> new RuntimeException("Arquivo não encontrado"));
	}

}
