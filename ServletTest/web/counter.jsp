<%--
  Created by IntelliJ IDEA.
  User: rHotD
  Date: 2017/10/17
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+":"+
            "//"+request.getServerName()+":"
            +request.getServerPort()+"/"
            +request.getServletContext().getContextPath()+"/";
%>
<html>
<head>
    <title>计算器</title>
</head>
<body>
<form action="<%= basePath %>CounterServlet" method="post">
    <p>数字一：<input type="text" name="number_1"></p>
    <p>数字二：<input type="text" name="number_2"></p>
    <p>数据显示方式：<input type="text" name="display_method"></p>
    <p>
        <input type="submit" value="计算">
        <input type="reset" value="重置">
    </p>
</form>
</body>
</html>
