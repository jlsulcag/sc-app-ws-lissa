package com.sulcacorp.lissa.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sulcacorp.lissa.dao.ITipoMedicoDAO;
import com.sulcacorp.lissa.model.TipoMedico;
import com.sulcacorp.lissa.service.ITipoMedicoService;

@Service
public class TipoMedicoServiceImpl implements ITipoMedicoService {

	@Autowired
	private ITipoMedicoDAO tipoMedicoDAO;
	
	@Override
	public TipoMedico save(TipoMedico t) {
		return tipoMedicoDAO.saveAndFlush(t);
	}

	@Override
	public TipoMedico update(TipoMedico t) {
		return tipoMedicoDAO.saveAndFlush(t);
	}

	@Override
	public TipoMedico findById(Long id) {
		Optional<TipoMedico> op = tipoMedicoDAO.findById(id);
		return op.isPresent()?op.get(): new TipoMedico();
	}

	@Override
	public List<TipoMedico> findAllAct() {
		return tipoMedicoDAO.findAll();
	}

	@Override
	public void delete(Long id) {
		tipoMedicoDAO.deleteById(id);
		
	}

}
