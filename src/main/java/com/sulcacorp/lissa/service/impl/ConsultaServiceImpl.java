package com.sulcacorp.lissa.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sulcacorp.lissa.dao.IConsultaDAO;
import com.sulcacorp.lissa.model.Consulta;
import com.sulcacorp.lissa.service.IConsultaService;
import com.sulcacorp.lissa.service.generic.GenericServiceImpl;

@Service
public class ConsultaServiceImpl extends GenericServiceImpl<Consulta, Long> implements IConsultaService{
	
	@Autowired
	private IConsultaDAO dao;

	@Override
	public JpaRepository<Consulta, Long> getDao() {
		return dao;
	}

}
