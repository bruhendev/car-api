package com.bruno.car.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.car.infra.http.Response;
import com.bruno.car.infra.http.ResponseFactory;
import com.bruno.car.model.modelo.ModeloRequest;
import com.bruno.car.service.ModeloService;

@RestController
@RequestMapping("/modelos")
public class ModeloResource {
	
	@Autowired
	private ModeloService service;

	@GetMapping
	public Response getList() {
		return ResponseFactory.ok(service.listar());
	}
	
	@GetMapping("/marca/{marcaId}")
	public Response getListByMarca(@PathVariable Integer marcaId) {
		return ResponseFactory.ok(service.listar(marcaId));
	}
	
	@GetMapping("/{id}")
	public Response getItem(@PathVariable Integer id) {
		return ResponseFactory.ok(service.buscarModelo(id));
	}
	
	@PostMapping
	public Response post(@RequestBody ModeloRequest request) {
		return ResponseFactory.ok(service.Inserir(request));
	}
	
	@PutMapping("/{id}")
	public Response put(@PathVariable Integer id, @RequestBody ModeloRequest request) {
		return ResponseFactory.ok(service.alterar(id, request));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deletar(id);
	}
}
