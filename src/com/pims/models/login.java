package userManager.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManager.model.User;
import userManager.model.UserManager;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info=null;
		String username=request.getParameter("LogId");
		String password=request.getParameter("Logpassword");
		String validationCode=request.getParameter("validationCode");
		String validationCode1=request.getParameter("validationCode1");
		if(username.equals("")){
			info = "用户名不能为空!";
			request.setAttribute("info",info);
			RequestDispatcher dis = request.getRequestDispatcher("/userManager/zcdl.jsp");
			dis.forward(request, response);
		}else if(password.equals("")){
			info="密码不能为空!";
			request.setAttribute("info",info);
			RequestDispatcher dis = request.getRequestDispatcher("/userManager/zcdl.jsp");
			dis.forward(request, response);
		}else if(validationCode!=validationCode1){
			info="请输入正确的验证码！";
			request.setAttribute("info",info);
			RequestDispatcher dis = request.getRequestDispatcher("/userManager/zcdl.jsp");
			dis.forward(request, response);
		}else{
			UserManager dl=new UserManager();
			User user=new User(username,password);
			boolean res=dl.authUser(user);
			if(res){
				info = "登录成功！";
				request.setAttribute("info",info);
				request.setAttribute("username", username);
				RequestDispatcher dis = request.getRequestDispatcher("/main/index.jsp");
				dis.forward(request, response);
			}else{
				info="登录失败，请检测用户名及密码是否正确";
				request.setAttribute("info",info);
				RequestDispatcher dis = request.getRequestDispatcher("/userManager/zcdl.jsp");
				dis.forward(request, response);
			}
		}
		
	}
}
