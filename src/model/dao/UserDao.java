package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.vo.User;
import util.DBManager;
import util.Encription;

public class UserDao {

	public User checkLogin(String userName,String password)
	{
		User user = null;
		//boolean ret=false;
		
		User userCondition=new User();
		userCondition.setUsername(userName);
		userCondition.setPassword(password);
		List<User> list=query(userCondition);
		if(list.size()>0){
			user=list.get(0);
			//System.out.println(user.getUsername());
			//ret=true;
		}
		return user;
	}

	public List<User> query(User user)
	{
		List<User> list=new ArrayList<User>();
	
		try{
			DBManager db=new DBManager();
			String sql="select * from users where  ";
			if(user.getUsername()!=null)
				sql+=" username ='"+user.getUsername()+"'";
			if(user.getPassword()!=null)
				sql+=" and password='"+Encription.md5(user.getPassword()) +"'";
//			if(user.getChrName()!=null)
//				sql+=" and chrName like'%"+user.getChrName()+"%'";
			ResultSet rs=db.executeQuery(sql);
			
			while(rs.next())
			{
				User userResult=new User();
				userResult.setUsername(rs.getString("username"));
				userResult.setSex(rs.getString("sex"));
				userResult.setBirth(rs.getString("birth"));
				userResult.setNickname(rs.getString("nickname"));
				
				list.add(userResult);
			}
			rs.close();
			db.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	public int addUser(User user){
		int count=0;
		String params[]={user.getUsername(),user.getPassword(),user.getNickname(),
				user.getSex(),user.getBirth()};
		
		DBManager db=new DBManager();
		String sql="insert into users values(?,?,?,?,?)";
		count=db.executeUpdate(sql, params);
		db.close();
		return count;
	}
	public int updateUser(User user){
		int count=0;
		String pw=Encription.md5(user.getPassword()) ;
		String sql="update users set password=?,nickname=?,sex=?,birth=? where username=?";
		String params[]={pw,user.getNickname(),user.getSex(),user.getBirth(),user.getUsername()};
		DBManager db=new DBManager();
		count=db.executeUpdate(sql, params);
		db.close();
		return count;
	}

}
