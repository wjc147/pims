package com.pims.controls.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pims.models.User;
import com.pims.models.UserManager;

import sun.rmi.server.Dispatcher;

/**
 * 注册用的Servlet
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
    }

	/**
	 * 处理用户注册传递的表单post方法。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//以上应该还有一堆参数需要传递、省略
		
		User user = new User(username, password);//生成新的用户
		UserManager manager = new UserManager();//生成用户管理类。
		
		manager.add(user);//利用用户管理类，保存用户。
		
		String info = "用户添加成功!";
		request.setAttribute("info", info);
		
		RequestDispatcher dis = request.getRequestDispatcher("/user/success.jsp");
		dis.forward(request, response);
	}

}
