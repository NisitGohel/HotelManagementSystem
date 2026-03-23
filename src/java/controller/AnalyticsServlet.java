package controller;

import db.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet("/analytics")
public class AnalyticsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double totalRevenue = 0;

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(amount) AS total FROM payment");

            if (rs.next()) {
                totalRevenue = rs.getDouble("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("revenue", totalRevenue);
        request.getRequestDispatcher("analytics.jsp").forward(request, response);
    }
}