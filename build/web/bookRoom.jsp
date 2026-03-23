<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Book Room</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

<h3 class="text-center">Book Room</h3>

<form action="bookRoom" method="post" class="mt-4">

<input type="text" name="roomId" class="form-control mb-3" placeholder="Room ID">
<input type="text" name="name" class="form-control mb-3" placeholder="Customer Name">
<input type="text" name="days" class="form-control mb-3" placeholder="Days">

<button class="btn btn-primary w-100">Book</button>

</form>

<div class="text-center mt-3">
<a href="dashboard.jsp" class="btn btn-secondary">⬅ Back</a>
</div>

</div>

</body>
</html>