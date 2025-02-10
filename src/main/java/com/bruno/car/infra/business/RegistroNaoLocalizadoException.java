package com.bruno.car.infra.business;

public class RegistroNaoLocalizadoException extends BusinessException {
	private static final long serialVersionUID = 1L;

	public RegistroNaoLocalizadoException() {
		super("2", "Registro não localizado", "Insira um registro previamente");
	}

}
