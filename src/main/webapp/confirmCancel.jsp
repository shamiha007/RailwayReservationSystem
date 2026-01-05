<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Cancellation</title>
</head>
<body style="text-align:center; margin-top:50px;">

    <h2>Confirm Cancellation</h2>

    <p>Are you sure you want to cancel your booking?</p>

    <%
        String bookingId = request.getParameter("bookingId");
    %>

    <!-- YES -->
    <a href="cancelBooking?bookingId=<%= bookingId %>">
        <button>Yes, Cancel</button>
    </a>

    &nbsp;&nbsp;

    <!-- NO -->
    <a href="myBookings">
        <button>No, Go Back</button>
    </a>

</body>
</html>
