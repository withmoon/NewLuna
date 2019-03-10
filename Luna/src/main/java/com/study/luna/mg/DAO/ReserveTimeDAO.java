package com.study.luna.mg.DAO;

import java.util.List;

import com.study.luna.mg.model.ReserveTimeVO;

public interface ReserveTimeDAO {
	//시간대 통계 
	List<ReserveTimeVO> mgAgeList(String paid_at_start, String paid_at_end);

	//차트 리스트값
	List<ReserveTimeVO> getreservcount(String paid_at_start, String paid_at_end, String branchName);

} 
 