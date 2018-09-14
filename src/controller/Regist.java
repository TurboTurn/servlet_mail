package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.vo.User;
import util.Encription;

/**
 * Servlet implementation class Regist
 */
@WebServlet(name = "regist", urlPatterns = { "/regist" })
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
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
		request.setCharacterEncoding("gb2312");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String verifypass=request.getParameter("verifypass");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		if( !password.equals(verifypass) ){
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('您两次输入的密码不一样，请重新输入');");
			out.println("window.location='regist.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}else{
			User regUser=new User(username,Encription.md5(password),nickname,sex,birth);
			UserDao dao=new UserDao();
			if(dao.addUser(regUser)>0){
				response.setContentType("text/html;charset=gb2312");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('恭喜注册成功！快来登录吧！');");
				out.println("window.location='login.jsp';");
				out.println("</script>");
				out.flush();
				out.close();
			}else{
				response.setContentType("text/html;charset=gb2312");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('注册失败！');");
				out.println("window.location='regist.jsp';");
				out.println("</script>");
				out.flush();
				out.close();
			}
		}
	}

}
