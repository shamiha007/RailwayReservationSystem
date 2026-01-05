<%@ page import="java.sql.*" %>
<%@ page import="com.railway.util.DBUtil" %>

<!DOCTYPE html>
<html>
<head>
<title>Add Train Schedule</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<h2>Add Train Schedule</h2>

<form action="addSchedule" method="post">

Train:
<select name="trainId" required>
    <option value="">-- Select Train --</option>
    <%
        Connection con = DBUtil.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT train_id, train_number, train_name FROM trains");
        while(rs.next()){
    %>
        <option value="<%=rs.getInt("train_id")%>">
            <%=rs.getString("train_number")%> - <%=rs.getString("train_name")%>
        </option>
    <%
        }
    %>
</select>
<br><br>

Journey Date:
<input type="date" name="journeyDate" required>
<br><br>

Departure Time:
<input type="time" name="departureTime" required>
<br><br>

Available Seats:
<input type="number" name="availableSeats" required>
<br><br>

<input type="submit" value="Add Schedule">

</form>

<br>
<a href="adminHome.jsp">Back</a>

</body>
</html>
