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
	//˽�г�Ա�����Ķ���
	private Connection con=null;
	//private PreparedStatement ps=null;
	private Statement stm=null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	// ���췽����ʵ�ּ���jdbc�����࣬���������ݿ������
	public DBManager() {
		// 1.����jdbc������
//		String className = "com.mysql.jdbc.Driver"; // �������������·��
//		try {
//			Class.forName(className);
//			// 2.���������ݿ������
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
	
	//ʵ�ֲ�ѯ���sql����ִ�й���
	/*
	public ResultSet executeQuery(String sql,String params[]) throws SQLException{
		ps = con.prepareStatement(sql);
		// ִ�����ǰ����Բ������и�ֵ,�����±��1��ʼ
		for(int i=1;i<params.length+1;i++){
			ps.setString(i, params[i-1]);	
		}
		
		  //ִ����䣬 ����ǲ�ѯ���,�����executeQuery����������resultset���� ����Ƿǲ�ѯ�����ӡ��޸ġ�ɾ���ȣ���䣬
		 //�����executeUpdate����������һ������
		 
		rs = ps.executeQuery();
		return rs;
	}
*/
	
	
	//ʵ�ַǲ�ѯ���sql����ִ�й���
	public int executeUpdate(String sql, String params[]) {
		int count=0;
		try {
			ps = con.prepareStatement(sql);
			// ִ�����ǰ����Բ������и�ֵ,�����±��1��ʼ
			for (int i = 1; i < params.length + 1; i++) {
				ps.setString(i, params[i - 1]);
			}
			/*
			 * ִ����䣬 ����ǲ�ѯ���,�����executeQuery����������resultset���� ����Ƿǲ�ѯ�����ӡ��޸ġ�ɾ���ȣ���䣬
			 * �����executeUpdate����������һ������
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
	
	//��Դ���ͷ�
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
