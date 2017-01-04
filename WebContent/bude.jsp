<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
fot(int i=login.size()-1;i>=0;i--){
LoginBean nn=(LoginBean)Login.get(i);
userName=nn.getUserName();
}
}
String sqll="select * from friends where name='"+name+"'and
userName='"+userName+"'";
rs.last();
int k=rs.getRow();
if(k<1){
wrong2();
response.sendRedirect("http://localhost:8084/PIMS/friendManager/deleteFriend.jsp");
}else{
String sql2="delete from friends where name='"+name+"'and userName='"+userName+"'";
stmt.executeUpdate(sq12);
String sql13="select * from friends where userName='"+userName+"'";
rs=stmt.executeQuery(sq13);
rs.last();
int list=rs.getRow();
rs.beforFirst();
if(list<1){
ArrayList friendslist=null;
session.setAttribute("friendslist",friendslist);
}else{
ArrayList friendslist=null;
friendslist=new ArrayList();
while(rs.next()){
lookFriendBean ff=new LookFriendBean();
ff.setName(rs.getString("Name"));
ff.setPhone(rs.getString("Phone"));
ff.setEmail(rs.getString("Email"));
ff.setWorkPlace(rs.getString("WorkPlac"));
ff.setPlace(rs.getString("Place"));
ff.setQQ(rs.getString("QQ"));
friendslist.add(ff);
session.setAttribute("friendslist",friendslist);
}
}
}
rs.close();
stmt.close();
con.close();
response.sendRedirect("http://localhost:8084/PIMS/friendManager/lookFriend.jsp");
}catch(Exception e){
e.printStackTrace();
}
}
}
protected void dopost(HttpServletRequest requset,HttpServletResponse response)throws ServletException,IOException{
   doGet(request, response);
}
}
</body>
</html>