<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Ticket</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<h2>Book Ticket</h2>

<form action="bookTicket" method="post">

<input type="hidden" name="scheduleId"
       value="<%= request.getParameter("scheduleId") %>">

Number of Seats:
<input type="number" name="seats" min="1" required><br><br>

<input type="submit" value="Confirm Booking">

</form>

<br>
<a href="search.jsp">Cancel</a>

</body>
</html>
