package com.sulcacorp.lissa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulcacorp.lissa.model.TipoMedico;
import com.sulcacorp.lissa.service.ITipoMedicoService;
import com.sulcacorp.lissa.service.impl.TipoMedicoServiceImpl;

@RestController
@RequestMapping("/api")
public class TipoMedicoController {
	
	@Autowired
	private TipoMedicoServiceImpl tipoMedicoService;
	
	@GetMapping(value = "/tipoMedico/findAll")
	public ResponseEntity<List<TipoMedico>> findAll(){
		List<TipoMedico> list = new ArrayList<>();
		list = tipoMedicoService.findAllAct();
		if(!list.isEmpty()) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.notFound().build();
		
	}

}
