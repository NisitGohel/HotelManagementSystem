<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: linear-gradient(135deg,#667eea,#764ba2);
}

.card {
    border-radius: 20px;
}
</style>

</head>

<body>

<div class="container d-flex justify-content-center align-items-center" style="height:100vh;">

<div class="card p-5 shadow" style="width:350px;">
<h3 class="text-center mb-4">🔐 Login</h3>

<form action="login" method="post">
<input type="text" name="username" class="form-control mb-3" placeholder="Username">
<input type="password" name="password" class="form-control mb-3" placeholder="Password">

<button class="btn btn-dark w-100">Login</button>
</form>

</div>

</div>

</body>
</html>