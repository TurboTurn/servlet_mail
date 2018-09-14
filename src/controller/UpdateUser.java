package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.dao.UserDao;
import model.vo.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		HttpSession session=request.getSession();
		String username=((User)session.getAttribute("User")).getUsername();
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		User user=new User(username,password,nickname,sex,birth);
		UserDao dao=new UserDao();
		int count=dao.updateUser(user);
		if(count>0){
			session.setAttribute("User", user);
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('修改资料成功！');");
			out.println("window.location='update.jsp';");
			out.println("window.parent.frames[ 'topFrame'].location.reload()");
			out.println("</script>");
			out.flush();
			out.close();
		}else{
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('修改失败！');");
			out.println("window.location='update.jsp';");
			out.println("window.parent.frames[ 'topFrame'].location.reload()");
			out.println("</script>");
			out.flush();
			out.close();
		}
		
	}

}
