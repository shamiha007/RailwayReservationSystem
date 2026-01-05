<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Trains</title>
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>
<%
    if ("true".equals(request.getParameter("loginSuccess"))) {
%>
<script>
    alert("Login successful!");
</script>
<%
    }
%>


<h2>Search Trains</h2>

<form action="searchTrains" method="post">
    Source:
    <input type="text" name="source" required><br><br>

    Destination:
    <input type="text" name="destination" required><br><br>

    <input type="submit" value="Search">
</form>

<br>
<a href="login.jsp">Logout</a>

</body>
</html>
