<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>
<%
    if ("true".equals(request.getParameter("registered"))) {
%>
<script>
    alert("Registration done successfully! Please login.");
</script>
<%
    }
%>


<h2>User Login</h2>
<%
String error = (String) request.getAttribute("error");
if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<%
}
%>


<form action="login" method="post">
    Username:
    <input type="text" name="username" required><br><br>

    Password:
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>

<br>
<a href="register.jsp">New User? Register Here</a>

</body>
</html>
