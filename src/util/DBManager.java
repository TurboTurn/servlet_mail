package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DBManager {
	private static final String DSNAME="java:comp/env/jdbc/mail";
	//私有成员变量的定义
	private Connection con=null;
	//private PreparedStatement ps=null;
	private Statement stm=null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	// 构造方法，实现加载jdbc驱动类，建立与数据库的连接
	public DBManager() {
		// 1.加载jdbc驱动类
//		String className = "com.mysql.jdbc.Driver"; // 驱动类的完整包路径
//		try {
//			Class.forName(className);
//			// 2.建立与数据库的连接
//			String conUrl = "jdbc:mysql://localhost:3306/student"
//					+ "?useUnicode=true&characterEncoding=utf-8";
//			String dbUser = "root";
//			String dbPassword = "admin";
//			con = DriverManager
//					.getConnection(conUrl, dbUser, dbPassword);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup(DSNAME);
			this.con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	public Connection getConnection(){
		return this.con;
	}
	public ResultSet executeQuery(String sql) throws SQLException{
		stm=con.createStatement();
		rs=stm.executeQuery(sql);
		return rs;
	}
	
	//实现查询类的sql语句的执行功能
	/*
	public ResultSet executeQuery(String sql,String params[]) throws SQLException{
		ps = con.prepareStatement(sql);
		// 执行语句前必须对参数进行赋值,参数下标从1开始
		for(int i=1;i<params.length+1;i++){
			ps.setString(i, params[i-1]);	
		}
		
		  //执行语句， 如果是查询语句,则调用executeQuery方法，返回resultset对象 如果是非查询（增加、修改、删除等）语句，
		 //则调用executeUpdate方法，返回一个整形
		 
		rs = ps.executeQuery();
		return rs;
	}
*/
	
	
	//实现非查询类的sql语句的执行功能
	public int executeUpdate(String sql, String params[]) {
		int count=0;
		try {
			ps = con.prepareStatement(sql);
			// 执行语句前必须对参数进行赋值,参数下标从1开始
			for (int i = 1; i < params.length + 1; i++) {
				ps.setString(i, params[i - 1]);
			}
			/*
			 * 执行语句， 如果是查询语句,则调用executeQuery方法，返回resultset对象 如果是非查询（增加、修改、删除等）语句，
			 * 则调用executeUpdate方法，返回一个整形
			 */
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	
	public int executeUpdate(String sql){
		int count=0;
		try {
			stm=con.createStatement();
			count = stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	//资源的释放
	public void close(){
		try {
			if (rs != null)
				rs.close();
			/*
			if (ps != null)
				ps.close();
			*/
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

}
