package com.bruno.car.model.veiculo;

import lombok.Data;

@Data
public class VeiculoRequest {

	private String chassi;

	private String placa;

	private String descricao;

	private String anoFabricacao;

	private VeiculoCategoria categoria;

	private Integer kmAtual;

	private Integer marca;

	private Integer modelo;
}
