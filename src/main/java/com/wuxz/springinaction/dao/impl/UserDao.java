package com.wuxz.springinaction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.wuxz.springinaction.dao.IUserDao;
import com.wuxz.springinaction.domain.User;

@Repository
public class UserDao implements IUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public int getMatchCount(String userName, String password) {
		String sql = "select count(*) from t_user where user_name = ? and password = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]{userName, password});
	}

	@Override
	public User findUserByUserName(final String userName) {
		final User user = new User();
		
		String sql = "select user_id as userId, user_name as userName, password as password, credits as credits, last_visit as lastVisit, last_ip as lastIp from t_user where user_name = ?";
		jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("userId"));
				user.setUserName(userName);
				user.setPassword(rs.getString("password"));
				user.setCredits(rs.getInt("credits"));
				user.setLastVisit(rs.getDate("lastVisit"));
				user.setLastIp(rs.getString("lastIp"));
			}
		});
		
		return user;
	}

	@Override
	public void updateLoginInfo(User user) {
		updateLoginInfo(user.getUserId(), user.getCredits(), user.getLastIp(), user.getLastVisit());
	}
	
	@Override
	public void updateLoginInfo(int userId, int credits, String lastIp, Date lastVisit) {
		String sql = "update t_user set credits = ?, last_ip = ?, last_visit = ? where user_id = userId";
		jdbcTemplate.update(sql, new Object[]{credits, lastIp, lastVisit, userId});
	}

}
