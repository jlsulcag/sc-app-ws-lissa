package com.sulcacorp.lissa.service;

import java.util.List;

import com.sulcacorp.lissa.dto.PersonaDTO;
import com.sulcacorp.lissa.model.Persona;
import com.sulcacorp.lissa.service.generic.IGenericService;

public interface IPersonaService extends IGenericService<PersonaDTO, Long>{

	Persona buscarXDoc(String numDoc);

	List<Persona> listarFullName(String fullName);

	Persona buscarXDoc(Long typeDOc, String numDoc);

}
