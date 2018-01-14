<%@ page import="domain.FoodDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: rHotD
  Date: 2017/10/18
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品信息展示</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <h1>菜品查询</h1>
    <table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
        <thead>
        <tr>
            <th>菜品ID</th>
            <th>菜名</th>
            <th>口味</th>
            <th>菜品图片</th>
            <th>价格</th>
            <th>菜品描述</th>
        </tr>
        </thead>
        <tbody>

        <%
            String show_way = (String) request.getAttribute("show_way");
        %>

        <% if (show_way.equals("one")) { %>
        <%
            Map<String, Object> map = (Map<String, Object>) request.getAttribute("map");
            // 获得绝对路径最后一个\的位置
            int idx = ((String) map.get("foodImage")).lastIndexOf("\\");
            // 获得文件上传的唯一文件名：
            String fileName = ((String) map.get("foodImage")).substring(idx+1);
        %>
        <tr>
            <td><%= (String)map.get("id") %></td>
            <td><%= (String)map.get("foodName") %></td>
            <td><%= (String)map.get("taste") %></td>
            <%-- /WEB-INF/upload/26d1befc97074d538913be5825ac4220.png --%>
            <%-- /upload/97e064ab425549569a470cc5819215c8.png --%>
            <td><img src="/upload/<%= fileName %>"></td>
            <td><%= (String)map.get("price") %></td>
            <td><%= (String)map.get("description") %></td>
        </tr>
        <%
            } else {
        %>
            <%
                List<Map<String, Object>> list = FoodDaoImpl.getAllFood();
                for (Map<String, Object> map : list){
                    // 获得绝对路径最后一个\的位置
                    int idx = ((String) map.get("foodImage")).lastIndexOf("\\");
                    // 获得文件上传的唯一文件名：
                    String fileName = ((String) map.get("foodImage")).substring(idx+1);
            %>

            <tr>
                <td><%= (String)map.get("id") %></td>
                <td><%= (String)map.get("foodName") %></td>
                <td><%= (String)map.get("taste") %></td>
                <%-- /WEB-INF/upload/26d1befc97074d538913be5825ac4220.png --%>
                <%-- /upload/97e064ab425549569a470cc5819215c8.png --%>
                <td><img src="/upload/<%= fileName %>"></td>
                <td><%= (String)map.get("price") %></td>
                <td><%= (String)map.get("description") %></td>
            </tr>
            <%
                }
            %>
        <% } %>


        </tbody>
    </table>
</center>
</body>
</html>
