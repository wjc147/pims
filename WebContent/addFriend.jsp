<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——增加通讯录</title>
</head>
<body bgcolor="CCCFFF">
     <hr noshade>
     <div align="center">
       <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
         <tr>
           <td width="20%">增加联系人</td>
           <td width="20%">
            <a href="http://localhost:8084/PIMS/LookFriendServlet">查看通讯录</a>
           </td>
           <td width="20%">
            <a href="http://lpcalhost:8084/PIMS/friendManager/updateFriend.jsp">修改联系人</a>
           </td>
           <td width="20%">
            <a href="http://lpcalhost:8084/PIMS/friendManager/deleteFriend.jsp">删除联系人</a>
           </td>
         </tr>
       </table>
     </div>
       <hr noshade>
       <br><br>
       <from action="http://lpcalhost:8084/PIMS/AddFriendServlet" method="post">
        <table border="2" cellspacing="0" cellpadding="0" width="60%" align="center"> 
           <tr>
              <td>用户姓名</td>
              <td><input type="text" name="name"></td>
           </tr>
           <tr>
              <td>用户电话</td>
              <td><input type="text" name="phone"></td>
           </tr>
           <tr>
              <td>邮箱地址</td>
              <td><input type="text" name="email"></td>
           </tr>
           <tr>
              <td>工作单位</td>
              <td><input type="text" name="workplace"></td>
           </tr>
           <tr>
              <td>工作单位</td>
              <td>
                <select name="place" size="1">
                 <option value="北京">北京</option>
                 <option value="上海">上海</option>
                 <option value="天津">天津</option>
                 <option value="河北">河北</option>
                 <option value="河南">河南</option>
                 <option value="吉林">吉林</option>
                 <option value="黑龙江">黑龙江</option>
                 <option value="内蒙古">内蒙古</option>
                 <option value="山东">山东</option>
                </select>省(直辖市)
              </td>
              </tr>
              <tr>
                 <td>用户</td>
                 <td><input type="text" name="QQ"></td>
              </tr>
              <tr>
                  <td colspan="2" align="center">
                     <input type="submit" value="确定" size="12">
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="reset" value="清除" size="12">
              </td>
              </tr>
        </table>
       
       </from>
</body>
</html>