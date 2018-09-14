package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDao;
import model.vo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login.do", urlPatterns = { "/login.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.取参数
				String userName=request.getParameter("userName");
				String password=request.getParameter("password");
				String code=request.getParameter("code");
				
				HttpSession session=request.getSession();
				String saveCode=(String)session.getAttribute("code");
				if(!code.equals(saveCode)){
					response.setContentType("text/html;charset=gb2312");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('您输入的验证码不正确，请重新输入');");
					out.println("window.location='login.jsp';");
					out.println("</script>");
					out.flush();
					out.close();
				}else{
					//2.调用相应的模型实现业务逻辑处理
					UserDao dao=new UserDao();
					User user=dao.checkLogin(userName, password);
					
					//3.根据处理结果给出不同的客户端响应
					if(user!=null){//成功登陆
						session.setAttribute("User", user);
						response.sendRedirect("index.jsp");
					}
					else{ //登陆失败
						response.setContentType("text/html;charset=gb2312");
						PrintWriter out = response.getWriter();
						out.println("<script>");
						out.println("alert('账户或密码错误！');");
						out.println("window.location='login.jsp';");
						out.println("</script>");
						out.flush();
						out.close();
						//response.sendRedirect("error.jsp");
					}		
				}
	}

}
