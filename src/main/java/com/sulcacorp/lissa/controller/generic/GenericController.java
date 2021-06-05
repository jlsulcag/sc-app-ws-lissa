package com.sulcacorp.lissa.controller.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.sulcacorp.lissa.controller.commons.ResponseEstado;
import com.sulcacorp.lissa.controller.commons.ResponseRest;
import com.sulcacorp.lissa.util.enums.ResponseEnums;

public abstract class GenericController {

	protected List<Map<String, String>> formatMapMessageList(BindingResult result) {
		List<Map<String, String>> errors = 
				result.getFieldErrors().stream().map(err -> 
					{
						Map<String, String> error = new HashMap<>();
						error.put(err.getField(), err.getDefaultMessage());
						return error;
		}
		
	).collect(Collectors.toList());
		return errors;
	}
	
	/*HttpStatus : 200*/
	protected ResponseEntity<ResponseRest> getOkResponseConsulta(Object obj){
		ResponseRest response = ResponseRest.builder()
				.status(ResponseEstado.builder()
						.statusCode(HttpStatus.OK.value())
						.responseHttp(HttpStatus.OK.name())
						.code(ResponseEnums.EXITO)
						.build()
						)
				.data(obj)
				.build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
				
	}
	
	protected ResponseEntity<ResponseRest> getOkResponseRegistro(Object obj, BindingResult result){
		ResponseRest response = ResponseRest.builder()
				.status(ResponseEstado.builder()
						.statusCode(HttpStatus.OK.value())
						.responseHttp(HttpStatus.OK.name())
						.code(ResponseEnums.EXITO)
						.errors(this.formatMapMessageList(result))
						.build()
						)
				.data(obj)
				.build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
				
	}
	
	/*HttpStatus : 201*/
	protected ResponseEntity<ResponseRest> getCreatedResponse(Object obj, BindingResult result){
		ResponseRest response = ResponseRest.builder()
				.status(ResponseEstado.builder()
						.statusCode(HttpStatus.CREATED.value())
						.responseHttp(HttpStatus.CREATED.name())
						.code(ResponseEnums.EXITO)
						.errors(this.formatMapMessageList(result))
						.build()
						)
				.data(obj)
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	/*HttpStatus 400*/
	protected ResponseEntity<ResponseRest> getBadRequest(BindingResult result){
		ResponseRest response = ResponseRest.builder()
				.status(ResponseEstado.builder()
						.statusCode(HttpStatus.BAD_REQUEST.value())
						.responseHttp(HttpStatus.BAD_REQUEST.name())
						.code(ResponseEnums.ALERTA)
						.errors(this.formatMapMessageList(result))
						.build()						
						).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	/*HttpStatus : 404*/
	protected ResponseEntity<ResponseRest> getNotFoundRequest(){
		ResponseRest response = ResponseRest.builder()
				.status(ResponseEstado.builder()
						.statusCode(HttpStatus.NOT_FOUND.value())
						.responseHttp(HttpStatus.NOT_FOUND.name())
						.code(ResponseEnums.ALERTA)
						.errors(null)
						.build()						
						).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

	}
	
	/*HttpStatus : 500*/
	protected ResponseEntity<ResponseRest> getInternalServerError(){
		ResponseRest response = ResponseRest.builder()
				.status(ResponseEstado.builder()
						.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
						.responseHttp(HttpStatus.INTERNAL_SERVER_ERROR.name())
						.code(ResponseEnums.ERROR)
						.errors(null)
						.build()						
						).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

	}
	
}
