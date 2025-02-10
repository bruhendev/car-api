package com.bruno.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bruno.car.model.veiculo.Veiculo;
import com.bruno.car.model.veiculo.VeiculoResponse;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{

	@Query("SELECT e.chassi as chassi, e.placa as placa, "
			+ "ma.nome as marca, mo.nome as modelo "
			+ "FROM Veiculo e "
			+ "JOIN Marca ma ON e.marca = ma.id "
			+ "JOIN Modelo mo ON e.modelo = mo.id")
	List<VeiculoResponse> list();
}
