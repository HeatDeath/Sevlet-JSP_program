package my_servlet;

import domain.User;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收数据
        try {
            // 定义一个 Map 用于保存接收到的数据
            Map<String, String> map = new HashMap<>();

            // 创建一个 DiskFileItemFactory 对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            // 创建一个 核心解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            // 解析 request 请求，将返回的由 FileItem 对象组成的 List 存放到 list 中
            List<FileItem> list = servletFileUpload.parseRequest(request);

            // 定义一个 hobbyList，用于存放用户的兴趣爱好
            List<String> hobbyList = new ArrayList<>();

            String url = null;

            for (FileItem fileItem: list) {
                // 如果 fileItem 是 formField
                if (fileItem.isFormField()){

                    // 获得 formField 的 name 属性的值
                    String name = fileItem.getFieldName();

                    // 获得 formField 的 值
                    String value = fileItem.getString("UTF-8");

                    System.out.println(name+"    "+value);

                    // 如果接收的是 复选框的数据
                    if("hobby".equals(name)){
                        String hobbyValue = fileItem.getString("UTF-8");

                        // 接收到一个值，将这个值存入到 hobbyList 中
                        hobbyList.add(hobbyValue);

                        // 出去 List.toString() 返回字符串 两边的 "[" 和 "]"
                        hobbyValue = hobbyList.toString().substring(1, hobbyList.toString().length()-1);

                        System.out.println(name+"     "+hobbyValue);

                        // 将爱好的数据存入到 map 中
                        map.put(name, hobbyValue);

                    }else{
                        // 将数据存入到 map 中:
                        map.put(name, value);
                    }


                }

            }

            System.out.println(map);

        }catch (FileUploadException e){
            e.printStackTrace();
        }
    }
}
