<%--
  Created by IntelliJ IDEA.
  User: rHotD
  Date: 2017/10/18
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>菜品修改(根据菜品ID进行修改)</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <h1>根据菜品ID修改</h1>
    <form action="<%=basePath%>/FoodUpdateServlet" method="post" enctype="multipart/form-data">
        <table border="1px" width="400px" cellspacing="0px" cellpadding="0px">
            <tr>
                <td>修改ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>菜&nbsp;&nbsp;名</td>
                <td><input type="text" name="foodName"></td>
            </tr>
            <tr>
                <td>口&nbsp;&nbsp;味</td>
                <td><label>
                    <input type="radio" name="taste" value="香辣">香辣
                    <input type="radio" name="taste" value="微辣">微辣
                    <input type="radio" name="taste" value="麻辣">麻辣
                    <input type="radio" name="taste" value="不辣">不辣
                </label></td>
            </tr>
            <tr>
                <td>菜品图片</td>
                <td><input type="file" name="foodImage"></td>
            </tr>
            <tr>
                <td>价&nbsp;&nbsp;格</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>菜品描述</td>
                <td>
                    <textarea name="description"></textarea>
                </td>
            </tr>
            <tr   style="text-align:center;width:20px">
                <td colspan="2">
                    <input type="submit" value="修改">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
