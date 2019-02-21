package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface MgPCService {
	// ����Ʈ �˻� ����¡
	public List<SalesVO> SalesList(int start, int end, String keyword) throws Exception;

	// �Խñ� ī��Ʈ
	public int countArticle(String keyword);

	// ����
	public List<Object> getExcelObject(Map<String, Object> paramMap);

	public List<Object> excelList(SalesVO vo);

	// ������Ȳ
	public List<SalesVO> mgReserveList(SalesVO vo);
}
