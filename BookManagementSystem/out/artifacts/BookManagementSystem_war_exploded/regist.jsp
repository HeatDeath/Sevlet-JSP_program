<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<script src="jquery-3.2.1.js"></script>
	<script type="text/javascript">
		function check_password() {
			if ($("#password").val() != $("#checkPWD").val()){
			    alert("请保证两次输入密码的一致性！");
			}
        }

        function check_phone() {
            var phone_reg =  /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if (!phone_reg.test($("#phone").val())){
                alert("请输入正确的手机号！")
            }
        }

        function check_email() {
            var email_reg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
            if (!email_reg.test($("#email").val())){
                alert("请输入正确的email！")
			}
        }


        
	</script>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>注册界面</title>
</head>
<body>
	<center>
		<h1>用户注册</h1>
		<form action="<%=basePath%>/RegistServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="密码长度为6-12位的纯数字"  id="password"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="checkPWD" placeholder="密码长度为6-12位的纯数字" id="checkPWD" onchange="check_password()"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" placeholder="请输入正确的手机号码格式" id="phone" onchange="check_phone()"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="email" name="email" placeholder="请输入正确邮箱格式" id="email" onchange="check_email()" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="注册">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>