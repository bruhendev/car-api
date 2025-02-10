package com.bruno.car.infra.business;

public class ConsultaSemRegistrosException extends BusinessException {
	private static final long serialVersionUID = 1L;

	public ConsultaSemRegistrosException() {
		super("3", "Consulta sem registros", "Insira um registro previamente");
	}
}
