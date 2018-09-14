package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBManager;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
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
		
		response.setContentType("text/html") ;
		DBManager dbCon=new DBManager();
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		PrintWriter out = response.getWriter() ;
		String userid = request.getParameter("userid") ;
		try{
			
			conn = dbCon.getConnection();
			String sql = "SELECT COUNT(username) FROM users WHERE username=?" ;
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setString(1,userid) ;
			rs = pstmt.executeQuery() ;
			if(rs.next()){
				if(rs.getInt(1)>0){	// 用户ID已经存在了
					out.print("true") ;
				} else {
					out.print("false") ;
				}
			}
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			try{
				dbCon.close() ;
			}catch(Exception e){}
		}
	}

}
