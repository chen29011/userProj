package com.cqlj.user.dao;

import com.cqlj.user.model.User;

/**
 * 用户登录
 * @author Administrator
 *
 */
public interface UserDao {
	public User login(User user);
}
