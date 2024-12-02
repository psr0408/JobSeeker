

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="style/style.css">
<script type="text/javascript" src="js/script.js"></script>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<div class="topnav" id="myTopnav">
  <a href="index.html" class="active">Home</a>
  <a href="login.jsp">Login</a>
  <a href="aboutUs.jsp">About Us</a>
  <a href="SignUpAdRE.jsp">Recruiter Sign Up</a>
  <a href="SignUpAsJS.jsp">Job Seeker Sign Up</a>
</div>

<form action="LoginServlet" method="post">
  <div class="container">
    <label for="uname"><b>Enter Email</b></label><br>
    <input type="email" placeholder="Enter Email" name="uname" id="uname" required><br>

    <label for="pass"><b>Enter Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="pass" id="pass" required><br>
    
    <label><b>Login As:</b></label><br>
    <input type="radio" name="LoginAs" value="jobseeker" checked> Job Seeker<br>
    <input type="radio" name="LoginAs" value="recruiter"> Recruiter<br>
        
    <button type="submit">Login</button>
  </div>
</form>

</body>
</html>
