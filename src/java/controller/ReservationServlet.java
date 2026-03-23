package controller;

import dao.ReservationDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Date;

@WebServlet({"/reserve", "/viewReservations", "/approve"})
public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String type = request.getParameter("type");

            Date checkIn = Date.valueOf(request.getParameter("checkIn"));
            Date checkOut = Date.valueOf(request.getParameter("checkOut"));

            // Validation
            if (checkOut.before(checkIn)) {
                response.getWriter().println("Invalid Dates!");
                return;
            }

            ReservationDAO.addReservation(name, type, checkIn, checkOut);

            response.sendRedirect("reservation.jsp?success=1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if (path.equals("/viewReservations")) {

            request.setAttribute("list", ReservationDAO.getAllReservations());
            request.getRequestDispatcher("viewReservations.jsp").forward(request, response);

        } else if (path.equals("/approve")) {

            int id = Integer.parseInt(request.getParameter("id"));

            ReservationDAO.approveReservation(id);

            response.sendRedirect("viewReservations");
        }
    }
}