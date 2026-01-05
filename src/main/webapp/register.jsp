<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>

<h2>User Registration</h2>

<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
    <p style="color:green;"><%= msg %></p>
<%
}
%>

<form action="register" method="post">
    Username:
    <input type="text" name="username" required><br><br>

    Password:
    <input type="password" name="password" required><br><br>

    Full Name:
    <input type="text" name="fullName" required><br><br>

    Email:
    <input type="email" name="email" required><br><br>

    <input type="submit" value="Register">
</form>

<br>
<a href="login.jsp">Already have an account? Login</a>

</body>
</html>
