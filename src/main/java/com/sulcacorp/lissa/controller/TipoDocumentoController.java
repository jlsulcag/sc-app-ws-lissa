package com.sulcacorp.lissa.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sulcacorp.lissa.controller.commons.ResponseRest;
import com.sulcacorp.lissa.controller.generic.GenericController;
import com.sulcacorp.lissa.model.TipoDocumento;
import com.sulcacorp.lissa.service.exception.CustomServiceException;
import com.sulcacorp.lissa.service.impl.TipoDocumentoServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/tipodocumento")
@Slf4j
public class TipoDocumentoController extends GenericController{
	
	@Autowired
	private TipoDocumentoServiceImpl service;	
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRest> save(@Valid @RequestBody TipoDocumento t,
			BindingResult result){
		log.info(">>> Process /api/tipodocumento/save ");
		if(result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			TipoDocumento obj = service.save(t);
			if(obj == null) {
				log.error("Error de registro");
				return this.getInternalServerError();
			}
			return this.getCreatedResponse(service.save(t), result);
		} catch (CustomServiceException e) {
			log.error(">>>  Error /api/tipodocumento/save");
			return this.getInternalServerError();
		}
	}
	
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRest> actualizar(@Valid @RequestBody TipoDocumento t,
			BindingResult result) {
		log.info(">>> Process /api/tipodocumento/update ");
		if(result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			return this.getCreatedResponse(service.update(t), result);
		} catch (CustomServiceException e) {
			log.error(">>>  Error /api/tipodocumento/save");
			return this.getInternalServerError();
		}
	}
	
	@GetMapping(value = "/list/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRest> findAll(){
		try {
			List<TipoDocumento> list = service.findAllAct();
			if(list.isEmpty()) {
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(list);
		} catch (CustomServiceException e) {
			log.info(">>> Error /api/tipodocumento/findAll");
			return this.getInternalServerError();
		}
		
	}
	
	@GetMapping(value = "/list/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") long id){
		log.info(">>> Process /list/findById");
		try {
			TipoDocumento obj = service.findById(id);
			if(obj == null) {
				log.info(">>> {} no encontrado", this.getClass().getName());
				return this.getNotFoundRequest();
			}
			return this.getOkResponseConsulta(obj);
		} catch (CustomServiceException e) {
			log.info(">>> Error /api/tipodocumento/findById");
			return this.getInternalServerError();
		}
		
	}	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") long id) {
		log.info(">>> Process delete ");
		try {
			TipoDocumento obj = service.findById(id);
			if(obj == null) {
				return this.getNotFoundRequest();
			}
			service.delete(id);
			return this.getOkResponseConsulta(null);
		} catch (CustomServiceException e) {
			log.info("Error delete {} ", this.getClass().getName());
			return this.getInternalServerError();
		}
			
	}
}
