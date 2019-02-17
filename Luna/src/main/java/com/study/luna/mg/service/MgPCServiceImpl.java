package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.SalesDAO;
import com.study.luna.mg.DAO.SalesDAOImpl;
import com.study.luna.mg.model.SalesVO;

@Service
public class MgPCServiceImpl implements MgPCService {

	@Autowired
	private SalesDAO SalesDAO;
	
	/*������Ȳ ����Ʈ DB*/
	@Override
	public List<SalesVO> SalesList(SalesVO vo) throws Exception {
		System.out.println("SalesList ����");
		return SalesDAO.SalesList(vo);
	}
	/*������Ȳ ����*/
	@Override
	public List<Object> getExcelObject(Map<String, Object> searchMap) {
		return null;
		/*	System.out.println("SalesExcel ����");
		//��Ʈ�ѷ����� �Ѿ�� target�� ���� dao ���౸��
		System.out.println("Mg_sales DB ����");
		return SalesDAO.getSales(searchMap);
		
		if("Mg_sales") {//DB�̸�
			System.out.println("Mg_sales DB ����");
			return SalesDAO.getSales(searchMap);
		}
		if(target.equals("booksDetail")) {
			System.out.println("Mg_sales DB ���� ���ǽ�");
			return SalesDAO.getSalesDetail(searchMap);
		}*/
	}
	@Override
	public List<Object> excelList(SalesVO vo) {
		System.out.println("SalesExcel ����");
		return SalesDAO.getSales(vo);
	}
}
