package com.sulcacorp.lissa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ESPECIALIDAD")
public class Especialidad {
	
	@Id
	@Column(name = "ID_ESPECIALIDAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEspecialidad;
	
	
	@Column(name = "DESC_ESPECIALIDAD", nullable = false, length = 150)
	private String descEspecialidad;
	
	@Column(name = "FECHA_REG", nullable = false)
	private LocalDateTime fechaReg;
	
	@Column(name = "ESTADO", nullable = false)
	private int estado;

}
