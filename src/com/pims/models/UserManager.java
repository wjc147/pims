package com.pims.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
	private User user;
	
	private Connection conn; //���ݿ���ر���
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;

	public UserManager() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * ��Servlet����User�����������ݴ������ݿ�
	 * @param user
	 */
	public void add(User user){
		String sql = "insert into user (username, password) values(?,?)";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);//Ԥ����
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();//ִ��
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * ��Servlet�˵��ã����ݴ��ݹ�����id�����ض����û�
	 * @param id
	 * @return ָ�����û�
	 */
	public User findOne(Integer id){
		return null;
		
		
	}
	
	/**
	 * �����û��������û�
	 * @return �û�
	 */
	public User findByUsername(String username){
		return null;
	}
	
	/**
	 *  ��Servlet����user�����������ݿ��ڵ��û������޸ġ�
	 * @param user
	 */
	public void update(User user){
		
	}
	
	/**
	 * ��Servlet����User�����������ݿ��ѯ�˺������Ƿ���ƥ�䡣
	 * @param user
	 * @return ƥ�䷵��true���򷵻�false
	 */
	public Boolean authUser(User user){
		return false;
	}
	
	/**
	 * �������������ݿ�
	 * @return ���ӵ������ݿ���Դ
	 */
	public Connection getConnection(){
		String driverName = "com.sql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pims";
		String user = "root";
		String password = "";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, user, password);//�����ӺõĶ���connection���أ������á�
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
