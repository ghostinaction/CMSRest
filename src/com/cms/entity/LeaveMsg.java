package com.cms.entity;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class LeaveMsg {
	private Integer id;
	private String nickName;
	private String email;
	private String phone;
	private String companyName;
	private String companyAddress;
	private String title;
	private String content;
	private String captcha;
	
	private static Format format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	//自动把new Date()的非标准格式转化为这种格式表示,其实不加这个也是可以存到标准的时间的
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date leaveTime;
    
    
    
    
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	@Override
	public String toString() {
		return "LeaveMsg [id=" + id + ", nickName=" + nickName + ", email=" + email + ", phone=" + phone
				+ ", companyName=" + companyName + ", companyAddress=" + companyAddress + ", title=" + title
				+ ", content=" + content + ", leaveTime=" + leaveTime + "]";
	}
	public Date getLeaveTime() {
		return this.leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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
	
	
}
