package com.study.luna.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlamDTO {
	int seq;
	int numforwhat;
	String id;
	String fromwho;
	String content;
	int readst;
	String fromwhat;
	String almdate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getNumforwhat() {
		return numforwhat;
	}
	public void setNumforwhat(int numforwhat) {
		this.numforwhat = numforwhat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromwho() {
		return fromwho;
	}
	public void setFromwho(String fromwho) {
		this.fromwho = fromwho;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadst() {
		return readst;
	}
	public void setReadst(int readst) {
		this.readst = readst;
	}
	public String getFromwhat() {
		return fromwhat;
	}
	public void setFromwhat(String fromwhat) {
		this.fromwhat = fromwhat;
	}
	public String getAlmdate() {
		return almdate;
	}
	public void setAlmdate(String almdate) {
		this.almdate = almdate;
	}

	
}
