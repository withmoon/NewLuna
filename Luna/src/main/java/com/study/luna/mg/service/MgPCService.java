package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface MgPCService {
	// 리스트 검색 페이징
	public List<SalesVO> SalesList(int start, int end, String keyword) throws Exception;

	// 게시글 카운트
	public int countArticle(String keyword);

	// 엑셀
	public List<Object> getExcelObject(Map<String, Object> paramMap);

	public List<Object> excelList(SalesVO vo);

	// 예약현황
	public List<SalesVO> mgReserveList(SalesVO vo);
}
