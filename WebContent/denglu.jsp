<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——登录界面</title>
     <style >
     <!--
         p1{font-family:华文行楷;font-size:20pt;color:bule;}
         h1{font-family:华文行楷;font-size:40pt;color:red;}
         -->
     </style>
</head>
<body bgcolor="#99aaee">
     <table border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr bgcolor="99aaee">
           <td align="center">
              <img src="image/1.jpg" alt="校训" width="250" heigh="300">
             </td>
             <td colspan="1" align="left">
              <h2>个人信息管理系统</h2>
             </td>
        </tr>
         <tr>
         <td colspan="2">
           <hr align="center" width="100%" size="20" color="green">
         </td>
         </tr>
         <tr>
           <td width="30%" align="center">
              <img src="" alt="风景" height="360"></td>
              <td align="center" bgcolor="#99aadd" width="70%">
                <form action="http://localhost:8084/PIMS.LoginServlet" method="post">
                  <table border="2" cellspacing="0" cellpadding="0" bgcolor="#95BDFF" width="350">
                   <tr align="center">
                     <td align="center" height="130">
                                                                           输入用户姓名:<input type="text" name="userName" size="16"/><br>
                                 <p></p>
                                                                           输入用户密码:<input type="text" name="password" size="18"/>
                       </td>
                       </tr>
                       <tr>
                         <td>
                            <input type="submit" value="确定" size="12">&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="reset" value="清除" size="12">
                         </td>
                       </tr>
                       <tr>
                         <td>
                           <p align="center">
                            <a href="http://localhost:8084/PIMS/register/register.jsp">注册</a>
                            </p>
                         </td>
                      </tr>    
                  </table>
                 </form> 
        </td>
        </tr>
     
     </table>
    
</body>
