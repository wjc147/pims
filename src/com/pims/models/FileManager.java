package com.pims.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FileManager {

	private List<UserFile> files;
	private UserFile file;
	
	private Connection conn; //���ݿ���ر���
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;

	public void add(UserFile file){
		
		String sql = "insert into file (name, path) values(?,?)";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);//Ԥ����
			
			ps.setString(1, file.getName());
			ps.setString(2, file.getPath());
			
			ps.executeUpdate();//ִ��
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<UserFile> findAll(){
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			//ִ�в�ѯ
			rs=stmt.executeQuery("select * from file");
			
			//����һ���б����files�������е��ļ�
			files = new ArrayList<UserFile>();
			
			while(rs.next()){
				//ÿ��һ�����ݾ�������һ��UserFile
				file = new UserFile();
				//��ÿһ�����ݵ�ֵȡ��������ղ�������files��
				file.setId(rs.getInt("id"));
				file.setName(rs.getString("name"));
				file.setPath(rs.getString("path"));
				files.add(file);
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�������е��ļ�
		return files;

	}
	
	public FileManager() {
	}

	/**
	 * �������������ݿ�
	 * @return ���ӵ������ݿ���Դ
	 */
	public Connection getConnection(){
		String driverName = "com.mysql.jdbc.Driver";
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
