<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Reservation</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

<h3 class="text-center">Reservation</h3>

<form action="reserve" method="post" class="mt-4">

<input type="text" name="name" class="form-control mb-3" placeholder="Name">

<select name="type" class="form-control mb-3">
<option>Deluxe</option>
<option>AC</option>
</select>

<input type="date" name="checkIn" class="form-control mb-3">
<input type="date" name="checkOut" class="form-control mb-3">

<button class="btn btn-primary w-100">Submit</button>

</form>

<div class="text-center mt-3">
<a href="dashboard.jsp" class="btn btn-secondary">⬅ Back</a>
</div>

</div>

</body>
</html>