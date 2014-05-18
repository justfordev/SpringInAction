package com.wuxz.springinaction.dao;

import java.util.Date;

import com.wuxz.springinaction.domain.User;

public interface IUserDao {
	int getMatchCount(String userName, String password);
	
	User findUserByUserName(String userName);
	
	void updateLoginInfo(User user);

	void updateLoginInfo(int userId, int credits, String lastIp, Date lastVisit);
	
}
