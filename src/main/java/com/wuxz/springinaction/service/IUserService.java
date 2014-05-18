package com.wuxz.springinaction.service;

import com.wuxz.springinaction.domain.User;

public interface IUserService {
	boolean hasMatchUser(String userName, String password);
	
	User findUserByUserName(String userName);
	
	void loginSuccess(User user);
}
