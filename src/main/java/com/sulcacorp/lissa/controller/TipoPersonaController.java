package com.sulcacorp.lissa.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
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
import com.sulcacorp.lissa.exception.ModeloNotFoundException;
import com.sulcacorp.lissa.model.TipoPersona;
import com.sulcacorp.lissa.service.impl.TipoPersonaServiceImpl;

@RestController
@RequestMapping("/api/tipopersona")
public class TipoPersonaController {
	
	@Autowired
	private TipoPersonaServiceImpl service;
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@Valid @RequestBody TipoPersona t){
		TipoPersona obj = new TipoPersona();
		t.setDescripcion(t.getDescripcion().toUpperCase());
		obj = service.save(t);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getIdTipoPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody TipoPersona t) {
		t.setDescripcion(t.getDescripcion().toUpperCase());
		service.update(t);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void eliminar(@PathVariable("id") long id) {
		TipoPersona obj = service.findById(id);
		if(	obj != null && obj.getIdTipoPersona()!= null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}else {
			service.delete(id);
		}
	}

	@GetMapping(value = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoPersona> buscarXId(@PathVariable("id") long id) {
		TipoPersona obj = service.findById(id);
		if (obj == null || obj.getIdTipoPersona() == 0) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<TipoPersona>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoPersona>> listar() {
		return new ResponseEntity<List<TipoPersona>>(service.findAllAct(), HttpStatus.OK);
	}
}
