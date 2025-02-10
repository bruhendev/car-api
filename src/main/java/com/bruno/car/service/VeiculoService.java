package com.bruno.car.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.car.model.veiculo.Veiculo;
import com.bruno.car.model.veiculo.VeiculoRequest;
import com.bruno.car.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;

	public Integer incluir(VeiculoRequest request) {
		Veiculo entity = new Veiculo();
		BeanUtils.copyProperties(request, entity);
		
		return repository.save(entity).getId();
	}
}
