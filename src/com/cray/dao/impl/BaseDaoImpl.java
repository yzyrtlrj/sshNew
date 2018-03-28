package com.cray.dao.impl;

import java.lang.reflect.ParameterizedType;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cray.dao.BaseDao;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	protected Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType parameterizedType=(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz=(Class<T>)parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public T findById(Long id) {
		// 根据Id查找
		return this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void update(T entity) {
		// 更新数据
		this.getHibernateTemplate().update(entity);
	}
	
	
	
}
