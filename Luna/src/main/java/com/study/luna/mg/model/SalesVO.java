package com.study.luna.mg.model;

import java.util.Date;

public class SalesVO {
	//매출현황
	private Date date;
	private Integer inone;
	private Integer su;
	private Integer sales1;
	private String market;
	private Integer sales2;
	private Integer total;
	
	//예약현황
	private int seq; //��ȣ
	private String imp_uid; //id
	private String merchant_uid;
	private String branchname;
	private String roomnum; 
	private Date paid_at;
	private int status; //����
	private String stats; //�����ѱ�  뭐에 쓸려고 만든지 아시는분 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getInone() {
		return inone;
	}
	public void setInone(Integer inone) {
		this.inone = inone;
	}
	public Integer getSu() {
		return su;
	}
	public void setSu(Integer su) {
		this.su = su;
	}
	public Integer getSales1() {
		return sales1;
	}
	public void setSales1(Integer sales1) {
		this.sales1 = sales1;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public Integer getSales2() {
		return sales2;
	}
	public void setSales2(Integer sales2) {
		this.sales2 = sales2;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public Date getPaid_at() {
		return paid_at;
	}
	public void setPaid_at(Date paid_at) {
		this.paid_at = paid_at;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
