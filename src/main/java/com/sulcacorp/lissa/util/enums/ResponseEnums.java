package com.sulcacorp.lissa.util.enums;

public enum ResponseEnums {
	
	ERROR(-1,"Error"),
	ALERTA(0,"Alerta"),
	EXITO(1,"Exito");
	
	private Integer valor;
	private String nombre;
	
	private ResponseEnums(Integer valor, String nombre) {
		this.valor = valor;
		this.nombre = nombre;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
}
