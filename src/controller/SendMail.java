package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MessageDao;
import model.vo.Message;
import model.vo.User;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("doget: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//request.setCharacterEncoding("gb2312");
		
		HttpSession session=request.getSession();
		String sender=((User)session.getAttribute("User")).getUsername();
		String receiver=request.getParameter("receiver");
		String subject=request.getParameter("subject");
		String text=request.getParameter("text");
		String read="0";
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		Message msg=new Message(sender,receiver,subject,text,time,read);
		MessageDao dao=new MessageDao();
		if(dao.send(msg)>0){
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('发送成功！');");
			out.println("window.location='sendmail.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}else{
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('发送失败！');");
			out.println("window.location='sendmail.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		};
	}

}
