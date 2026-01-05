<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Delete</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Confirm Deletion</h2>

<p>Are you sure you want to delete this train schedule?</p>

<a href="adminDeleteSchedule?scheduleId=<%= request.getParameter("scheduleId") %>">
   YES, Delete
</a>

<a href="adminViewTrains.jsp">
   NO, Go Back
</a>

</body>
</html>
