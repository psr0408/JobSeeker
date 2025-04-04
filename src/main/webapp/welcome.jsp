<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//Remove Cache To prevent to open pages with added Login Control
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
	response.setHeader("Pragma", "no-cache");//HTTP 1.0
	response.setHeader("Expires", "0");//PROXIES
	
     if(session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
      }
 %>
<div style="font-family: Arial, sans-serif; text-align: center; margin-top: 50px;">
    <p style="font-size: 20px; color: #333;">Welcome ${username}</p>

    <form action="Logout" style="margin: 20px;">
        <input type="submit" value="Logout" 
            style="background-color: #ff4d4d; color: white; border: none; padding: 10px 20px; 
                   border-radius: 5px; cursor: pointer; font-size: 16px;">
    </form>


    <form action="ViewAllJobs" method="post" style="margin: 20px;">
        <input type="submit" value="View Jobs" 
            style="background-color: #4CAF50; color: white; border: none; padding: 10px 20px; 
                   border-radius: 5px; cursor: pointer; font-size: 16px;">
    </form>
</div>

</body>
	

</html>