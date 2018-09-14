package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Message;
import util.DBManager;

public class MessageDao {

	public int send(Message msg) {//����һ���ʼ�
		int count=0;
		String params[]={msg.getSender(),msg.getReceiver(),
				msg.getSubject(),msg.getText(),
				msg.getTime(),msg.getRead()};
		DBManager db=new DBManager();
		String sql="insert into message(sender,receiver,subject,text,time,isread) values(?,?,?,?,?,?)";
			count=db.executeUpdate(sql,params);
			db.close();
		return count;
	}
	public ArrayList<Message> queryMail(String username){//��ѯ�ռ���
		ArrayList<Message> list=new ArrayList<Message>();
		DBManager db=new DBManager();
		String sql="select * from message where receiver='"+username+"'";
		try {
			ResultSet rs=db.executeQuery(sql);
			while(rs.next()){
				Message msg=new Message();
				msg.setId(Integer.toString(rs.getInt("id")));
				msg.setSender(rs.getString("sender"));
				msg.setReceiver(rs.getString("receiver"));
				msg.setSubject(rs.getString("subject"));
				msg.setText(rs.getString("text"));
				msg.setTime(rs.getString("time"));
				msg.setRead(rs.getString("isread"));
				list.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return list;
	}
	public ArrayList<Message> querySend(String username){//��ѯ�ѷ���
		ArrayList<Message> list=new ArrayList<Message>();
		DBManager db=new DBManager();
		String sql="select * from message where sender='"+username+"'";
		try {
			ResultSet rs=db.executeQuery(sql);
			while(rs.next()){
				Message msg=new Message();
				msg.setId(Integer.toString(rs.getInt("id")));
				msg.setSender(rs.getString("sender"));
				msg.setReceiver(rs.getString("receiver"));
				msg.setSubject(rs.getString("subject"));
				msg.setText(rs.getString("text"));
				msg.setTime(rs.getString("time"));
				msg.setRead(rs.getString("isread"));
				list.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return list;
	}
	public Message queryMailDetail(String id){//����id��ѯһ���ʼ�����
		Message msg=new Message();
		String sql="select * from message where id="+id;
		DBManager db=new DBManager();
		try {
			ResultSet rs=db.executeQuery(sql);
			while(rs.next()){
				msg.setId(Integer.toString(rs.getInt("id")));
				msg.setSender(rs.getString("sender"));
				msg.setReceiver(rs.getString("receiver"));
				msg.setSubject(rs.getString("subject"));
				msg.setText(rs.getString("text"));
				msg.setTime(rs.getString("time"));
				msg.setRead(rs.getString("isread"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return msg;
	}
	public int updateRead(String id){//�����ʼ�״̬Ϊ�Ѷ�
		int count=0;
		String sql="update message set isread=1 where id="+id;
		DBManager db=new DBManager();
		count =db.executeUpdate(sql);
		db.close();
		return count;
	}
	public int deleteMail(String id){//ɾ��һ���ʼ�
		int count=0;
		String sql="delete from message where id="+id;
		DBManager db=new DBManager();
		count=db.executeUpdate(sql);
		db.close();
		return count;
	}

}
