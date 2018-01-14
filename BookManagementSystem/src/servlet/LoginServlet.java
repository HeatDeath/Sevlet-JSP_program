package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> user_message = (Map<String, String>) this.getServletContext().getAttribute("user_message");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (user_message.get("username").equals(username) && user_message.get("password").equals(password)) {
            request.getSession().setAttribute("loginUser", username);
            response.sendRedirect("server.jsp");
        }else {
            response.sendRedirect("index.jsp?flag=0");
        }
    }
}
