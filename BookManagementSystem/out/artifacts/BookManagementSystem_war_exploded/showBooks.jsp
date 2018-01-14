<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>图书查询</title>
	<script src="jquery-3.2.1.js"></script>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<p>
			图书ID：<input type="text" name="bookID">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="catgoryName">
			<input type="button" value="查询" id="search">
		</p>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">
				<c:forEach items="${applicationScope.bookDb}" var="book_message">
						<tr>
							<td>${book_message.id}</td>
							<td>${book_message.bookName}</td>
							<td>${book_message.catgoryName}</td>
							<td>${book_message.price}</td>
							<td>${book_message.description}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
	
</body>
<script type="text/javascript">
    $("#search").click(function (){
        //单击查询按钮的时候触发ajax事件
        $.ajax({
            url:"<%=basePath%>/SelectServlet",
            type:"post",
            data:{
                bookID:$("input[name=bookID]").val(),
                bookName:$("input[name=bookName]").val(),
                catgoryName:$("input[name=catgoryName]").val()
            },
            dataType:"json",
            success:function(result){
                var res = [];
                $.each(result.conditionBook, function (i, item) {
                    res.push('<tr>');
                    res.push('<td align="center" >' + item.id + '</td>');
                    res.push('<td align="center" >' + item.bookName + '</td>');
                    res.push('<td align="center" >' + item.catgoryName + '</td>');
                    res.push('<td align="center" >' + item.price + '</td>');
                    res.push('<td align="center" >' + item.description + '</td>');
                    res.push('</tr>');
                });
                $("#cont").empty().html(res.join(""));
            }
        })
    });
</script>
</html>