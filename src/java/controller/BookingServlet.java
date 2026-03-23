package controller;

import dao.BookingDAO;
import db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet({"/checkout", "/bill"})
public class BookingServlet extends HttpServlet {

    // 👉 BOOK ROOM (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            String name = request.getParameter("name");
            int days = Integer.parseInt(request.getParameter("days"));

            // Call DAO
            BookingDAO.bookRoom(roomId, name, days);

            // Redirect to view rooms
            response.sendRedirect("viewRooms");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error in BookingServlet doPost()");
        }
    }

    // 👉 CHECKOUT + BILL (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        try {

            // ✅ CHECKOUT
            if (path.equals("/checkout")) {

                int roomId = Integer.parseInt(request.getParameter("roomId"));

                Connection con = DBConnection.getConnection();

                // Update room status
                PreparedStatement pst = con.prepareStatement(
                        "UPDATE room SET status='Available' WHERE room_id=?"
                );
                pst.setInt(1, roomId);
                pst.executeUpdate();

                response.sendRedirect("viewRooms");
            }

            // ✅ BILL GENERATION
            else if (path.equals("/bill")) {

                int roomId = Integer.parseInt(request.getParameter("roomId"));

                ResultSet rs = BookingDAO.getBill(roomId);

                request.setAttribute("billData", rs);

                RequestDispatcher rd = request.getRequestDispatcher("bill.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error in BookingServlet doGet()");
        }
    }
}