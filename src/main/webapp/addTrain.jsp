<!DOCTYPE html>
<html>
<head>
<title>Add Train</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>


<h2>Add Train</h2>

<form action="addTrain" method="post">
    Train Number:
    <input type="text" name="trainNumber" required><br><br>

    Train Name:
    <input type="text" name="trainName" required><br><br>

    Source:
    <input type="text" name="source" required><br><br>

    Destination:
    <input type="text" name="destination" required><br><br>

    <input type="submit" value="Add Train">
</form>

<br>
<a href="adminHome.jsp">Back</a>

</body>
</html>
