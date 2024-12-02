package com.fourth.dao;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signUpAsRe")
public class signUpAsRe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signUpAsRe() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("REfname");
		String ln=request.getParameter("RElname");
		String phone=request.getParameter("REphone");
		String email=request.getParameter("REemali");
		String pass=request.getParameter("REpass");
		String org=request.getParameter("REOrg");
		String city=request.getParameter("REcity");
		
		if(fn.isEmpty()||ln.isEmpty()||phone.isEmpty()||email.isEmpty()||pass.isEmpty()||org.isEmpty()||city.isEmpty())
		{
			response.sendRedirect("SignUpAdRE.jsp");
		}
		
		
		SignUpDAO Check = new SignUpDAO();
		
		if(Check.signUpRE(fn,ln,phone,email,pass,org,city))
		{
			HttpSession session =request.getSession();
			session.setAttribute("username",fn+" " +ln);

			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body bgcolor='lightblue'>");
			out.println("<font color='red'>");
			out.println("No Row Update");
			out.println("</font>");
			out.println("</body>");
			out.println("</html>");
			
		}
		
		
	}

}
