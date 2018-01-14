<%--
  Created by IntelliJ IDEA.
  User: rHotD
  Date: 2017/10/17
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转发页面</title>
</head>
<body>
<%
    Integer number_1 = Integer.valueOf(request.getParameter("number_1"));
    Integer number_2 = Integer.valueOf(request.getParameter("number_2"));
    Integer result = number_1 + number_2;
%>
<h1 style="color: red"> 我是转发页面 </h1>
<h1 style="color: red">计算结果是： <%= result%> </h1>
</body>
</html>
