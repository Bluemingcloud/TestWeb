package com.testweb.user.service;

import java.io.IOException;

import com.testweb.user.model.UserDAO;
import com.testweb.user.model.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServiceImpl implements UserService {
	
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		
		
		if(dao.loginUser(id, pw)) {
			
		}
	}
	
	@Override
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		UserDAO dao = UserDAO.getInstance();
		String msg;
		if(dao.isIdExists(id)) {
			
			msg = "이미 존재하는 아이디 입니다.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("join.user").forward(request, response);
			
		} else {
			
			UserDTO dto = new UserDTO(id, pw, name, email, gender, null);
			dao.joinUser(dto);
			
			msg = "회원가입이 완료되었습니다.";
			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.user").forward(request, response);
		}
	}
	
	
	
}
