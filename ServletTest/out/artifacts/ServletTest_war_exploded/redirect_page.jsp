<%--
  Created by IntelliJ IDEA.
  User: rHotD
  Date: 2017/10/17
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重定向页面</title>
</head>
<body>

<%
    Integer result =(Integer) application.getAttribute("result");
%>

<h1 style="color: red"> 我是重定向页面 </h1>

<h1 style="color: red">计算结果是： <%= result %> </h1>

</body>
</html>
