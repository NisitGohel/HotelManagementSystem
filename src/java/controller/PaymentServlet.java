package controller;

import dao.PaymentDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/pay")
public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String method = request.getParameter("method");

        PaymentDAO.makePayment(roomId, method);

        response.sendRedirect("viewRooms");
    }
}