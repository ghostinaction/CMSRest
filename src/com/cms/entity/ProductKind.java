package com.cms.entity;

public class ProductKind {
	private Integer id;
	private String kindName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKindName() {
		return kindName;
	}
	@Override
	public String toString() {
		return "ProductKind [id=" + id + ", kindName=" + kindName + "]";
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
}
