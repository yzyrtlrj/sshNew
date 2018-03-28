package com.cray.dao;

public interface BaseDao<T> {
	
	T findById(Long id);

	void update(T entity);
}
