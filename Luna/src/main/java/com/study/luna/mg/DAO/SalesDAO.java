package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface SalesDAO {
	
	
	//¸ÅÃâÇöÈ²
	public List<SalesVO> SalesList(SalesVO vo) throws Exception;
	/*¿¢¼¿ÆÄÀÏ*/
	public List<Object> getSales(SalesVO vo);


	
}
