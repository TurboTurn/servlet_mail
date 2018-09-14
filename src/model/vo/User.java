package model.vo;

public class User {
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String username;
	private String password;
	private String nickname;
	private String sex;
	private String birth;
	public String getUsername() {
		return username;
	}
	public User(String username, String password, String nickname, String sex, String birth) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.sex = sex;
		this.birth = birth;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	

}
