package com.bruno.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.car.model.modelo.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

	List<Modelo> findByMarca(Integer marca);
}
