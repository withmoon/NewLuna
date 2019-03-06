package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.ReserveTimeVO;
import com.study.luna.mg.model.SalesVO;

public interface mgReserveTimeService {
	 
	//나이? 시간대별통계
	List<ReserveTimeVO> mgAgeList();

	//시간 비교
//	List<ReserveTimeVO> mgsu(List<ReserveTimeVO> list, ReserveTimeVO vo);
	ReserveTimeVO mgsu(List<ReserveTimeVO> list, ReserveTimeVO vo);

	List<ReserveTimeVO> getreservcount();
	 
} 
