package controller;

import dao.RoomDAO;
import model.Room;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class RoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));

        Room room = new Room(id, type, price, "Available");

        RoomDAO.addRoom(room);

        response.sendRedirect("viewRooms");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Room> rooms = RoomDAO.getAllRooms();

        request.setAttribute("roomList", rooms);

        RequestDispatcher rd = request.getRequestDispatcher("viewRooms.jsp");
        rd.forward(request, response);
    }
}