<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>


<%
    if ("true".equals(request.getParameter("added"))) {
%>
    <script>
        alert("Train added successfully");
    </script>
<%
    }
%>
<%
    if ("true".equals(request.getParameter("scheduleAdded"))) {
%>
    <script>
        alert("Train schedule added successfully");
    </script>
<%
    }
%>


<div class="dashboard">
    <h2>Admin Dashboard</h2>

    <ul>
    <li><a href="addTrain.jsp">Add Train</a></li>
    <li><a href="addSchedule.jsp">Add Train Schedule</a></li>
    <li><a href="adminViewTrains.jsp">View Trains & Schedules</a></li>
    <li><a href="viewUsers">View All Users</a></li>
    <li><a href="viewAllBookings">View All Bookings</a></li>
    <li><a href="logout">Logout</a></li>
</ul>
    
</div>

</body>
</html>
