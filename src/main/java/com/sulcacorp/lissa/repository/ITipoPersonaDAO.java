package com.sulcacorp.lissa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulcacorp.lissa.entity.TipoPersona;

@Repository
public interface ITipoPersonaDAO extends JpaRepository<TipoPersona, Long>{
	
}
