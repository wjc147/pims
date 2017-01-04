package com.pims.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
	private User user;
	private Connection con; //���ݿ���ر���
	private Statement stmt;
	private ResultSet rs;
	private List<User> userinfo;
	private PreparedStatement ps;

	public UserManager() {
		// TODO Auto-generated constructor stub
	}

	public void addUser(User user){
		String sql = "insert into userManager (username, password,name,sex,phone) values(?,?,?,?,?)";
		con = getConnection();
		
		try {
			ps = con.prepareStatement(sql);//Ԥ����
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getPhone());
			ps.executeUpdate();//ִ��
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<User> findUserByUsername(String username){
		String sql="select * from userManager where username="+username;
		con=getConnection();
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			user=new User();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				userinfo=new ArrayList<User>();
				userinfo.add(user);
				return userinfo;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userinfo;
	}
	
	public void updateUser(User user){
		con=getConnection();
		String sql="update userManager set username=?,password=?,name=?,sex=?,age=?,phone=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getPhone());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��Servlet����User�����������ݿ��ѯ�˺������Ƿ���ƥ�䡣
	 * @param user
	 * @return ƥ�䷵��true���򷵻�false
	 */
	public Boolean authUser(User user){
		con=getConnection();
		String sql="select * from userManager where username=? and password=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeQuery();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * �������������ݿ�
	 * @return ���ӵ������ݿ���Դ
	 */
	public Connection getConnection(){
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pims";
		String user = "sa";
		String password = "1234";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, user, password);//�����ӺõĶ���connection���أ������á�
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
