package com.fourth.dao;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signUpAsJs")
public class signUpAsJs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signUpAsJs() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("JSfname");
		String ln=request.getParameter("JSlname");
		String dob=request.getParameter("JSdate");
		String phone=request.getParameter("JSphone");
		String email=request.getParameter("JSemali");
		String pass=request.getParameter("JSpass");
		String address=request.getParameter("JSaddress");
		String edu=request.getParameter("JSedu");
		int exp=Integer.parseInt(request.getParameter("JSexp"));
		String city=request.getParameter("JScity");
		String state=request.getParameter("JSstate");
		if(fn.isEmpty() && ln.isEmpty()&&dob.isEmpty()&&phone.isEmpty()&&email.isEmpty()&&pass.isEmpty()&&address.isEmpty()&&edu.isEmpty()&&city.isEmpty()&&state.isEmpty())
		{
			response.sendRedirect("SignUpAsJS.jsp");
		}
				
		SignUpDAO Check = new SignUpDAO();
		
		if(Check.signUpJS(fn,ln,dob,phone,email,pass,address,city,state,exp,edu))
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
