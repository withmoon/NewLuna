package com.study.luna.mg.DAO;

import java.util.List;

import com.study.luna.mg.model.ReserveTimeVO;

public interface ReserveTimeDAO {
	//시간대 통계
	List<ReserveTimeVO> mgAgeList();

}
