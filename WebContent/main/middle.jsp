<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>middle页面</title>
</head>
<body bgcolor="#CCCFFF">
     <%
           String userName=request.getParameter("userName");
     %>
        <table width="100%" align="right" bgcolor="blue">
          <tr height="10" bgcolor="gray" align="center">
             <td><a herf="http://localhost:8084/PIMS/LookMessageServlet? userName=<%=userName%>" target="main">个人信息管理</a></td>
              <td><a herf="http://localhost:8084/PIMS/LookFriendServlet target="main">通讯录管理</a></td>
              <td><a herf="http://localhost:8084/PIMS/LookDateServlet target="main">日程安排管理</a></td>
              <td><a herf="http://localhost:8084/PIMS/FileManager/fileUp.jsp target="main">个人文件管理</a></td>
              <td><a herf="http://localhost:8084/PIMS/login target="_top">退出主页面</a></td>
              <td>欢迎,<%=userName%>登录系统</td>
          </tr>
         
        </table>
</body>
</html>