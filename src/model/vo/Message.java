package model.vo;

public class Message {
	private String id;
	private String sender;
	private String receiver;
	private String subject;
	private String text;
	private String time;
	private String read;
	public Message(){
		
	}
	public Message(String sender, String receiver, String subject, String text, String time, String read) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.text = text;
		this.time = time;
		this.read = read;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	
}
