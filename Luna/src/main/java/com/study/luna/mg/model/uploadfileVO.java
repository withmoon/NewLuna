package com.study.luna.mg.model;

public class uploadfileVO {
	private int roomnum;
	private int filenum;
	private String Oname;
	private String Fname;
	private String savePath;
	
	
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public int getFilenum() {
		return filenum;
	}
	public void setFilenum(int filenum) {
		this.filenum = filenum;
	}
	public String getOname() {
		return Oname;
	}
	public void setOname(String oname) {
		Oname = oname;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	
}


