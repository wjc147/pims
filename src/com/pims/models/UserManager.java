package com.pims.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	private User user;
	
	private Connection conn; //数据库相关变量
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;

	public UserManager() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 从Servlet传递User过来，将数据存入数据库
	 * @param user
	 */
	public void add(User user){
		String sql = "insert into user (username, password) values(?,?)";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);//预处理
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();//执行
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * 在Servlet端调用，根据传递过来的id查找特定的用户
	 * @param id
	 * @return 指定的用户
	 */
	public User findOne(Integer id){
		return null;
		
		
	}
	
	/**
	 * 根据用户名查找用户
	 * @return 用户
	 */
	public User findByUsername(String username){
		return null;
	}
	
	/**
	 *  从Servlet传递user过来，将数据库内的用户内容修改。
	 * @param user
	 */
	public void update(User user){
		
	}
	
	/**
	 * 从Servlet传递User过来，从数据库查询账号密码是否相匹配。
	 * @param user
	 * @return 匹配返回true否则返回false
	 */
	public Boolean authUser(User user){
		return false;
	}
	
	/**
	 * 帮我们连接数据库
	 * @return 连接到的数据库资源
	 */
	public Connection getConnection(){
		String driverName = "com.sql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pims";
		String user = "root";
		String password = "";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, user, password);//将连接好的对象connection返回，供调用。
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
