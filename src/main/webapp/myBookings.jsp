<%@ page language="java" %>
<%@ page import="java.sql.ResultSet" %>

<html>
<head>
<title>My Bookings</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
<%
    if ("true".equals(request.getParameter("booked"))) {
%>
    <script>
        alert("Tickets booked successfully!");
    </script>
<%
    }
%>
<%
    if ("true".equals(request.getParameter("cancelled"))) {
%>
    <p style="color:green; font-weight:bold;">
        Booking cancelled successfully!
    </p>
<%
    }
%>



<h2>My Bookings</h2>

<table border="1">
<tr>
    <th>Train No</th>
    <th>Train Name</th>
    <th>Journey Date</th>
    <th>Departure Time</th>
    <th>Seats</th>
    <th>Action</th>
</tr>

<%
ResultSet rs = (ResultSet) request.getAttribute("bookings");
boolean hasData = false;

while (rs != null && rs.next()) {
    hasData = true;
%>
<tr>
    <td><%= rs.getString("train_number") %></td>
    <td><%= rs.getString("train_name") %></td>
    <td><%= rs.getDate("journey_date") %></td>
    <td><%= rs.getTime("departure_time") %></td>
    <td><%= rs.getInt("seats") %></td>
    <td>
        <a href="confirmCancel.jsp?bookingId=<%= rs.getInt("booking_id") %>"
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
    <td colspan="6">No bookings found</td>
</tr>
<%
}
%>

</table>

<br>

    
    <a href="search.jsp" class="btn">Book More Tickets</a>

    <a href="logout" class="btn logout-btn">Logout</a>

</div>


</body>
</html>
