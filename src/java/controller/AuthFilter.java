package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        String role = (session != null) ? (String) session.getAttribute("role") : null;

        boolean loginRequest = uri.contains("login.jsp") || uri.contains("login");

        if (!loggedIn && !loginRequest) {
            res.sendRedirect("login.jsp");
            return;
        }

        // Admin only pages
        if (uri.contains("addRoom") || uri.contains("viewRooms")) {
            if (!"admin".equals(role)) {
                res.sendRedirect("userDashboard.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}