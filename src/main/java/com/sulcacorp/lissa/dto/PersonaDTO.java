package com.sulcacorp.lissa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sulcacorp.lissa.model.EstadoCivil;
import com.sulcacorp.lissa.model.TipoDocumento;
import com.sulcacorp.lissa.model.TipoPersona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)//Ignora campos desconocidos
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {	
	private Long idPersona;
	private TipoPersona tipoPersona;	
	private TipoDocumento tipoDocumento;	
	private EstadoCivil estadoCivil;	
	private String nombres;	
	private String apellidoPaterno;	
	private String apellidoMaterno;	
	private String numeroDocumentoIdentidad;	
	private String fechaNacimiento;	
	private String fechaRegistro;	
	private String sexo;	
	private String direccion;	
	private String telefono;	
	private String correoElectronico;	
	private String lugarNacimiento;	
	private String lugarProcedencia;	
	private String gradoInstruccion;	
	private String ocupacion;	
	private String esProveedor;	
	private String estado;
}
