package com.sulcacorp.lissa.service.impl;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sulcacorp.lissa.dao.IPersonaDAO;
import com.sulcacorp.lissa.dto.PersonaDTO;
import com.sulcacorp.lissa.model.Persona;
import com.sulcacorp.lissa.service.IPersonaService;
import com.sulcacorp.lissa.service.exception.CustomServiceException;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDAO dao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Persona buscarXDoc(String numDoc) {
		return dao.buscarXDni(numDoc);
	}

	@Override
	public List<Persona> listarFullName(String fullName) {
		return dao.listarFullName(fullName);
	}

	@Override
	public Persona buscarXDoc(Long typeDOc, String numDoc) {
		return dao.buscarXDoc(typeDOc, numDoc);
	}

	@Override
	public PersonaDTO save(PersonaDTO t) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaDTO update(PersonaDTO t) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaDTO findById(Long id) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaDTO> findAllAct() throws CustomServiceException {
		List<Persona> list = new ArrayList<>();
		List<PersonaDTO> listDto = new ArrayList<>();
		list = dao.findAll();
		if(!list.isEmpty()) {
			for (Persona persona : list) {
				listDto.add(convertToDto(persona));
			}
			return listDto;
		}
		return listDto;
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		// TODO Auto-generated method stub
		
	}
	
	
	private PersonaDTO convertToDto(Persona entity) {
		PersonaDTO dto = modelMapper.map(entity, PersonaDTO.class);
		return dto;
	}

	private Persona convertToEntity(PersonaDTO dto) {
		Persona entity = modelMapper.map(dto, Persona.class);		
		return entity;
	}

}
