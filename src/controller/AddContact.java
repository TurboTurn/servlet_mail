package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ContactDao;
import model.vo.Contact;
import model.vo.User;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
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
		String contname=request.getParameter("contname");
		String contid=request.getParameter("contid");
		String contphone=request.getParameter("contphone");
		Contact cont=new Contact(username,contname,contid,contphone);
		ContactDao dao=new ContactDao();
		int count=dao.addContact(cont);
		if(count>0){
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('添加联系人成功！');");
			out.println("window.location='contact.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}else{
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('添加失败！');");
			out.println("window.location='contact.jsp';");
			out.println("</script>");
			out.flush();
			out.close();
		}
		
	}

}
