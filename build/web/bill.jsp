<%@ page import="java.sql.*" %>

<h2>? Bill</h2>

<%
ResultSet rs = (ResultSet) request.getAttribute("billData");

if(rs != null && rs.next()){
%>

Room ID: <%= rs.getInt("room_id") %><br>
Customer: <%= rs.getString("customer_name") %><br>
Days: <%= rs.getInt("days") %><br>
Total: ? <%= rs.getDouble("total_amount") %><br>

<button onclick="window.print()">Print Bill</button>

<%
}
%>