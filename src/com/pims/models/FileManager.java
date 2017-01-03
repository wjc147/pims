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
	
	private Connection conn; //数据库相关变量
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;

	public void add(UserFile file){
		
		String sql = "insert into file (name, path) values(?,?)";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);//预处理
			
			ps.setString(1, file.getName());
			ps.setString(2, file.getPath());
			
			ps.executeUpdate();//执行
			
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
			//执行查询
			rs=stmt.executeQuery("select * from file");
			
			//声明一个列表变量files来放所有的文件
			files = new ArrayList<UserFile>();
			
			while(rs.next()){
				//每读一条数据就新生成一个UserFile
				file = new UserFile();
				//将每一条数据的值取出，放入刚才声明的files。
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
		//返回所有的文件
		return files;

	}
	
	public FileManager() {
	}

	/**
	 * 帮我们连接数据库
	 * @return 连接到的数据库资源
	 */
	public Connection getConnection(){
		String driverName = "com.mysql.jdbc.Driver";
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
