package utils;

import domain.Food;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

public class UploadUtils {
    public static Map<String, Object> UploadFile(HttpServletRequest request, String uploadDirectory) {

        // 定义一个 Map 用于保存接收到的数据
        Map<String, Object> map = new HashMap<String, Object>();

        // 接收数据
        try {

            // 创建一个磁盘文件项工厂对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            // 创建一个核心解析类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            // 解析request请求，返回的是List集合，List集合中存放的是FileItem对象
            List<FileItem> list = servletFileUpload.parseRequest(request);

//            // 定义一个 tasteList，用于存放菜品的味道
//            List<String> tasteList = new ArrayList<>();

            String url = null;

            for (FileItem fileItem : list) {
                // 如果 fileItem 是 formField
                if (fileItem.isFormField()) {

                    // 获得 formField 的 name 属性的值
                    String name = fileItem.getFieldName();

                    // 获得 formField 的 值
                    String value = fileItem.getString("UTF-8");

                    System.out.println(name + "    " + value);

                    // 将数据存入 map 中
                    map.put(name, value);

//                    // 如果接收的是 复选框的数据
//                    if ("taste".equals(name)) {
//                        String tasteValue = fileItem.getString("UTF-8");
//
//                        // 接收到一个值，将这个值存入到 tasteValue 中
//                        tasteList.add(tasteValue);
//
//                        // 除去 List.toString() 返回字符串 两边的 "[" 和 "]"
//                        tasteValue = tasteList.toString().substring(1, tasteList.toString().length() - 1);
//
//                        System.out.println(name + "     " + tasteValue);
//
//                        // 将爱好的数据存入到 map 中
//                        map.put(name, tasteValue);
//
//                    } else {
//                        // 将数据存入到 map 中:
//                        map.put(name, value);
//                    }
                } else {
                    // 文件上传项
                    // 文件上传功能
                    // 获得文件上传的名称
                    String fileName = fileItem.getName();
                    if (fileName != null && !"".equals(fileName)) {

                        // 通过工具类获得唯一文件名:
                        String uuidFileName = UploadUtils.getUUIDFileName(fileName);

                        // 获得文件上传的数据：
                        InputStream is = fileItem.getInputStream();

                        // 将输入流对接到输出流就可以了:
                        url = uploadDirectory + "\\" + uuidFileName;
                        OutputStream os = new FileOutputStream(url);
                        int len = 0;
                        byte[] b = new byte[1024];
                        while ((len = is.read(b)) != -1) {
                            os.write(b, 0, len);
                        }
                        is.close();
                        os.close();

                        map.put("foodImage", url);

                        System.out.println(url);

                    }
                }
            }

            System.out.println(map);

            // 封装数据到 Food 当中:
            Food food = new Food();
            food.setFoodID((String)map.get("id"));
            food.setFoodName((String)map.get("foodName"));
            food.setFoodTaste((String)map.get("taste"));
            food.setPicPath(url);
            food.setFoodPrice((String)map.get("price"));
            food.setFoodDesc((String)map.get("description"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 生成唯一的文件名:
     */
    private static String getUUIDFileName(String fileName) {
        // 将文件名的前面部分进行截取：xx.jpg   --->   .jpg
        int idx = fileName.lastIndexOf(".");
        String extention = fileName.substring(idx);
        String uuidFileName = UUID.randomUUID().toString().replace("-", "") + extention;
        return uuidFileName;
    }
}
