package com.sulcacorp.lissa.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sulcacorp.lissa.dao.ITipoPersonaDAO;
import com.sulcacorp.lissa.model.TipoPersona;
import com.sulcacorp.lissa.service.ITipoPersonaService;
import com.sulcacorp.lissa.service.generic.GenericServiceImpl;

@Service
public class TipoPersonaServiceImpl extends GenericServiceImpl<TipoPersona, Long> implements ITipoPersonaService{
	
	@Autowired
	private ITipoPersonaDAO dao;

	@Override
	public JpaRepository<TipoPersona, Long> getDao() {
		return dao;
	}
	
	
}
