package com.sulcacorp.lissa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulcacorp.lissa.entity.Consulta;

@Repository
public interface IConsultaDAO extends JpaRepository<Consulta, Long>{

}
