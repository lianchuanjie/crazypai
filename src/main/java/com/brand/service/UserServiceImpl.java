package com.brand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brand.dao.UserDao;
import com.brand.model.AcctUser;

/**
 * 创建时间：2015-2-6 下午3:24:16
 * 
 * @author andy
 * @version 2.2 UserService 的实现
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public AcctUser load(String id) {
		return userDao.load(id);
	}

	@Override
	public AcctUser get(String id) {
		return userDao.get(id);
	}

	@Override
	public List<AcctUser> findAll() {
		return userDao.findAll();
	}

	@Override
	public void persist(AcctUser entity) {
		userDao.persist(entity);
	}

	@Override
	public String save(AcctUser entity) {
		return userDao.save(entity);
	}

	@Override
	public void saveOrUpdate(AcctUser entity) {
		userDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(String id) {
		userDao.delete(id);
	}

	@Override
	public void flush() {
		userDao.flush();
	}

	@Override
	public void update(AcctUser entity) {
		userDao.update(entity);
		
	}

}
