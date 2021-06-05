package com.sulcacorp.lissa.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.lissa.dao.IMedicoDAO;
import com.sulcacorp.lissa.model.Medico;
import com.sulcacorp.lissa.service.IMedicoService;
import com.sulcacorp.lissa.util.Constant;

@Service
public class MedicoServiceImpl implements IMedicoService{

	@Autowired
	private IMedicoDAO medicoDAO;
	
	@Override
	public Medico save(Medico t) {
		t.setColegiatura(StringUtils.upperCase(t.getColegiatura()));
		t.setEstado(Constant.STATUS_ENABLE);
		t.setFechaReg(LocalDate.now());
		return medicoDAO.saveAndFlush(t);
	}

	@Override
	public Medico update(Medico t) {
		t.setColegiatura(StringUtils.upperCase(t.getColegiatura()));
		t.setFechaReg(t.getFechaReg());
		return medicoDAO.saveAndFlush(t);
	}

	@Override
	public Medico findById(Long id) {
		Optional<Medico> opt = medicoDAO.findById(id);
		return opt.isPresent()?opt.get(): new Medico();
	}

	@Override
	public List<Medico> findAllAct() {
		return medicoDAO.findAll();
	}

	@Override
	public void delete(Long id) {
		medicoDAO.deleteById(id);
	}

}
