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
@Table(name = "ESTADO_CIVIL")
@JsonPropertyOrder({"idEstadoCivil", "descripcion", "estado"})
public class EstadoCivil {
	@Id
	@Column(name = "ID_ESTADO_CIVIL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstadoCivil;
	
	@Size(min = 3, max = 20, message = "La especialidad es requerida y debe tener mánimo 3 y máximo  20 caracteres")
	@Column(name = "DESCRIPCION", nullable = false, length = 20)
	private String descripcion;
		
	@Column(name = "ESTADO", nullable = false)
	private int estado;

	
	

}
