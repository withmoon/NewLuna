package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.ReserveTimeVO;
import com.study.luna.mg.model.SalesVO;

public interface mgReserveTimeService {
	 
	//나이? 시간대별통계
	List<ReserveTimeVO> mgAgeList(String paid_at_start, String paid_at_end);
	//시간 비교
//	List<ReserveTimeVO> mgsu(List<ReserveTimeVO> list, ReserveTimeVO vo);
	ReserveTimeVO mgsu(List<ReserveTimeVO> list, ReserveTimeVO vo);

	//기간통계
	List<ReserveTimeVO> getreservcount(String paid_at_start, String paid_at_end, String branchName);

	
	 
} 
