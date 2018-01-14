package myservlet;

import domain.Food;
import domain.FoodDaoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FoodAddServlet", urlPatterns = "/FoodAddServlet")
public class FoodAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到上传文件的保存目录
        String savePath = this.getServletContext().getRealPath("/upload");
        File file = new File(savePath);

        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }

        Map<String, Object> return_food_map = UploadUtils.UploadFile(request, savePath);
        System.out.println(return_food_map);
        FoodDaoImpl.addFood(return_food_map);

        request.setAttribute("show_way", "all");

        request.getRequestDispatcher("/showFoodList.jsp").forward(request, response);

    }
}
