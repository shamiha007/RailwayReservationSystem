<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Available Trains</title>
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>

<h2>Available Trains</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Train No</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Action</th>
</tr>

<%
List<Map<String,String>> trains =
    (List<Map<String,String>>) request.getAttribute("trains");

if (trains != null && !trains.isEmpty()) {
    for (Map<String,String> t : trains) {
%>
<tr>
    <td><%= t.get("train_number") %></td>
    <td><%= t.get("train_name") %></td>
    <td><%= t.get("source") %></td>
    <td><%= t.get("destination") %></td>
    <td>
        <a href="viewSchedule?trainId=<%= t.get("train_id") %>">
            View Schedule
        </a>
    </td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="5">No trains found</td>
</tr>
<%
}
%>

</table>

<br>
<a href="search.jsp">Back</a>

</body>
</html>
