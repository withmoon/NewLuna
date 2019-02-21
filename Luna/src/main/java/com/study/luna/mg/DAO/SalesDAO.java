package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface SalesDAO {

	// 매출현황
	public List<SalesVO> SalesList(int start, int end, String keyword) throws Exception;

	// 테이블 카운트
	public int countArticle(String keyword);

	// 엑셀파일
	public List<Object> getSales(SalesVO vo);

	// 예약현황
	public List<SalesVO> mgReserveList(SalesVO vo);

}
