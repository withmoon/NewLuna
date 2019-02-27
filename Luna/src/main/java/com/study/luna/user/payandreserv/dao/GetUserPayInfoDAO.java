package com.study.luna.user.payandreserv.dao;

import java.util.List;

import com.study.luna.user.dto.MyPageInfoDTO;

public interface GetUserPayInfoDAO {
	List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate);
}
