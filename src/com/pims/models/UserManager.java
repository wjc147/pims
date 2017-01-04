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
	private Connection con; //数据库相关变量
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
			ps = con.prepareStatement(sql);//预处理
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getPhone());
			ps.executeUpdate();//执行
			
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
	 * 从Servlet传递User过来，从数据库查询账号密码是否相匹配。
	 * @param user
	 * @return 匹配返回true否则返回false
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
	 * 帮我们连接数据库
	 * @return 连接到的数据库资源
	 */
	public Connection getConnection(){
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=pims";
		String user = "sa";
		String password = "1234";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, user, password);//将连接好的对象connection返回，供调用。
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
