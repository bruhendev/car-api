package com.bruno.car.model.veiculo;

public interface VeiculoResponse {

	public String getChassi();
	
	public String getPlaca();

	public String getDescricao();

	public String getAnoFabricacao();

	public VeiculoCategoria getCategoria();

	public Integer getKmAtual();
	
	public String getMarca();
	
	public String getModelo();

}
