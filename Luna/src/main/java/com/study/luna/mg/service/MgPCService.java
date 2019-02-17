package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface MgPCService {
	public List<SalesVO> SalesList(SalesVO vo) throws Exception;

	public List<Object> getExcelObject(Map<String, Object> paramMap);

	public List<Object> excelList(SalesVO vo);

}
