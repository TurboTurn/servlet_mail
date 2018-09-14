package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ContactDao;

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContact() {
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
		ContactDao dao=new ContactDao();
		for(int i=0;i<params.length;i++){
			count+=dao.deleteContact(params[i]);
		}
		if(count > 0){
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('成功删除"+count+"位联系人！"+"');");
			out.println("window.location='contact.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}else {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('删除联系人失败！"+"');");
			out.println("window.location='contact.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
