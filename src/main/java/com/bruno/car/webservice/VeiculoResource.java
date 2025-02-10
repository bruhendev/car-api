package com.bruno.car.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.car.infra.http.Response;
import com.bruno.car.infra.http.ResponseFactory;
import com.bruno.car.model.veiculo.VeiculoRequest;
import com.bruno.car.service.VeiculoService;

@RestController
@RequestMapping("veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@PostMapping
	public Response post(@RequestBody VeiculoRequest request) {
		return ResponseFactory.create(service.incluir(request), "Marca criada com sucesso");
	}

}
