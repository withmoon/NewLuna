package com.study.luna.user.payandreserv.dao;

public interface GetUserPayCountDAO {
	Integer getUserPayCount(String status,String id,String startdate,String enddate);
}
