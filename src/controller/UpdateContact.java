package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ContactDao;
import model.vo.Contact;

/**
 * Servlet implementation class UpdateContact
 */
@WebServlet("/UpdateContact")
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContact() {
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
		String username=request.getParameter("username");
		String newname=request.getParameter("newname");
		String newid=request.getParameter("newid");
		String newphone=request.getParameter("newphone");
		String id=request.getParameter("id");
		Contact cont=new Contact(username,newname,newid,newphone);
		//System.out.println(username+" "+contid+" "+newname+" "+newid+" "+newphone);
		ContactDao dao=new ContactDao();
		int count=dao.updateContact(cont, id);
		if(count>0){
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('修改联系人成功！');");
			out.println("window.location='contact.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}else{
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('修改联系人失败！');");
			out.println("window.location='contact.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

}
