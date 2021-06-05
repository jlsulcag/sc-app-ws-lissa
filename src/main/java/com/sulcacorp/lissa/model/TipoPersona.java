package com.sulcacorp.lissa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TIPO_PERSONA")
@JsonPropertyOrder({"idTipoPersona", "descripcion", "estado"})
public class TipoPersona {
	@Id
	@Column(name = "ID_TIPO_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoPersona;
	
	@Size(min = 3, max = 60, message = "La descripcion es requerida y debe tener mánimo 3 y máximo  60 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 60)
	private String descripcion;
	
	@Column(name = "ESTADO", nullable = false)
	private int estado;

}
