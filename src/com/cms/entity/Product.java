package com.cms.entity;

public class Product {
	private Integer id;
	private Integer kindId;
	private String productName;
	private String mainUrl;
	private String detailUrl;
	private String productInfo;
	private String productDetail;
	private String kindName;
	public String getDetailUrl() {
		return detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKindId() {
		return kindId;
	}
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMainUrl() {
		return mainUrl;
	}
	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", kindId=" + kindId + ", productName=" + productName + ", mainUrl=" + mainUrl
				+ ", productInfo=" + productInfo + ", productDetail=" + productDetail + ", kindName=" + kindName + "]";
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
}
