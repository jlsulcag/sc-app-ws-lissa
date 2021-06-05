package com.sulcacorp.lissa.controller.commons;
/*
 * Fecha Hora
 * "statusCode" : 500
 * "error": "Internal Server Error"
 * Codigo de operacion success or error
 * "message": "No message available"
 * data body
 * 
 * */

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sulcacorp.lissa.util.enums.ResponseEnums;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@JsonPropertyOrder({"code", "messagge","statusCode", "error", "timestamps" })
@Data
@Builder
public class ResponseEstado {
	
	@Builder.Default
	private LocalDateTime timestamps= LocalDateTime.now(); 
		
	private Integer statusCode;
	 
	private String 	responseHttp; 
		
	private ResponseEnums code;
	
	@JsonInclude(Include.NON_NULL)
	private Object errors; 
}
