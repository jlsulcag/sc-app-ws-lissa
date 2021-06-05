package com.sulcacorp.lissa.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class EspecialidadDTO {
	
	private Long idEspecialidad;
	
	@Size(min = 3, max = 150, message = "La especialidad es requerida y debe tener minimo 3 y maximo  150 caracteres")
	private String descEspecialidad;
	
	private LocalDateTime fechaReg;
	
	private int estado;
}
