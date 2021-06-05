package com.sulcacorp.lissa.controller.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseRest{

	private ResponseEstado status;
	
	@JsonInclude(Include.NON_NULL)
	private Object data;
}
