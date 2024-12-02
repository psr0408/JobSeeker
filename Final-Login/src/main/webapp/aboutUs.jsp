<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  <%@include file="style/style.css" %>
  </style>
  <script type="text/javascript">
  <%@include file="js/script.js" %>
  </script>
</head>


<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; line-height: 1.6; background-color: #f9f9f9; color: #333;">
<div class="topnav" id="myTopnav">
  <a href="index.html" class="active">Home</a>
  <a href="login.jsp">Login</a>
  <a href="aboutUs.jsp">About Us</a>
  <a href="SignUpAdRE.jsp">Recruiter Sign Up</a>
  <a href="SignUpAsJS.jsp">Job Seeker Sign Up</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
    <!-- Header Section -->
    <header style="background-color: #4CAF50; color: white; text-align: center; padding: 20px;">
        <h1 style="margin: 0; font-size: 2.5em;">About Us</h1>
    </header>

    <!-- Main Content Section -->
    <section style="padding: 20px; max-width: 800px; margin: auto; background-color: white; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); border-radius: 10px; margin-top: 20px;">
        <p style="font-size: 1.2em; text-align: justify;">
            Welcome to our Job Seeker Platform, a project designed to empower job seekers with tools that make job hunting easier, faster, and more efficient. 
            Our platform provides dynamic resume templates, real-time job postings, and an intuitive dashboard for managing your applications all in one place.
        </p>
        <p style="font-size: 1.2em; text-align: justify;">
            Created by <strong>Prashant Singh</strong>, this platform is a testament to our dedication to helping individuals achieve their career aspirations. 
            Launched on <strong>02-12-2024</strong>, we aim to provide a seamless experience for job seekers worldwide.
        </p>
        <p style="font-size: 1.2em; text-align: justify;">
            Thank you for choosing us as your partner in your career journey. We are here to support and inspire you every step of the way.
        </p>
    </section>

    <!-- Footer Section -->
    <footer style="text-align: center; padding: 10px; margin-top: 20px; font-size: 0.9em; background-color: #4CAF50; color: white;">
        &copy; 2024 Job Seeker Platform. All rights reserved.
    </footer>


</body>
</html>