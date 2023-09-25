package com.jjang051.dto;

public class Member {
	/*
	NO               number(5),
	id               varchar2(30) PRIMARY key,
	password         varchar2(100) NOT NULL,
	name             varchar2(50) NOT NULL,
	postcode         number(8),
	address          varchar2(100),
	addressdetail    varchar2(50),
	regdate          date
	*/
	private int no;
	private String id;
	private String password;
	private String name;
	private int postCode;
	private String address;
	private String detailAddress;
	
	private String regDate;
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
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int no, String id, String password, String name, int postCode, String address, String regDate) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.postCode = postCode;
		this.address = address;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", postCode="
				+ postCode + ", address=" + address + ", regDate=" + regDate + "]";
	}
	
	
}








