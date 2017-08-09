package com.cms.entity;

public class User {
	private Integer id;
	private String userName;
	private String passWord;
	private String canUse;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getCanUse() {
		return canUse;
	}
	public void setCanUse(String canUse) {
		this.canUse = canUse;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", canUse=" + canUse + "]";
	}
	
}
