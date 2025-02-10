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
import com.bruno.car.model.marca.MarcaRequest;
import com.bruno.car.model.marca.MarcaResponse;
import com.bruno.car.service.MarcaService;

@RestController
@RequestMapping("marcas")
public class MarcaResource {

	@Autowired
	private MarcaService service;

	@PostMapping
	public Response post(@RequestBody MarcaRequest request) {
		return ResponseFactory.create(service.inserir(request), "Marca criada com sucesso");
	}

	@PutMapping(value = "/{id}")
	public Response put(@PathVariable Integer id, @RequestBody MarcaRequest request) {
		return ResponseFactory.ok(service.alterar(id, request));
	}

	@GetMapping
	public Response getList() {
		return ResponseFactory.ok(service.listar());
	}

	@GetMapping(value = "/{id}")
	public Response getItem(@PathVariable Integer id) {
		MarcaResponse response = service.buscar(id);
		return ResponseFactory.ok(response);
	}

	@DeleteMapping
	public void delete() {

	}

}
