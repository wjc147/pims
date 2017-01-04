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
		conn = getConnection();
		String sql="update pims set username=?,password=?,name=?,sex=?,phone=? where id=?";
		try {
			ps = conn.prepareStatement(sql);//Ԥ����
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getPhone());
			
			ps.executeUpdate();//ִ��
			
			ps.close();
			conn.close();
			
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
		return false;
	}
	
	/**
	 * �������������ݿ�
	 * @return ���ӵ������ݿ���Դ
	 */
	public Connection getConnection(){
		String driverName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		String url = "jdbc:microsoft:sqlserver://localhost:1433/DatabaseName=pims";
		String user = "sa";
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
