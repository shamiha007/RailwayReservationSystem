<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>

<html>
<head>
<title>Train Schedule</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<h2>Train Schedule</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Train No</th>
    <th>Train Name</th>
    <th>Journey Date</th>
    <th>Departure Time</th>
    <th>Available Seats</th>
    <th>Action</th>
</tr>

<%
List<Map<String,String>> schedules =
    (List<Map<String,String>>) request.getAttribute("schedules");

if (schedules != null && !schedules.isEmpty()) {
    for (Map<String,String> s : schedules) {
%>
<tr>
    <td><%= s.get("train_number") %></td>
    <td><%= s.get("train_name") %></td>
    <td><%= s.get("journey_date") %></td>
    <td><%= s.get("departure_time") %></td>
    <td><%= s.get("available_seats") %></td>
    <td>
        <a href="bookTicket.jsp?scheduleId=<%= s.get("schedule_id") %>">
            Book
        </a>
    </td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="6">No schedules available</td>
</tr>
<%
}
%>

</table>

<br>
<a href="search.jsp">Back</a>

</body>
</html>
