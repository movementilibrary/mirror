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
import org.springframework.util.StringUtils;

import com.amazonaws.services.logs.model.ResourceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.dasa.mirror.api.model.Unit;
import br.com.dasa.mirror.api.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UnitServiceImpl.class);

	@Autowired
	ResourceLoader resourceLoader;

	public Unit convertUnityGlieseToUnityDataProvider(String idGliese) {
		Optional<Integer> idDataProvider = null;
		Unit unit = new Unit();
		try {
			Gson gson = new Gson();

			final Resource resource = this.resourceLoader.getResource("classpath:unidades");
			final InputStream inputStream = resource.getInputStream();
			File file = File.createTempFile("unidades", ".tmp");
			Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			String json = new String(Files.readAllBytes(file.toPath()));

			inputStream.close();

			Type listaUnidadeDeserializa = new TypeToken<ArrayList<Unit>>() {
			}.getType();

			List<Unit> listaUnit = gson.fromJson(json, listaUnidadeDeserializa);

			idDataProvider = Optional.of(listaUnit.stream().filter(g -> idGliese.equals(g.getIdGliese()))
					.map(Unit::getIdDataProvider).findAny()
					.orElseThrow(() -> new ResourceNotFoundException("Não foi possivel encontrar unidade desejada")));

			if (!StringUtils.isEmpty(idDataProvider.get())) {
				unit.setIdDataProvider(idDataProvider.get());
			}
		} catch (Exception exception) {
			LOGGER.error("Não foi possivel encontrar arquivo ");
		}
		return unit;
	}
}
