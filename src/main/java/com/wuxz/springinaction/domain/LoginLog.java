package com.wuxz.springinaction.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
	private static final long serialVersionUID = -4941492010641162785L;
	private int loginLogId;
	private int userId;
	private String ip;
	private Date loginDatetime;

	public int getLoginLogId() {
		return loginLogId;
	}

	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDatetime() {
		return loginDatetime;
	}

	public void setLoginDatetime(Date loginDatetime) {
		this.loginDatetime = loginDatetime;
	}

	@Override
	public String toString() {
		return "LoginLog [loginLogId=" + loginLogId + ", userId=" + userId
				+ ", ip=" + ip + ", loginDatetime=" + loginDatetime + "]";
	}

}
