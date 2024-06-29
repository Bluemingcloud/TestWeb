package com.testweb.controller;

import java.io.IOException;

import com.testweb.user.service.UserService;
import com.testweb.user.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.user")
public class UserController extends HttpServlet{
	
	public UserController() {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String command = uri.substring(path.length());
		
		System.out.println(command);
		
		UserService service;
		
		
		// forward
		if(command.equals("/index.user")) { // HOME 화면
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else if(command.equals("/member.user")) { // MEMBER 화면
			request.getRequestDispatcher("member/member.jsp").forward(request, response);
			
		} else if(command.equals("/login.user")) { // LOGIN 화면
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
			
		} else if(command.equals("/user/login.user")) { // LOGIN 기능
			service = new UserServiceImpl();
			service.login(request, response);
			
		} else if(command.equals("/join.user")) { // JOIN 화면
			request.getRequestDispatcher("user/join.jsp").forward(request, response);
			
		} else if(command.equals("/user/join.user")) { // JOIN 기능
			service = new UserServiceImpl();
			service.join(request, response);
			
		}
		
		
	}

}
