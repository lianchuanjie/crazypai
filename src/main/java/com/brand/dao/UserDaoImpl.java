package com.brand.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brand.model.AcctUser;

/**
 * 创建时间：2015-2-6 下午2:45:14
 * 
 * @author andy
 * @version 2.2
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public AcctUser load(String id) {
		return (AcctUser) this.getCurrentSession().load(AcctUser.class, id);
	}
	
	@Override
	public AcctUser get(String id) {
		return (AcctUser) this.getCurrentSession().get(AcctUser.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcctUser> findAll() {
		List<AcctUser> acctUsers = this.getCurrentSession().createQuery("from AcctUser").setCacheable(true).list();
		return acctUsers;
	}

	@Override
	public void persist(AcctUser entity) {
		this.getCurrentSession().persist(entity);

	}

	@Override
	public String save(AcctUser entity) {
		return (String) this.getCurrentSession().save(entity);
	}
	

	@Override
	public void saveOrUpdate(AcctUser entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(String id) {
		AcctUser entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	@Override
	public void flush() {
		this.getCurrentSession().flush();

	}

	@Override
	public void update(AcctUser entity) {
		this.getCurrentSession().update(entity);

	}

}
