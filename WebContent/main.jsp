<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@page import="loginRegister.LoginBean" %>
   <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——主页面</title>
</head>
<%
    String userName=null;
     ArrayList login=(ArrayList)session.getAttribute("login");
      if(login==null || login.size()==0){
    	       response.sendRedirect("http://localhost:8084/PIMS/login.jsp");
      }else{
    	  for(int i=login.size()-1;i>=0;i--){
    		  LoginBean nn=(LoginBean)login.get(i);
    		  userName=nn.getUserName();
    	  }
      }
  
%>
         <frameset cols="20%,*" framespacing="0" border="no" frameborder="0">
           <frame src="../main/left.jsp" name="left" scrolling="no">
           <frameset rows="20%,10%,*">
             <frame src="../main/top.jsp" name="top" scrolling="no">
             <frame src="../main/middle.jsp?userName=<%=userName %>>" name="toop" scrolling="no">
             <frame src="../main/bottom.jsp" name="main">
           </frameset>
         </frameset>
</html>