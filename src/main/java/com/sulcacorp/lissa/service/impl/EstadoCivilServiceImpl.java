package com.sulcacorp.lissa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.lissa.dao.IEstadoCivilDAO;
import com.sulcacorp.lissa.dto.EstadoCivilDTO;
import com.sulcacorp.lissa.model.EstadoCivil;
import com.sulcacorp.lissa.service.IEstadoCivilService;
import com.sulcacorp.lissa.service.exception.CustomServiceException;

@Service
public class EstadoCivilServiceImpl implements IEstadoCivilService{

	@Autowired
	private IEstadoCivilDAO dao;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EstadoCivilDTO save(EstadoCivilDTO t) throws CustomServiceException{
		t.setDescripcion(t.getDescripcion().toUpperCase().trim());		
		return convertToDto(dao.saveAndFlush(convertToEntity(t)));
	}

	@Override
	public EstadoCivilDTO update(EstadoCivilDTO t) throws CustomServiceException{
		t.setDescripcion(t.getDescripcion().toUpperCase().trim());		
		return convertToDto(dao.saveAndFlush(convertToEntity(t)));
	}

	@Override
	public EstadoCivilDTO findById(Long id) throws CustomServiceException{
		Optional<EstadoCivil> opt = dao.findById(id);;
		return opt.isPresent()?convertToDto(opt.get()):null;
	}

	@Override
	public List<EstadoCivilDTO> findAllAct() throws CustomServiceException{
		List<EstadoCivil> list = null;
		list = dao.findAllAct();
		if(!list.isEmpty()) {
			return list.stream().map(this::convertToDto).collect(Collectors.toList());
		}
		return new ArrayList<EstadoCivilDTO>();
	}

	@Override
	public void delete(Long id) throws CustomServiceException{
		dao.deleteById(id);		
	}
	
	private EstadoCivilDTO convertToDto(EstadoCivil entity) {
		EstadoCivilDTO estadoCivilDTO = modelMapper.map(entity, EstadoCivilDTO.class);
		return estadoCivilDTO;
	}

	private EstadoCivil convertToEntity(EstadoCivilDTO dto) {
		EstadoCivil estadoCivil = modelMapper.map(dto, EstadoCivil.class);		
		return estadoCivil;
	}
	

}
