package com.bruno.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.car.model.marca.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
