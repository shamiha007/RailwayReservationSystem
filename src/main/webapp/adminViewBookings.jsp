<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="com.railway.util.DBUtil" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Bookings</title>
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>
<%
    if ("true".equals(request.getParameter("cancelled"))) {
%>
<script>
    alert("Booking cancelled successfully");
</script>
<%
    }
%>


<h2>All Bookings</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Booking ID</th>
        <th>User</th>
        <th>Train No</th>
        <th>Train Name</th>
        <th>Journey Date</th>
        <th>Departure Time</th>
        <th>Seats</th>
        <th>Action</th>
    </tr>

<%
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = DBUtil.getConnection();

        String sql =
            "SELECT b.booking_id, u.username, t.train_number, t.train_name, " +
            "s.journey_date, s.departure_time, b.seats " +
            "FROM bookings b " +
            "JOIN users u ON b.user_id = u.user_id " +
            "JOIN train_schedule s ON b.schedule_id = s.schedule_id " +
            "JOIN trains t ON s.train_id = t.train_id " +
            "ORDER BY b.booking_id DESC";

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        boolean hasData = false;

        while (rs.next()) {
            hasData = true;
%>
    <tr>
        <td><%= rs.getInt("booking_id") %></td>
        <td><%= rs.getString("username") %></td>
        <td><%= rs.getString("train_number") %></td>
        <td><%= rs.getString("train_name") %></td>
        <td><%= rs.getDate("journey_date") %></td>
        <td><%= rs.getTime("departure_time") %></td>
        <td><%= rs.getInt("seats") %></td>
        <td>
            <a href="adminCancelBooking?bookingId=<%= rs.getInt("booking_id") %>"
   class="btn btn-cancel">
   Cancel
</a>
            
        </td>
    </tr>
<%
        }

        if (!hasData) {
%>
    <tr>
        <td colspan="8">No bookings found</td>
    </tr>
<%
        }

    } catch (Exception e) {
        out.println("<tr><td colspan='8'>Error loading bookings</td></tr>");
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
