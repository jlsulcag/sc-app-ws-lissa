package com.sulcacorp.lissa.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.sulcacorp.lissa.dto.EspecialidadDTO;
import com.sulcacorp.lissa.service.IEspecialidadService;
import com.sulcacorp.lissa.service.exception.CustomServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Validated
@RestController
@RequestMapping("/api")
public class EspecialidadController extends GenericController{

	@Autowired
	private IEspecialidadService especialidadService;
	
	@GetMapping(value = "/especialidad/findAll")
	public ResponseEntity<ResponseRest> findAll(){
		log.info(">>> init findAll");
		try {
			List<EspecialidadDTO> list = especialidadService.findAllAct();
			if(list.isEmpty()) {
				return this.getNotFoundRequest();
			}	
			return this.getOkResponseConsulta(list);
			
		} catch (CustomServiceException e) {
			log.error(">>> Error especialidad findAll :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}
	
	@GetMapping(value = "/especialidad/findById/{id}")
	public ResponseEntity<ResponseRest> findById(@PathVariable("id") Long id){
		log.info(">>> init findById");
		EspecialidadDTO especialidad = new EspecialidadDTO();
		try {
			especialidad = especialidadService.findById(id);
			if(especialidad == null) {
				return this.getNotFoundRequest();
			}
			return getOkResponseConsulta(especialidad);
		} catch (CustomServiceException e) {
			log.error(">>> Error especialidad findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
		
	}
	
	@PostMapping(value = "/especialidad/save")
	public ResponseEntity<ResponseRest> save(@Validated @RequestBody EspecialidadDTO especialidad, BindingResult result){
		log.info(">>> init save");
		if(result.hasErrors()) {
			return this.getBadRequest(result);
		}
		try {
			EspecialidadDTO dto = especialidadService.save(especialidad);			
			return this.getCreatedResponse(dto,result);
		} catch (CustomServiceException e) {
			log.error(">>> Error especialidad findById :\n {}", e.getMessage());
			return this.getInternalServerError();
		}
	}
	
	@PutMapping(value = "/especialidad/update")
	public ResponseEntity<ResponseRest> update(@Valid @RequestBody EspecialidadDTO especialidad, BindingResult result){
		log.info(">>> init update");
		try {
			EspecialidadDTO especialidadDTO = especialidadService.update(especialidad);
			return this.getOkResponseRegistro(especialidadDTO, result);
		} catch (CustomServiceException e) {
			log.error(">>> Error especialidad update : {}", e.getMessage());
			return this.getInternalServerError();
		}
	}
	
	@DeleteMapping(value = "/especialidad/delete/{id}")
	public ResponseEntity<ResponseRest> delete(@PathVariable("id") Long id) {
		log.info(">>> init delete");
		EspecialidadDTO obj = new EspecialidadDTO();
		try {
			obj = especialidadService.findById(id);
			if(obj != null && obj.getIdEspecialidad() != null) {
				especialidadService.delete(id);
				return this.getOkResponseConsulta(obj);
			}
			return this.getNotFoundRequest();
		} catch (CustomServiceException e) {
			log.error(">>> Error especialidad delete : {}", e.getMessage());
			return this.getInternalServerError();
		}
		
	}
}
