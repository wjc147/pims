<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.pims.models.LookFriendBean" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统————修改通讯录</title>
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
    修改联系人
    </td>
    <td width="20%">
    <a href="http://localhost:8084/PIMS/friendManage/deleteFriend.jsp">删除联系人</a>
    </td>
    </tr>
   </table>
   </div>
   <hr noshade>
   <br><br>
   <form action="http://localhost:8084/PIMS/UpdateMessageServlet" method="post">
   <table border="2" cellspacing="0" cellpadding="0" width="60%" align="center">
   <% ArrayList friendslist2=(ArrayList) session.getAttribute("friendslist2");
   if(friendslist2==null||friendslist2.size()==0){
	   response.sendRedirect("http://localhost:8084/PIMS/friendManage/lookFriend.jsp");
   }else{
	   for (int i=friendslist2.size()-1;i>=0;i--){
		   LookFriendBean ff=(LookFriendBean)friendslist2.get(i);
		   %>
		   <tr>
		   <td height="30">用户姓名</td>
		   <td><%=ff.getName() %></td>
		   </tr>
		    <tr>
		   <td height="30">用户电话</td>
		   <td><input type="text" name="phone" value="<%=ff.getPhone() %>"></td>
		   </tr>
		    <tr>
		   <td height="30">邮箱地址</td>
		   <td><input type="text" name="email" value="<%=ff.getEmail() %>"></td>
		   </tr>
		    
		    <tr>
		   <td height="30">用户QQ</td>
		  <td><input type="text" name="QQ" value="<%=ff.getQQ() %>"></td>
		   </tr>
		   <tr>
		   <td colspan="2" align="center">
		   <input type="submit" value="确定" size="12">
		   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		   <input type="reset" value="清除" size="12">
		   
		   </td>
		   </tr>
		   <% 
	   }
   }
   %>
   </table>
   </form>
</body>
</html>