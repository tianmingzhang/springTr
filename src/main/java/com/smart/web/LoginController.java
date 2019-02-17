package com.smart.web;

import java.util.Date;

import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.core.io.*;
import org.springframework.web.context.support.ServletContextResource;

import com.smart.domain.User;
import com.smart.service.UserService;

@RestController
public class LoginController{
	private UserService userService;
	private static Logger log = Logger.getLogger(LoginController.class.getClass());
	@RequestMapping(value = "/index.html")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
		boolean isValidUser =  userService.hasMatchUser(loginCommand.getUserName(),
					                    loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
			User user = userService.findUserByUserName(loginCommand
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(request,user);
			request.getSession().setAttribute("user", user);
			System.out.println("1"+request.getSession().getServletContext());
			log.info("1"+request.getSession().getServletContext());
			Resource res3 = new ServletContextResource(request.getSession().getServletContext(),"/WEB-INF/file1.txt");
			System.out.println("1"+res3.getFilename());
			return new ModelAndView("main");
		}
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
