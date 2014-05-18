package com.wuxz.springinaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wuxz.springinaction.dao.ILoginLogDao;
import com.wuxz.springinaction.domain.LoginLog;

@Repository
public class LoginLogDao implements ILoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertLoginLog(LoginLog loginLog) {
		String sql = "insert into t_login_log (user_id, ip, login_datetime) values (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[]{loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDatetime()});
	}

}
