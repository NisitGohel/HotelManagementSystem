package controller;

import dao.UserDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String role = UserDAO.validate(username, password);

        if (role != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", role);

            if (role.equals("admin")) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("userDashboard.jsp");
            }

        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}