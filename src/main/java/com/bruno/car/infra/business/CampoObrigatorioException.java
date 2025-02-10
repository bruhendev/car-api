package com.bruno.car.infra.business;

public class CampoObrigatorioException extends BusinessException{

	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException() {
		super("1", "Campo obrigatório", "Preencha os dados devidamente");
	}

}
