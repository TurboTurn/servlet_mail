package model.vo;

public class Contact {
	private String id;
	private String username;
	private String contname;
	private String contid;
	private String contphone;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String username, String contname, String contid, String contphone) {
		super();
		this.username = username;
		this.contname = contname;
		this.contid = contid;
		this.contphone = contphone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContname() {
		return contname;
	}
	public void setContname(String contname) {
		this.contname = contname;
	}
	public String getContid() {
		return contid;
	}
	public void setContid(String contid) {
		this.contid = contid;
	}
	public String getContphone() {
		return contphone;
	}
	public void setContphone(String contphone) {
		this.contphone = contphone;
	}
	
}
