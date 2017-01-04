<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统一查看个人信息</title>
</head>
<body bgcolor="CCCFFF">
    <hr noshade>
    <div align="center">
    <table border="0" cellspacing="0" cellpadding="0"width="100%"
    align="center">
    <tr>
    <td width="33%">
    <a href="http://localhot:8084/PIMS/
        lookMessage/updateMessage.jsp">修改个人信息</a>
        </td>
        <td width="33%">
        查看个人信息
        </td>
        <td width="33%">
        <a href="http://localhot:8084/PIMS/
        lookMessage/updatePassword.jsp">修改密码</a>
        </td>
        </tr>
        </table>
        </div>
        <hr noshade> 
        <br><br>
        <table border="2" cellspacing="0" cellpadding="0"bgcolor="#95BDFF"width="60%"
    align="center">
    <% 
    
           ArrayList wordlist=(ArrayList) session.getAttribute("wordlist");
         if(wordlist==null||wordlist.size()==0){
	       response.sendRedirect("http://localhost:8084/PIMS/main/bottom.jsp");
        }else{
	      for (int i=wordlist.size()-1;i>=1;i--){
		   lookMessageBean mm=(lookMessageBean)wordlist.get(i);
   %>
   <tr>
   <td height="30">用户姓名</td>
   <td><%=mm.getNmae()%></td>
   </tr>
    <tr>
   <td height="30">用户性别</td>
   <td><%=mm.getSex()%></td>
   </tr>
    <tr>
   <td height="30">出生日期</td>
   <td><%=mm.getBirth()%></td>
   </tr>
    <tr>
   <td height="30">用户电话</td>
   <td><%=mm.getPhone()%></td>
   </tr>
  <%
	   }
   }
  %>
</body>
</html>