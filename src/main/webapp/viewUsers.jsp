<%@ page import="java.util.List" %>
<%@ page import="com.railway.model.User" %>

<!DOCTYPE html>
<html>
<head>
<title>All Users</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<h2>All Users</h2>

<table border="1">
<tr>
    <th>User ID</th>
    <th>Username</th>
    <th>Full Name</th>
    <th>Email</th>
</tr>

<%
List<User> users = (List<User>) request.getAttribute("users");
if (users != null) {
    for (User u : users) {
%>
<tr>
    <td><%= u.getUserId() %></td>
    <td><%= u.getUsername() %></td>
    <td><%= u.getFullname() %></td>
    <td><%= u.getEmail() %></td>
</tr>
<%
    }
}
%>

</table>

<br>
<a href="adminHome.jsp">Back</a>

</body>
</html>
