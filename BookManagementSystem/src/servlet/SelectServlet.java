package servlet;

import model.Book;
import org.json.JSONObject;
import utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.alibaba.fastjson.JSON;

@WebServlet(name = "SelectServlet", urlPatterns = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookID = request.getParameter("bookID");
        String bookName =request.getParameter("bookName");
        String catgoryName = request.getParameter("catgoryName");
        List<Book> conditionBook = DBUtil.getBooksByCondition(bookID, bookName, catgoryName);
//        本来想使用这种方法，但是始终提示 找不到 fromObject() 方法，不知道是什么原因
//        JSONObject jsonObject = JSONObject.fromObject();
        String json_string = JSON.toJSONString(conditionBook);
        String return_json = "{conditionBook:" + json_string + "}";
        JSONObject jsonObject = new JSONObject(return_json);
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
    }
}
