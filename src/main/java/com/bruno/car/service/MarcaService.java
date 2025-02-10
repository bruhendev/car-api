package com.bruno.car.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.car.infra.business.CampoObrigatorioException;
import com.bruno.car.infra.business.RegistroNaoLocalizadoException;
import com.bruno.car.model.marca.Marca;
import com.bruno.car.model.marca.MarcaRequest;
import com.bruno.car.model.marca.MarcaResponse;
import com.bruno.car.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repository;

	public Integer inserir(MarcaRequest request) {
		return gravar(null, request);
	}

	public Integer alterar(Integer id, MarcaRequest request) {
		return gravar(id, request);
	}

	public void deletar(Integer id) {
		repository.findById(id).ifPresentOrElse(entidade -> repository.deleteById(id), () -> {
			throw new RegistroNaoLocalizadoException();
		});
	}

	public MarcaResponse buscar(Integer id) {
		return converter(buscarEntity(id));
	}

	public List<MarcaResponse> listar() {
		List<MarcaResponse> response = repository.findAll().stream().map(this::converter).collect(Collectors.toList());
		return response;
	}

	private Integer gravar(Integer id, MarcaRequest request) {
		if (request.getNome() == null || request.getNome().isBlank()) {
			throw new CampoObrigatorioException();
		}

		Marca entity = Optional.ofNullable(id).isPresent() ? buscarEntity(id) : new Marca();

		BeanUtils.copyProperties(request, entity);

		return repository.save(entity).getId();
	}

	private Marca buscarEntity(Integer id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNaoLocalizadoException());
	}

	private MarcaResponse converter(Marca entity) {
		MarcaResponse response = new MarcaResponse();
		BeanUtils.copyProperties(entity, response);
		return response;
	}
}
