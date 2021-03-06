package servlet;

import utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddBookServlet", urlPatterns = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> book_message = DBUtil.form_post_handle(request);
        DBUtil.addBook(DBUtil.mapToBook(book_message));
        this.getServletContext().setAttribute("bookDb", DBUtil.getBookDb());
        response.sendRedirect("showBooks.jsp");
    }
}
