package com.bruno.car.model.veiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table
@Data
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Integer id;

	@Column(length = 32, nullable = false)
	private String chassi;

	@Column(length = 10, nullable = false)
	private String placa;

	@Column(length = 50, nullable = false)
	private String descricao;

	@Column(name = "ano_fabricacao", length = 8, nullable = false)
	private String anoFabricacao;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private VeiculoCategoria categoria;

	@Column(nullable = false)
	private Integer kmAtual;

//	@ManyToOne
//	@JoinColumn(name = "marca_id")
	@Column(name = "marca_id")
	private Integer marca;

	@Column(name = "modelo_id")
	private Integer modelo;
	
}
