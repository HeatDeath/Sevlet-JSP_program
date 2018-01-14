<%--
  Created by IntelliJ IDEA.
  User: rHotD
  Date: 2017/10/18
  Time: 17:27
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
    <title>菜品查询选项页面</title>
    <style type="text/css">

    </style>
</head>
<body>
<center>
    <p><a href="<%=basePath%>/ShowAllServlet">查询所有菜品信息</a></p>
    <p><a href="selectFoodByName.jsp">菜名查询</a></p>
</center>
</body>
</html>
