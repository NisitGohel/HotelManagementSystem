<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Rooms</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <h2 class="text-center mb-4">🏨 Room List</h2>

    <table class="table table-bordered table-striped text-center">
        <thead class="table-dark">
            <tr>
                <th>Room ID</th>
                <th>Type</th>
                <th>Price</th>
                <th>Status</th>
                <th>Payment</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>

        <c:choose>
            <c:when test="${not empty roomList}">
                <c:forEach var="r" items="${roomList}">
                    <tr>

                        <td>${r.id}</td>
                        <td>${r.type}</td>
                        <td>₹ ${r.price}</td>

                        <!-- Status -->
                        <td>
                            <c:choose>
                                <c:when test="${r.status == 'Booked'}">
                                    <span class="badge bg-danger">Booked</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-success">Available</span>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <!-- Payment Status (simple logic) -->
                        <td>
                            <c:choose>
                                <c:when test="${r.status == 'Booked'}">
                                    <span class="badge bg-warning text-dark">Pending</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-success">Paid</span>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <!-- Actions -->
                        <td>

                            <!-- Checkout -->
                            <c:if test="${r.status == 'Booked'}">
                                <a href="checkout?roomId=${r.id}" 
                                   class="btn btn-danger btn-sm">Checkout</a>
                            </c:if>

                            <!-- Bill -->
                            <a href="bill?roomId=${r.id}" 
                               class="btn btn-info btn-sm">Bill</a>

                            <!-- Payment -->
                            <a href="payment.jsp?roomId=${r.id}" 
                               class="btn btn-success btn-sm">Pay</a>

                        </td>

                    </tr>
                </c:forEach>
            </c:when>

            <c:otherwise>
                <tr>
                    <td colspan="6">No Rooms Available</td>
                </tr>
            </c:otherwise>

        </c:choose>

        </tbody>
    </table>

    <div class="text-center mt-3">
        <a href="dashboard.jsp" class="btn btn-secondary">⬅ Back to Dashboard</a>
    </div>

</div>

</body>
</html>