package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface SalesDAO {
	
	
	//������Ȳ
	public List<SalesVO> SalesList(SalesVO vo) throws Exception;
	/*��������*/
	public List<Object> getSales(SalesVO vo);


	
}
