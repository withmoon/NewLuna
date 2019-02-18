package com.study.luna.admin.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class AdminNoticeBoardVO {

	private int num;
	private String title;
	private String content;
	private Date regdate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "AdminNoticeBoardVO [num=" + num + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ "]";
	}
	
	
}
