package com.sulcacorp.lissa.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sulcacorp.lissa.dto.PersonaDTO;
import com.sulcacorp.lissa.exception.ModeloNotFoundException;
import com.sulcacorp.lissa.model.Persona;
import com.sulcacorp.lissa.service.IPersonaService;
import com.sulcacorp.lissa.service.exception.CustomServiceException;
import com.sulcacorp.lissa.service.impl.PersonaServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

	@Autowired
	private PersonaServiceImpl service;
	
//	@PostMapping(value = "/persona/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> save(@Valid @RequestBody Persona persona) {
//		Persona obj = new Persona();
//		persona.setFechaRegistro(LocalDate.now());
//		persona.setEsProveedor(0);
//		obj = service.save(persona);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getIdPersona())
//				.toUri();
//		return ResponseEntity.created(location).build();
//	}
//	
//	@PutMapping(value = "/persona/update",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> actualizar(@Valid @RequestBody Persona persona) {		;
//		return new ResponseEntity<Object>(service.update(persona),HttpStatus.OK);
//	}

//	@GetMapping(value = "/persona/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Persona> buscarXId(@PathVariable("id") long id) {
//		log.info("Inicia metodo buscarXId {} ", id);
//		Persona persona = new Persona();
//		persona = service.findById(id);
//		if (persona == null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);			
//		} 
//		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
//	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonaDTO>> listar() {
		log.info(">>> Process persona findAll");
		List<PersonaDTO> list = new LinkedList<>();
		try {
			list = service.findAllAct();
		} catch (CustomServiceException e) {
			log.error(">>> Error persona findAll {}",e.getMessage());
		}
		return new ResponseEntity<List<PersonaDTO>>(list, HttpStatus.OK);
	}

//	@DeleteMapping(value = "/persona/delete/{id}")
//	public void eliminar(@PathVariable("id") long id) {
//		Persona persona = new Persona();
//		persona = service.findById(id);
//		if (persona == null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);			
//		} else {
//			service.delete(id);
//		}
//	}

	@GetMapping(value = "/search/docNumber/{numDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> buscarXDoc(@PathVariable("numDoc") String numDoc) {
		log.info("Inicia metodo buscarXDoc {} ", numDoc);
		Persona persona = new Persona();
		persona = service.buscarXDoc(numDoc);
		if (persona != null && persona.getIdPersona() != null) {
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		} else {
			throw new ModeloNotFoundException("PERSONA NO ENCONTRADA " + numDoc);
		}
	}

	@GetMapping(value = "/search/fullname/{fullName}")
	public ResponseEntity<List<Persona>> listFullName(@PathVariable("fullName") String fullName) {
		log.info("Metodo listFullName() {}", fullName);
		List<Persona> list = new LinkedList<>();
		list = service.listarFullName(fullName.toUpperCase());
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
		} else {
			throw new ModeloNotFoundException("NO SE ENCONTRO RESULTADOS");
		}

	}
	
	@GetMapping(value = "/search/docNumber/{typeDoc}/{numDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> buscarXDoc(@PathVariable("typeDoc") String typeDoc,  @PathVariable("numDoc") String numDoc) {
		log.info("Inicia metodo busqueda por tipo y numero de doc {} ", numDoc);
		Persona persona = new Persona();
		persona = service.buscarXDoc(Long.parseLong(typeDoc), numDoc);
		if (persona != null && persona.getIdPersona() != null) {
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		} else {
			log.warn("ERROR: No existe persona con Dni : {}", numDoc);
			throw new ModeloNotFoundException("PERSONA NO ENCONTRADA " + numDoc);
		}
	}

}
