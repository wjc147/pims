<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统————删除联系人</title>
</head>

<body bgcolor="#cccfff">
   <hr noshade>
   <div align="center">
   <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
   <tr>
    <td width="20%">
    <a href="http://localhost:8084/PIMS/friendManage/addFriend.jsp">增加联系人</a>
    </td>
    <td width="20%">
   <a href="http://localhost:8084/PIMS/LookFriendServlet">查看通讯录</a>
    </td>
     <td width="20%">
     <a href="http://localhost:8084/PIMS/friendManger/updateFriendMessage"> 修改联系人</a>
   
    </td>
    <td width="20%">
   删除联系人
    </td>
    </tr>
   </table>
   </div>
   <hr noshade>
   <br><br>
   <form action="http://localhost:8084/PIMS/DeletFeiendServlet" method="post">
   <table border="2" cellspacing="0" cellpadding="0" width="40%" align="center">
   <tr align="center">
   <td align="center" height="130">
   <p>请输入要删除的姓名:<input type="text" name="name"><br></p>
   </td>
   </tr>
   <tr>
    <td  align="center">
		   <input type="submit" value="确定" size="12">
		   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		   <input type="reset" value="清除" size="12">
		   
		   </td>
		   </tr>
   </table>
   </form>
</body>
</html>