package com.sulcacorp.lissa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sulcacorp.lissa.model.Especialidad;

@Repository
public interface IEspecialidadDAO  extends JpaRepository<Especialidad, Long>{
	
	@Query("select e from Especialidad e where e.estado = 1")
	List<Especialidad> findAllAct();

}
