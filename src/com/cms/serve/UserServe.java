package com.cms.serve;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cms.dao.CompanyInfoDao;
import com.cms.dao.UserDao;
import com.cms.entity.User;
import com.cms.utils.MybatisUtil;

@Service
public class UserServe {
	public User checkUser(User user){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		UserDao userDao = session.getMapper(UserDao.class);
		return userDao.getUser(user); 
	}
	public int updateUser(User user){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		UserDao userDao = session.getMapper(UserDao.class);
		return userDao.updateUser(user); 
	}
}
