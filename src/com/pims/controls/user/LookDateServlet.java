package com.pims.controls.user;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.security.sasl.SaslException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import loginRegister.LoginBean;


public class LookDateServlet extends HttpServlet {
	protected void doget(HttpServletRequest requset, HttpServletResponse response)
			throws SaslException,IOException{
			try{
				Connection con=null;
				Statement stmt=null;
				ResultSet rs=null;
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=gbk";
				con=DriverManager.getConnection(url, "root","admin" );
				stmt=con.createStatement();
				String userName="";
				HttpSession session=requset.getSession();
				ArrayList login=(ArrayList)session.getAttribute("login");
				if(login==null||login.size()==0){
					response.sentRedirect("http://locahost:8080/PIMS/login.jsp");
				}else{
					for(int i=login.size()-1;i>=0;i--){
						LoginBean nn=(LoginBean)login.get(i);
						userName=nn.getUserName();
					}
				}
				String sql="select*from date where userName='"+userName+"'";
				rs=stmt.executeQuery(sql);
							ArrayList datelist=null;
							datelist=new ArrayList();
							while(rs.next()){
								LookDateBean dd=new LookDateBean();
								dd.setDate(rs.getString("date"));
								dd.setThing(rs.getString("thing"));
								datelist.add(dd);
								session.setAttribute("datelist",datelist);
							}
				}
					rs.close();
					stmt.close();
					con.close();
					response.sentRedirect("http://locahost:8080/PIMS/dateManager/lookDate.jsp");	
					}catch(Exception e){
						e.printStackTrace();
					}
		        }
		 }
	protected void dopost(HttpServletRequest requset, HttpServletResponse response)
			throws SaslException,IOException{
		doget(requset,response);
	}
