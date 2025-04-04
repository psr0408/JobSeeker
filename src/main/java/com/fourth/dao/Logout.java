package com.fourth.dao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("recru_id");
		session.removeAttribute("js_ID");
		session.removeAttribute("job_ID");
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	
	

}
