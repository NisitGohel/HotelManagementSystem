<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Payment</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
<h2 class="text-center">💳 Payment</h2>

<form action="pay" method="post" class="card p-4">

<input type="text" name="roomId" value="${param.roomId}" class="form-control mb-3" readonly>

<select name="method" class="form-control mb-3">
<option>UPI</option>
<option>Card</option>
<option>Cash</option>
</select>

<button class="btn btn-success">Pay Now</button>

</form>

</div>
</body>
</html>