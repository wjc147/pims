<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统一修改日程</title>
</head>
<body bgcolor="CCCFFF">
    <hr noshade>
    <div align="center">
    <table border="0" cellspacing="0" cellpadding="0"width="100%"
    align="center">
    <tr>
    <td width="20%">
    <a href="http://localhot:8084/PIMS/
        dateManager/addDate.jsp">增加日程</a>
     </td>
     <td width="20%">
     <a href="http://localhot:8084/PIMS/
        dateManager/lookDate.jsp">查看日程</a>
     </td>
     <td width="20%">
       修改日程
       </td>
       <td width="20%">
       <a href="http://localhot:8084/PIMS/
        dateManager/deleteDate.jsp">删除日程</a> 
        </td>
        </tr>
        </table>
        </div>
        <hr noshade> 
        <br><br>
        <form action="http://localhot:8084/PIMS/UpdateDateServlet"method="post">
        <table border="5" cellspacing="0" cellpadding="0"width="60%"
    align="center">
    <tr>
    <td height="30" width="50%" align="right">日程时间</td>
    <td width="50%">
    20<input type="text"size="1"name="year"value="">年
    <input type="text"size="1"name="month"value="">月
    <input type="text"size="1"name="day"value="">日
    </td>
    </tr>
    <tr>  
    <td height="30" width="50%" align="right">日程内容</td>
    <td width="50%">
    <input type="text"size="30"name="thing"/>
    </td>
    </tr>
    <tr>
    <td colspan="2"align="center">
    <input type="submit"value="确定"size="12">
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit"value="清除"size="12">
    </td>
    </tr>
    </table>
    </form>   
</body>
</html>