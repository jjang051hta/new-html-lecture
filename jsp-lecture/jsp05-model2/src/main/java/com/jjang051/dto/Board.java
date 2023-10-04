package com.jjang051.dto;

public class Board {
	private int no;
	private String id;
	private String password;
	private String name;
	private String title;
	private String content;
	private String regDate;
	private int hit;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Board() {
		super();
	}
	public Board(int no, String id, String password, String name, String title, String content, String regDate,
			int hit) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + ", hit=" + hit + "]";
	}
	
	
}





