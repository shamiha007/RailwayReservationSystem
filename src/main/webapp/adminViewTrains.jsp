<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="com.railway.util.DBUtil" %>

<!DOCTYPE html>
<html>
<head>
    <title>Trains & Schedules</title>
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>

<h2>Trains & Schedules</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Train No</th>
        <th>Train Name</th>
        <th>Source</th>
        <th>Destination</th>
        <th>Journey Date</th>
        <th>Departure Time</th>
        <th>Available Seats</th>
        <th>Action</th>
    </tr>

<%
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = DBUtil.getConnection();

        String sql =
            "SELECT s.schedule_id, t.train_number, t.train_name, t.source, t.destination, " +
            "s.journey_date, s.departure_time, s.available_seats " +
            "FROM train_schedule s " +
            "JOIN trains t ON s.train_id = t.train_id " +
            "ORDER BY s.journey_date";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        boolean found = false;

        while (rs.next()) {
            found = true;
%>
    <tr>
        <td><%= rs.getString("train_number") %></td>
        <td><%= rs.getString("train_name") %></td>
        <td><%= rs.getString("source") %></td>
        <td><%= rs.getString("destination") %></td>
        <td><%= rs.getDate("journey_date") %></td>
        <td><%= rs.getTime("departure_time") %></td>
        <td><%= rs.getInt("available_seats") %></td>
        <td>
            <a class="btn btn-action"
       href="confirmDeleteSchedule.jsp?scheduleId=<%= rs.getInt("schedule_id") %>">
       Delete
    </a>
        </td>
    </tr>
<%
        }

        if (!found) {
%>
    <tr>
        <td colspan="8">No schedules found</td>
    </tr>
<%
        }

    } catch (Exception e) {
        out.println("<tr><td colspan='8'>Error loading schedules</td></tr>");
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
%>

</table>

<br>
<a href="adminHome.jsp">Back</a>

</body>
</html>
