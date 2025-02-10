package com.bruno.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.bruno.car.repository.VeiculoRepository;

@Component
public class StartApp implements ApplicationRunner {

	@Autowired
	private VeiculoRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		var veiculos = repository.list();

		for (var v : veiculos) {
			System.out.println(v.getChassi() + " - " + v.getPlaca() + " - " + v.getMarca() + " - " + v.getModelo());
		}
	}

}
