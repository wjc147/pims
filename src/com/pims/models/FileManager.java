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
		
		String sql = "insert into fileManager (name, path) values(?,?)";
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
			rs=stmt.executeQuery("select * from fileManager");
			
			//����һ���б����files�������е��ļ�
			files = new ArrayList<UserFile>();
			
			while(rs.next()){
				//ÿ��һ�����ݾ�������һ��UserFile
				file = new UserFile();
				//��ÿһ�����ݵ�ֵȡ��������ղ�������files��
				
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
