package com.fourth.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewApplyedJobs")
public class ViewApplyedJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String URL="jdbc:mysql://localhost:3306/jobseeker";
	private String DBUsername = "root";
	private String DBPassword = "1Pr@#h@nt567";
	private String Driver="com.mysql.cj.jdbc.Driver";
	private Connection con=null;
	private PreparedStatement  st=null;
	public ViewApplyedJobs() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
	     if(session.getAttribute("username")==null){
	        response.sendRedirect("login.jsp");
	      }
	     
	    String Jobcode= request.getParameter("viewApplyedJobCode");
	    int RE_ID =(int) session.getAttribute("recru_id");
	    
	 	response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<h3>List Of Applyed Candidate</h3>");		
				try 
				{	Class.forName(Driver);
					con = DriverManager.getConnection(URL,DBUsername,DBPassword);	
					String Quarry="SELECT * FROM jobs WhERE job_code='"+Jobcode+"' And recru_id="+RE_ID;
					st = con.prepareStatement(Quarry);
					ResultSet rs =st.executeQuery();
					if(rs.next())
					{
						try
						{
							String quary="SELECT js.first_name,js.last_name,js.birth_date,js.phone,js.email,js.education,js.experience,js.address,js.city,js.state FROM applying_jobs aj join recruiters re using(recru_id) join jobs job using(job_id) join job_seekers js using(js_id) where job.job_code='"+Jobcode+"' And aj.recru_id="+RE_ID;
							st = con.prepareStatement(quary);
							rs=st.executeQuery(quary);
							out.println("<table width='100%'>");
							out.println("<tr>");
							out.println("<td>First Name</td>");
							out.println("<td>Last Name</td>");
							out.println("<td>Birth Date</td>");
							out.println("<td>Phone</td>");
							out.println("<td>Email</td>");
							out.println("<td>Education</td>");
							out.println("<td>Experience</td>");
							out.println("<td>Address</td>");
							out.println("<td>City</td>");
							out.println("<td>State</td>");
							out.println("</tr>");
							while(rs.next()) {
								out.println("<tr>");
								out.println("<td>"+rs.getString(1)+"</td>");
								out.println("<td>"+rs.getString(2)+"</td>");
								out.println("<td>"+rs.getString(3)+"</td>");
								out.println("<td>"+rs.getString(4)+"</td>");
								out.println("<td>"+rs.getString(5)+"</td>");
								out.println("<td>"+rs.getString(6)+"</td>");
								out.println("<td>"+rs.getString(7)+"</td>");
								out.println("<td>"+rs.getString(8)+"</td>");
								out.println("<td>"+rs.getString(9)+"</td>");
								out.println("<td>"+rs.getString(10)+"</td>");
								out.println("</tr>");
							}
							out.println("</table>");
							
						}
						catch(Exception e){
							out.println("<font color='red'>");
							out.println("Error:Sql Exception"+e);
							out.println("</font>");
							e.printStackTrace();
						}						
					}
					else {
						out.println("<font color='red'>");
						out.println("No Record Found");
						out.println("</font>");
					}
				}
				catch(Exception e){
				out.println("<font color='red'>");
				out.println("Error:Sql Exception"+e);
				out.println("</font>");
				e.printStackTrace();
				} 
				finally{
					try{
						if(st!=null)
							st.close();
						if(con!=null)
							con.close();
					}
					catch(SQLException e){
						e.printStackTrace();
					}
				}
		
	}

}
