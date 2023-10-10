package com.juju.dto;

public class Member {
	/*NO number(4),
    id varchar2(20) PRIMARY KEY,
	password varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	zipcode number(8),
	address varchar2(100),
	addressdetail varchar2(50),
	regdate date */
	
	private int no;
	private String id;
	private String password;
	private String name;
	private String email;
	private String tel;
	private int zipCode;
	private String address;
	private String addressDetail;
	private String regDate;
	private String profile;
	
	
	public Member() {
		super();
		
	}


	public Member(int no, String id, String password, String name, String email, String tel, int zipCode,
			String address, String addressDetail, String regDate, String profile) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.zipCode = zipCode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.regDate = regDate;
		this.profile = profile;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddressDetail() {
		return addressDetail;
	}


	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", tel=" + tel + ", zipCode=" + zipCode + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", regDate=" + regDate + ", profile=" + profile + "]";
	}
	
	
	
}
