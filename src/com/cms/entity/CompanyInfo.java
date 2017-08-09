package com.cms.entity;

public class CompanyInfo {
	private Integer id;
	private String address;
	private String phone;
	private String chuanzheng;
	private String people;
	private String busEmail;
	private String techEmail;
	private String page;
	private String business;
	private String qqChat;
	
	public String getQqChat() {
		return qqChat;
	}
	public void setQqChat(String qqChat) {
		this.qqChat = qqChat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "CompanyInfo [id=" + id + ", address=" + address + ", phone=" + phone + ", chuanzheng=" + chuanzheng
				+ ", people=" + people + ", busEmail=" + busEmail + ", techEmail=" + techEmail + ", page=" + page
				+ ", business=" + business + "]";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getChuanzheng() {
		return chuanzheng;
	}
	public void setChuanzheng(String chuanzheng) {
		this.chuanzheng = chuanzheng;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getBusEmail() {
		return busEmail;
	}
	public void setBusEmail(String busEmail) {
		this.busEmail = busEmail;
	}
	public String getTechEmail() {
		return techEmail;
	}
	public void setTechEmail(String techEmail) {
		this.techEmail = techEmail;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
}
