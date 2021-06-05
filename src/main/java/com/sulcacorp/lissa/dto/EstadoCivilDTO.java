package com.sulcacorp.lissa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)//Ignora propiedades desconocidas
@JsonInclude(JsonInclude.Include.NON_NULL)//Ignora  campos nulos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCivilDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idEstadoCivil;
	private String descripcion;
	private int estado;
}
