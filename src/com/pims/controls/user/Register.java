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
 * ע���õ�Servlet
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
    }

	/**
	 * �����û�ע�ᴫ�ݵı�post������
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����Ӧ�û���һ�Ѳ�����Ҫ���ݡ�ʡ��
		
		User user = new User(username, password);//�����µ��û�
		UserManager manager = new UserManager();//�����û������ࡣ
		
		manager.add(user);//�����û������࣬�����û���
		
		String info = "�û���ӳɹ�!";
		request.setAttribute("info", info);
		
		RequestDispatcher dis = request.getRequestDispatcher("/user/success.jsp");
		dis.forward(request, response);
	}

}
