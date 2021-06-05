package com.sulcacorp.lissa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TIPO_DOCUMENTO")
@JsonPropertyOrder({"idTipoDocumento", "descripcion", "abreviatura", "codigo", "estado"})
public class TipoDocumento {
	@Id
	@Column(name = "ID_TIPO_DOCUMENTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipoDocumento;
	
	@Size(min = 3, max = 40, message = "La especialidad es requerida y debe tener mánimo 3 y máximo  40 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 40)
	private String descripcion;
	
	@Column(name = "ABREVIATURA" , length = 10)
	private String abreviatura;
	
	@Column(name = "CODIGO" , length = 2)
	private String codigo;
	
	@Column(name = "ESTADO", nullable = false)
	private int estado;
	
	

}
