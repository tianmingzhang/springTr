package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smart.domain.LoginLog;

import java.util.Random;

@Repository
public class LoginLogDao {
	private JdbcTemplate jdbcTemplate;

	//保存登陆日志SQL
	private final static String INSERT_LOGIN_LOG_SQL= "INSERT INTO t_login_log(login_log_id,user_id,ip,login_datetime) VALUES(?,?,?,?)";
	
	public void insertLoginLog(LoginLog loginLog) {
		Random rand = new Random();
		int log_id;
		log_id = rand.nextInt(10000);
		Object[] args = { log_id,loginLog.getUserId(), loginLog.getIp(),
				          loginLog.getLoginDate() };
		jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}