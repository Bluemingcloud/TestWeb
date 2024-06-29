package com.testweb.user.service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
	
}
