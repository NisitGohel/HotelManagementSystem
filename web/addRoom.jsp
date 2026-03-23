<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Room</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4">Add Room</h2>

    <form action="addRoom" method="post" class="card p-4 shadow">

        <div class="mb-3">
            <label>Room ID</label>
            <input type="text" name="id" class="form-control">
        </div>

        <div class="mb-3">
            <label>Type</label>
            <input type="text" name="type" class="form-control">
        </div>

        <div class="mb-3">
            <label>Price</label>
            <input type="text" name="price" class="form-control">
        </div>

        <button type="submit" class="btn btn-primary">Add Room</button>
    </form>

    <br>
    <a href="index.jsp" class="btn btn-secondary">Back</a>
</div>

</body>
</html>