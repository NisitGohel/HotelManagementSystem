<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <!-- Header -->
    <div class="d-flex justify-content-between align-items-center">
        <h2>🏨 Dashboard</h2>
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>

    <hr>

    <!-- MAIN MODULES -->
    <div class="row mt-4 g-3">

        <div class="col-md-4">
            <a href="addRoom.jsp" class="btn btn-primary w-100 p-3">
                ➕ Add Room
            </a>
        </div>

        <div class="col-md-4">
            <a href="viewRooms" class="btn btn-success w-100 p-3">
                📋 View Rooms
            </a>
        </div>

        <div class="col-md-4">
            <a href="bookRoom.jsp" class="btn btn-warning w-100 p-3">
                📅 Book Room
            </a>
        </div>

    </div>

    <!-- RESERVATION -->
    <div class="row mt-4 g-3">

        <div class="col-md-6">
            <a href="reservation.jsp" class="btn btn-info w-100 p-3">
                🌐 Online Reservation
            </a>
        </div>

        <div class="col-md-6">
            <a href="viewReservations" class="btn btn-secondary w-100 p-3">
                📄 View Reservations
            </a>
        </div>

    </div>

    <!-- ANALYTICS -->
    <div class="row mt-4 g-3">

        <div class="col-md-12">
            <a href="analytics" class="btn btn-dark w-100 p-3">
                📊 Revenue Analytics
            </a>
        </div>

    </div>

</div>

</body>
</html>