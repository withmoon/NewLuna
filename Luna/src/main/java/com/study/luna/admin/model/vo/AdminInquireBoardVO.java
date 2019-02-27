package com.study.luna.admin.model.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminInquireBoardVO {

	private Integer seq;
	private String id;
	private String branchname;
	private String content;
	private String fileupload;
	private String reply;
	private String email;
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileupload() {
		return fileupload;
	}
	public void setFileupload(String fileupload) {
		this.fileupload = fileupload;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AdminInquireBoardVO [seq=" + seq + ", id=" + id + ", branchname=" + branchname + ", content=" + content
				+ ", fileupload=" + fileupload + ", reply=" + reply + ", email=" + email + "]";
	}
	
}
