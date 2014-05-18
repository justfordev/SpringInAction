package com.wuxz.springinaction.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuxz.springinaction.dao.ILoginLogDao;
import com.wuxz.springinaction.dao.IUserDao;
import com.wuxz.springinaction.domain.LoginLog;
import com.wuxz.springinaction.domain.User;
import com.wuxz.springinaction.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private ILoginLogDao loginLogDao;

	@Override
	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}

	@Override
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	@Override
	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		userDao.updateLoginInfo(user);
		
		LoginLog loginLog = new LoginLog();
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDatetime(new Date());
		loginLog.setUserId(user.getUserId());
		loginLogDao.insertLoginLog(loginLog);
	}

}
