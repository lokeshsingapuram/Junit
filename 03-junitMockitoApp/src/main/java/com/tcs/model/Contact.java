package com.tcs.model;

public class Contact {
	
	private String id;
	private String ContactName;
	private Integer phNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public Integer getPhNo() {
		return phNo;
	}
	public void setPhNo(Integer phNo) {
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", ContactName=" + ContactName + ", phNo=" + phNo + "]";
	}
	
	

}
