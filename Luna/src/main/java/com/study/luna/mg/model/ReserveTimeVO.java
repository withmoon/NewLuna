package com.study.luna.mg.model;

import java.util.Date;

public class ReserveTimeVO {
	private String reservetime;
	private Date reservdate;
	private String branchname;
	
	
	public String getReservetime() {
		return reservetime;
	}
	public void setReservetime(String reservetime) {
		this.reservetime = reservetime;
	}
	public Date getReservdate() {
		return reservdate;
	}
	public void setReservdate(Date reservdate) {
		this.reservdate = reservdate;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	
	
	
}
