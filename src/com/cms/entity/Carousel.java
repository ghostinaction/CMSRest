package com.cms.entity;

public class Carousel {
	private Integer id;
	private String imgUrl;
	private String hrefUrl;
	private String desic;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getHrefUrl() {
		return hrefUrl;
	}
	public void setHrefUrl(String hrefUrl) {
		this.hrefUrl = hrefUrl;
	}
	public String getDesic() {
		return desic;
	}
	public void setDesc(String desic) {
		this.desic = desic;
	}
	@Override
	public String toString() {
		return "Carousel [id=" + id + ", imgUrl=" + imgUrl + ", hrefUrl=" + hrefUrl + ", desc=" + desic + "]";
	}
	
}
