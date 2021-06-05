package com.sulcacorp.lissa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sulcacorp.lissa.model.TipoDocumento;

@Repository
public interface ITipoDocumentoDAO extends JpaRepository<TipoDocumento, Long>{

	@Query("from TipoDocumento a where a.estado = 1")
	List<TipoDocumento> findAllAct();

}
