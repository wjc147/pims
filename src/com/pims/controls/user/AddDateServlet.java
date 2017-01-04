package com.pims.controls.user;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.security.sasl.SaslException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import loginRegister.LoginBean;


public class AddDateServlet extends HttpServlet {

public void wrong1(){
	String msg="请把日期填写完整，添加失败！";
	int type=JOptionPane.YES_NO_CANCEL_OPTION;
	String title="信息提示";
	JOptionPane.showMessageDialog(null,msg,title,type);
}
	public void wrong2(){
		String msg="请确认日期填写正确，添加失败！";
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null,msg,title,type);
	}
		public void wrong3(){
			String msg="请填写日程内容，添加失败！";
			int type=JOptionPane.YES_NO_CANCEL_OPTION;
			String title="信息提示";
			JOptionPane.showMessageDialog(null,msg,title,type);
	
}
		public void wrong4(){
			String msg="该日程已有计划，添加失败！";
			int type=JOptionPane.YES_NO_CANCEL_OPTION;
			String title="信息提示";
			JOptionPane.showMessageDialog(null,msg,title,type);
	
}
		public void right(){
			String msg="填写信息合格，添加成功！";
			int type=JOptionPane.YES_NO_CANCEL_OPTION;
			String title="信息提示";
			JOptionPane.showMessageDialog(null,msg,title,type);
	
}
	protected void doget(HttpServletRequest requset, HttpServletResponse response)
			throws SaslException,IOException{
		String year=new
		String (requset.getParameter("year").getBytes("ISO-8859-1"),"utf-8");
		String month=new
				String (requset.getParameter("month").getBytes("ISO-8859-1"),"utf-8");
		String day=new
				String (requset.getParameter("day").getBytes("ISO-8859-1"),"utf-8");
		String thing=new
				String (requset.getParameter("thing").getBytes("ISO-8859-1"),"utf-8");
		String date="20"+year+"-"+month+"-"+year;
		if(year.length()!=2||month.length()==0||day.length()==0){
			wrong1();
			response.sendRedirect("http://locahost:8080/PIMS/dateManager/addDate.jsp");
		}else if(year.length()!=2||Integer.parseInt(year)<11||Integer.parseInt(month)<1||Integer.parseInt(year)<12
				||Integer.parseInt(day)<1||Integer.parseInt(day)>31){
			wrong2();
			response.sendRedirect("http://locahost:8080/PIMS/dateManager/addDate.jsp");
		}else if(thing.length()==0){
			wrong3();
			response.sendRedirect("http://locahost:8080/PIMS/dateManager/addDate.jsp");
		}else{
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
					response.sendRedirect("http://locahost:8080/PIMS/login.jsp");
				}else{
					for(int i=login.size()-1;i>=0;i--){
						LoginBean nn=(LoginBean)login.get(i);
						userName=nn.getUserName();
					}
				}
				String sqll="select*from date where date='"+date+"'and userName='"+userName+"'";
				rs=stmt.executeQuery(sqll);
				rs.last();
				int k;
				k=rs.getRow();
				rs.beforeFirst();
				if(k>0){
					wrong4();
					response.sendRedirect("http://locahost:8080/PIMS/dateManager/addDate.jsp");	
				}else{
					String sql2="insert into date"+"(userName,date,thing)"+"values("+"'"+userName+"'"+"'"+"'"+date+"'"+","+"'"+thing+"'"+")";
							stmt.executeQuery(sql2);
							String sql13="select*from date where userName='"+userName+"'";
							rs=stmt.executeQuery(sql3);
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
					response.sendRedirect("http://locahost:8080/PIMS/dateManager/lookDate.jsp");	
					}catch(Exception e){
						e.printStackTrace();
					}
		        }
		 }
	protected void dopost(HttpServletRequest requset, HttpServletResponse response)
			throws SaslException,IOException{
		doget(requset,response);
	}


}
