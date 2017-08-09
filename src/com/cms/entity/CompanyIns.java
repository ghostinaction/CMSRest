package com.cms.entity;

public class CompanyIns {
	private Integer id;
	private String instType;
	private String content;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	} 
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyIns [id=" + id + ", instType=" + instType + ", content=" + content + "]";
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the instType
	 */
	public String getInstType() {
		return instType;
	}
	/**
	 * @param instType the instType to set
	 */
	public void setInstType(String instType) {
		this.instType = instType;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
