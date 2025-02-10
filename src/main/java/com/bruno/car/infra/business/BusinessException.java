package com.bruno.car.infra.business;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String id;
	private String suggestion;

	public BusinessException(String id, String message, String suggestion) {
		super(message);
		this.id = id;
		this.suggestion = suggestion;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public String getId() {
		return id;
	}

	public int getHttpStatus() {
		return 409;
	}

}