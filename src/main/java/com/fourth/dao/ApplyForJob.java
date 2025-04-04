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

@WebServlet("/ApplyForJob")
public class ApplyForJob extends HttpServlet {
	private String URL="jdbc:mysql://localhost:3306/jobseeker";
	private String DBUsername = "root";
	private String DBPassword = "1Pr@#h@nt567";
	private String Driver="com.mysql.cj.jdbc.Driver";
	private Connection con=null;
	private PreparedStatement  st=null;
	private ResultSet rs=null;
	private static int js_ID;
	private static int job_ID;
	private static int recru_id;
	private static final long serialVersionUID = 1L;
    public ApplyForJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
				response.setHeader("Pragma", "no-cache");//HTTP 1.0
				response.setHeader("Expires", "0");//PROXIES
				HttpSession session =request.getSession();
			     if(session.getAttribute("username")==null){
			        response.sendRedirect("login.jsp");
			      }
			     
			      job_ID=Integer.parseInt(request.getParameter("applyJobnum"));
			     	//job_ID =(int) session.getAttribute("job_id");
			    	js_ID =(int) session.getAttribute("js_id");
			    	
	
			     response.setContentType("text/html");
				    PrintWriter out=response.getWriter();
					out.println("<html>");
					out.println("<body bgcolor='lightyellow'>");
						try
						{
						Class.forName(Driver);
						con = DriverManager.getConnection(URL,DBUsername,DBPassword);
						String quary="select recru_id from jobs where job_id="+job_ID;
						st = con.prepareStatement(quary);
						rs=st.executeQuery(quary);
						if(rs.next()) {
						 recru_id = Integer.parseInt(rs.getString(1));
						out.println("Successfully applied for job!");}
						else
						{
							out.println("<font color='red'>");
							out.println("Error:Job S.NO Is not Correct");
							out.println("</font>");	
						}
						}
						
						catch(Exception sqle){
							out.println("<font color='red'>");
							out.println("Error:Sql Exception"+sqle);
							out.println("</font>");
						} 
									
						
						try {
							
							String Quarry="insert into applying_jobs(recru_id,job_id,js_id) values("+recru_id+","+job_ID+","+js_ID+") ";
							st = con.prepareStatement(Quarry);
							int count=st.executeUpdate(Quarry);
							if(count==0)
							{
								out.println("<font color='red'>");
								out.println("No Row Update");
								out.println("</font>");
							}
							else{
								out.println("<font color='green'>");
								out.println("Your Record is Saved");
								out.println("</font>");
							}
							}
							catch (Exception e)	{			
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
						out.println("</body>");
						out.println("</html>");

		
    	
    	
		
	}

}

//
//package com.fourth.dao;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/ApplyForJob")
//public class ApplyForJob extends HttpServlet {
//    private String URL = "jdbc:mysql://localhost:3306/jobseeker";
//    private String DBUsername = "root";
//    private String DBPassword = "1Pr@#h@nt567";
//    private String Driver = "com.mysql.cj.jdbc.Driver";
//    private Connection con = null;
//    private PreparedStatement st = null;
//    private ResultSet rs = null;
//    private static int js_ID;
//    private static int job_ID;
//    private static int recru_id;
//    private static final long serialVersionUID = 1L;
//
//    public ApplyForJob() {
//        super();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
//        response.setHeader("Pragma", "no-cache");//HTTP 1.0
//        response.setHeader("Expires", "0");//PROXIES
//        HttpSession session = request.getSession();
//        if (session.getAttribute("username") == null) {
//            response.sendRedirect("login.jsp");
//        }
//
//        job_ID = Integer.parseInt(request.getParameter("applyJobnum"));
//        js_ID = (int) session.getAttribute("js_id");
//
//        try {
//            Class.forName(Driver);
//            con = DriverManager.getConnection(URL, DBUsername, DBPassword);
//            String query = "select recru_id from jobs where job_id=?";
//            st = con.prepareStatement(query);
//            st.setInt(1, job_ID);
//            rs = st.executeQuery();
//
//            if (rs.next()) {
//                recru_id = rs.getInt(1);
//                request.setAttribute("successMessage", "Successfully applied for job!");
//            } else {
//                request.setAttribute("errorMessage", "Error: Job S.NO Is not Correct");
//            }
//
//            String quarry = "insert into applying_jobs(recru_id,job_id,js_id) values(?,?,?)";
//            st = con.prepareStatement(quarry);
//            st.setInt(1, recru_id);
//            st.setInt(2, job_ID);
//            st.setInt(3, js_ID);
//            int count = st.executeUpdate();
//            if (count == 0) {
//                request.setAttribute("errorMessage", "No Row Updated");
//            } else {
//                request.setAttribute("successMessage", "Your Record is Saved");
//            }
//        } catch (Exception e) {
//            request.setAttribute("errorMessage", "Error: SQL Exception " + e.getMessage());
//        } finally {
//            try {
//                if (st != null) st.close();
//                if (con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        // Forward the request to the JSP page
//        request.getRequestDispatcher("applyForJobResult.jsp").forward(request, response);
//    }
//}
//
