<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
	request.getServerPort() + path + "/";
//	Map<String, String> user_message = (Map<String, String>) application.getAttribute("user_message");
//	String username = user_message.get("username");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<center>
		<h1>
			图书后台管理系统<span style="font-size:12px">您好，</span>${applicationScope.user_message.username}
		</h1>
	</center>
</body>
</html>
