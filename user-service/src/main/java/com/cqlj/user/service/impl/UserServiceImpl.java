package com.cqlj.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqlj.user.dao.UserDao;
import com.cqlj.user.model.User;
import com.cqlj.user.service.UserService;

/**
 * 用户service实现类
 * 
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
