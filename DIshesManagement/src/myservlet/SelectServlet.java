package myservlet;

import domain.FoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static domain.FoodDaoImpl.getFoodByName;

@WebServlet(name = "SelectServlet", urlPatterns = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String foodName = request.getParameter("foodName");
        Map<String, Object> map = FoodDaoImpl.getFoodByName(foodName);

        System.out.println(map);

        request.setAttribute("map", map);
        request.setAttribute("show_way", "one");
        request.getRequestDispatcher("showFoodList.jsp").forward(request, response);
    }
}
