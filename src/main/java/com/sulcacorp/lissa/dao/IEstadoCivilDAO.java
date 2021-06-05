package com.sulcacorp.lissa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sulcacorp.lissa.model.EstadoCivil;

@Repository
public interface IEstadoCivilDAO extends JpaRepository<EstadoCivil, Long>{

	@Query("from EstadoCivil a where a.estado = 1")
	List<EstadoCivil> findAllAct();
	
}
