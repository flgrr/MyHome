package com.msys.domain;

import java.util.Date;

@SuppressWarnings("serial")  //???????
public class Tests implements java.io.Serializable{//实现一个接口   javabean
	
	private Integer textID;
	private String textName;
	private Date textDate;
	private String textRemark;
	
	
	public Integer getTextID() {
		return textID;
	}
	public void setTextID(Integer textID) {
		this.textID = textID;
	}
	public String getTextName() {
		return textName;
	}
	public void setTextName(String textName) {
		this.textName = textName;
	}
	public Date getTextDate() {
		return textDate;
	}
	public void setTextDate(Date textDate) {
		this.textDate = textDate;
	}
	public String getTextRemark() {
		return textRemark;
	}
	public void setTextRemark(String textRemark) {
		this.textRemark = textRemark;
	}

	
}
