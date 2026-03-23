<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Reservations</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-4">

<h2 class="text-center">Reservations</h2>

<table class="table table-bordered text-center mt-3">

<tr class="table-dark">
<th>ID</th>
<th>Name</th>
<th>Type</th>
<th>Check-In</th>
<th>Check-Out</th>
<th>Status</th>
<th>Action</th>
</tr>

<c:forEach var="r" items="${list}">
<tr>

<td>${r.id}</td>
<td>${r.name}</td>
<td>${r.roomType}</td>
<td>${r.checkIn}</td>
<td>${r.checkOut}</td>
<td>${r.status}</td>

<td>
<a href="approve?id=${r.id}" class="btn btn-success btn-sm">Approve</a>
</td>

</tr>
</c:forEach>

</table>

<div class="text-center">
<a href="dashboard.jsp" class="btn btn-secondary">⬅ Back</a>
</div>

</div>

</body>
</html>