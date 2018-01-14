package myservlet;

import domain.Food;
import domain.FoodDaoImpl;
import utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "FoodUpdateServlet", urlPatterns = "/FoodUpdateServlet")
public class FoodUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath = this.getServletContext().getRealPath("/upload");
        Map<String, Object> map = UploadUtils.UploadFile(request, savePath);
        FoodDaoImpl.updateFood(map);
        request.setAttribute("show_way", "all");
        request.getRequestDispatcher("showFoodList.jsp").forward(request, response);
    }
}
