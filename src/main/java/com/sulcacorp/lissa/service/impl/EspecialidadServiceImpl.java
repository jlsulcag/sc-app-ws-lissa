package com.sulcacorp.lissa.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.sulcacorp.lissa.dto.EspecialidadDTO;
import com.sulcacorp.lissa.model.Especialidad;
import com.sulcacorp.lissa.repository.IEspecialidadDAO;
import com.sulcacorp.lissa.service.IEspecialidadService;
import com.sulcacorp.lissa.service.exception.CustomServiceException;
import com.sulcacorp.lissa.util.Constante;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadDAO especialidadDAO;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EspecialidadDTO save(EspecialidadDTO t) {
		Especialidad especialidad = new Especialidad();
		t.setDescEspecialidad(StringUtils.upperCase(t.getDescEspecialidad()));
		t.setEstado(Constante.STATUS_REG_ENABLE);
		t.setFechaReg(LocalDateTime.now());
		especialidad = especialidadDAO.saveAndFlush(convertToEntity(t));
		return convertToDto(especialidad);
	}

	@Override
	public EspecialidadDTO update(EspecialidadDTO t){
		Especialidad especialidad = new Especialidad();
		t.setDescEspecialidad(StringUtils.upperCase(t.getDescEspecialidad()));		
		especialidad = especialidadDAO.saveAndFlush(convertToEntity(t));
		return convertToDto(especialidad);
	}

	@Override
	public EspecialidadDTO findById(Long id) {
		Optional<Especialidad> op = especialidadDAO.findById(id);
		return op.isPresent() ? convertToDto(op.get()) : null;
	}
	
	@Override
	public List<EspecialidadDTO> findAll() {
		List<Especialidad> list = new ArrayList<>();
		List<EspecialidadDTO> listDto = new ArrayList<>();
		list = especialidadDAO.findAll(Sort.by(Sort.Direction.ASC,"descEspecialidad"));
		if (!list.isEmpty()) {
			for (Especialidad especialidad : list) {
				listDto.add(convertToDto(especialidad));
			}
			return listDto;
		}
		return listDto;
	}

	@Override
	public List<EspecialidadDTO> findAllAct() {
		List<Especialidad> list = new ArrayList<>();
		List<EspecialidadDTO> listDto = new ArrayList<>();
		list = especialidadDAO.findAllAct();
		if (!list.isEmpty()) {
			for (Especialidad especialidad : list) {
				listDto.add(convertToDto(especialidad));
			}
			return listDto;
		}
		return listDto;
	}

	@Override
	public void delete(Long id) {
		especialidadDAO.deleteById(id);
	}

	private EspecialidadDTO convertToDto(Especialidad entity) {
		EspecialidadDTO dto = modelMapper.map(entity, EspecialidadDTO.class);
		return dto;
	}

	private Especialidad convertToEntity(EspecialidadDTO dto) {
		Especialidad entity = modelMapper.map(dto, Especialidad.class);
		return entity;
	}

	@Override
	public void deleteLogic(EspecialidadDTO t) throws CustomServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsByDescEspecialidad(String especialidad) {
		return especialidadDAO.existsByDescEspecialidad(especialidad.toUpperCase());
	}
}
