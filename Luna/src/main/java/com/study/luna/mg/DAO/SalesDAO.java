package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.SalesVO;

public interface SalesDAO {

	// ������Ȳ
	public List<SalesVO> SalesList(int start, int end, String keyword) throws Exception;

	// ���̺� ī��Ʈ
	public int countArticle(String keyword);

	// ��������
	public List<Object> getSales(SalesVO vo);

	// ������Ȳ
	public List<SalesVO> mgReserveList(SalesVO vo);

}
