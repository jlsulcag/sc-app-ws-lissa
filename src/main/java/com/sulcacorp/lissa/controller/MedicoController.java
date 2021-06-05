package com.sulcacorp.lissa.controller;

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
import com.sulcacorp.lissa.exception.ModeloNotFoundException;
import com.sulcacorp.lissa.model.Medico;
import com.sulcacorp.lissa.service.IMedicoService;
import com.sulcacorp.lissa.service.impl.MedicoServiceImpl;

@RestController
@RequestMapping("/api")
public class MedicoController {

	@Autowired
	private MedicoServiceImpl medicoService;

	@PostMapping(value = "/medico/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> save(@Valid @RequestBody Medico medico) {
		return new ResponseEntity<Medico>(medicoService.save(medico), HttpStatus.CREATED);
	}

	@PutMapping(value = "/medico/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> update(@Valid @RequestBody Medico medico) {
		return ResponseEntity.ok(medicoService.update(medico));
	}

	@GetMapping(value = "/medico/searchById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> searchById(@PathVariable("id") Long id) {
		Medico medico = medicoService.findById(id);
		if (medico.getIdMedico() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Medico>(medico, HttpStatus.OK);
	}

	@GetMapping(value = "/medico/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Medico>> findAll() {
		return ResponseEntity.ok(medicoService.findAllAct());
	}

	@DeleteMapping(value = "/medico/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		Medico medico = medicoService.findById(id);
		if (medico.getIdMedico() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		} else {
			medicoService.delete(id);
		}
	}
}
