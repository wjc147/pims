<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dateManager.LookDateBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统————查看日程</title>
</head>

<body bgcolor="#cccfff">
   <hr noshade>
   <div align="center">
   <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
   <tr>
    <td width="20%">
    <a href="http://localhost:8084/PIMS/dateManager/addDate.jsp">增加日程</a>
    <td width="20%">
    查看日程
    </td>
    <td width="20%">
    <a href="http://localhost:8084/PIMS/dateManager/updateDate.jsp">修改日程</a>
    </td>
    <td width="20%">
    <a href="http://localhost:8084/PIMS/dateManager/deletDate.jsp">删除日程</a>
    </td>
    </tr>
   </table>
   </div>
 <hr noshade>
   <br><br>
   <form action="http://localhost:8084/PIMS/DeletFeiendServlet" method="post">
   <table border="5" cellspacing="0" cellpadding="0" width="60%" align="center">
   <tr>
   <th width="40%">日程时间</th>
   <th width="60%">日程内容</th>
   </tr>
   <% ArrayList datelist=(ArrayList) session.getAttribute("datelist");
   if(datelist==null||datelist.size()==0){
	  %>
	  <div align="center">
	  <h1>您还没有任何日程安排！</h1>
	  </div>
	  <% 
   }else{
	   for (int i=datelist.size()-1;i>=1;i--){
		   lookDateBean dd=(lookDateBean)datelist.get(i);
		   %>
		   <tr>
		   <td<%=dd.getDate() %>></td>
		   <td><%=dd.getThing() %></td>
		   </tr>
		   <% 
	   }
   }
		   %>
   </table>
   </form>
</body>
</html>