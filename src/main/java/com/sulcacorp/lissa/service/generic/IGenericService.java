package com.sulcacorp.lissa.service.generic;

import java.io.Serializable;
import java.util.List;

import com.sulcacorp.lissa.service.exception.CustomServiceException;

public interface IGenericService<T, ID extends Serializable> {
	T save(T t) throws CustomServiceException;
	T update(T t) throws CustomServiceException;
	T findById(ID id) throws CustomServiceException;
	List<T> findAllAct() throws CustomServiceException;
	void delete(ID id) throws CustomServiceException;
}
