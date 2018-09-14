package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Contact;
import util.DBManager;

public class ContactDao {
	public ArrayList<Contact> queryContact(String username){//查询通讯录
		ArrayList<Contact> list=new ArrayList<>();
		DBManager db=new DBManager();
		String sql="select * from contact where username='"+ username +"'";
		try {
			ResultSet rs=db.executeQuery(sql);
			while(rs.next()){
				Contact cont=new Contact();
				cont.setId(Integer.toString(rs.getInt("id")));
				cont.setUsername(rs.getString("username"));
				cont.setContid(rs.getString("contid"));
				cont.setContname(rs.getString("contname"));
				cont.setContphone(rs.getString("contphone"));
				list.add(cont);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return list;
	}
	public Contact queryCont(String id){//根据id查询一条联系人
		Contact cont=new Contact();
		String sql="select * from contact where id="+id;
		DBManager db=new DBManager();
		try {
			ResultSet rs=db.executeQuery(sql);
			while(rs.next()){
				cont.setId(Integer.toString(rs.getInt("id")));
				cont.setUsername(rs.getString("username"));
				cont.setContid(rs.getString("contid"));
				cont.setContname(rs.getString("contname"));
				cont.setContphone(rs.getString("contphone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cont;
	}
	public int addContact(Contact cont){//添加联系人
		int count=0;
		String params[]={cont.getUsername(),cont.getContname(),
				cont.getContid(),cont.getContphone()};
		String sql="insert into contact(username,contname,contid,contphone) values(?,?,?,?)";
		DBManager db=new DBManager();
			count=db.executeUpdate(sql, params);
			db.close();
		
		
		return count;
	}
	public int updateContact(Contact cont,String id){
		int count=0;
		DBManager db=new DBManager();
		String sql="update contact set contname=?,contid=?,contphone=? where id=?";
		String params[]={cont.getContname(),cont.getContid(),
		cont.getContphone(),id};
		count=db.executeUpdate(sql, params);
		db.close();
		return count;
	}
	public int deleteContact(String id){//删除一位联系人
		int count=0;
		String sql="delete from contact where id="+id;
		DBManager db=new DBManager();
		count=db.executeUpdate(sql);
		db.close();
		return count;
	}
}
