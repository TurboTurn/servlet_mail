package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MessageDao;

/**
 * Servlet implementation class DeleteMail
 */
@WebServlet("/DeleteMail")
public class DeleteMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		String params[]= ids.split(",");
		int count=0;
		MessageDao dao=new MessageDao();
		for(int i=0;i<params.length;i++){
			count+=dao.deleteMail(params[i]);
		}
		if(count > 0){
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('³É¹¦É¾³ý"+count+"·âÓÊ¼þ£¡"+"');");
			out.println("window.location='receivemail.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}else {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('É¾³ýÓÊ¼þÊ§°Ü£¡"+"');");
			out.println("window.location='receivemail.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
