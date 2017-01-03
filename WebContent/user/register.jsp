<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
</head>
<body>
<form action="<c:url value='/register'/>" method="post">
	<p>用户名: <input name="username"/></p>
	<p>密码: <input name="password" /></p>
	<button>提交</button>
</form>

</body>
</html>