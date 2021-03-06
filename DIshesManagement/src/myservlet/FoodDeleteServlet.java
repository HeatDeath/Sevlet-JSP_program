package myservlet;

import domain.FoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodDeleteServlet", urlPatterns = "/FoodDeleteServlet")
public class FoodDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID = request.getParameter("id");
        FoodDaoImpl.deleteFoodById(foodID);
        request.setAttribute("show_way", "all");
        request.getRequestDispatcher("showFoodList.jsp").forward(request, response);
    }
}
