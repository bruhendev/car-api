package com.bruno.car.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.car.infra.business.CampoObrigatorioException;
import com.bruno.car.infra.business.RegistroNaoLocalizadoException;
import com.bruno.car.model.modelo.Modelo;
import com.bruno.car.model.modelo.ModeloRequest;
import com.bruno.car.model.modelo.ModeloResponse;
import com.bruno.car.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository repository;

	public Integer Inserir(ModeloRequest request) {
		return salvar(null, request);
	}

	public Integer alterar(Integer id, ModeloRequest request) {
		return salvar(id, request);
	}

	public List<ModeloResponse> listar() {
		var lista = repository.findAll().stream().map(this::converter).collect(Collectors.toList());
		return lista;
	}
	
	public List<ModeloResponse> listar(Integer marca) {
		var lista = repository.findByMarca(marca).stream().map(this::converter).collect(Collectors.toList());
		return lista;
	}

	public ModeloResponse buscarModelo(Integer id) {
		return converter(buscarEntity(id));
	}

	public void deletar(Integer id) {
		repository.findById(id).ifPresentOrElse(entidade -> repository.deleteById(id), () -> {
			throw new RegistroNaoLocalizadoException();
		});
	}

	private Integer salvar(Integer id, ModeloRequest request) {

		if (request.getNome() == null || request.getNome().isBlank()) {
			throw new CampoObrigatorioException();
		}

		Modelo entity = Optional.ofNullable(id).isPresent() ? buscarEntity(id) : new Modelo();

		BeanUtils.copyProperties(request, entity);

		return repository.save(entity).getId();
	}

	private Modelo buscarEntity(Integer id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNaoLocalizadoException());
	}

	private ModeloResponse converter(Modelo entity) {
		ModeloResponse response = new ModeloResponse();
		BeanUtils.copyProperties(entity, response);
		return response;
	}
}
