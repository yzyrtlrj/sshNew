package com.cray.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cray.dao.UserDao;
import com.cray.dao.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	//注入sessionFactory
		@Autowired
		public void setSuperSessionFactory(SessionFactory sessionFactory){
			setSessionFactory(sessionFactory);
		}
			
		//DAO层用户登录的方法
		@Override
		public User login(User user) {
			// TODO Auto-generated method stub
			String hql="from User where username=? and password=?";
			List<User> list=(List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
			if(list!=null && list.size()>0){
				return list.get(0);
			}
			return null;
		}
	
}
