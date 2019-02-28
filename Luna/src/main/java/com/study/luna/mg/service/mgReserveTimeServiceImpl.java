package com.study.luna.mg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.ReserveTimeDAO;
import com.study.luna.mg.model.ReserveTimeVO;

@Service
public class mgReserveTimeServiceImpl implements mgReserveTimeService{

	@Autowired
	ReserveTimeDAO ReserveTimeDAO;
	
	
	//시간대별통계
	@Override
	public List<ReserveTimeVO> mgAgeList() {
		System.out.println("mgAgeList 서비스");
		return ReserveTimeDAO.mgAgeList();
	}


	@Override
	public List<ReserveTimeVO> mgsu(List<ReserveTimeVO> list) {
		// TODO Auto-generated method stub
String[] array = null;
		
		int a00 = 0,a01 = 0,a02 = 0,a03 = 0,a04 = 0,a05 = 0;
		
		
		
		System.out.println(list.toString());
		for(ReserveTimeVO VOVO: list ) {
			System.out.println(VOVO.getReservetime());
			array = VOVO.getReservetime().split(",");
			for(String a : array) {
				System.out.print(a.toString().substring(0, 2)+" ");
//				if(a.toString().substring(0, 2).contains("20")) one += 1;
				switch(a.toString().substring(0, 2)) {
				 case "00" : a00+=1; break;  case "01": a02+=1; break;
				 case "02" : a02+=1; break;  case "03" : a03+=1; break;
				 case "04" : a04+=1;break;   case "22" : a05+=1; break;
				/* case "06" : a06+=1;break;   case "07" : a07+=1; break;
				 case "08" : a08+=1;break;   case "09" : a09+=1; break;
				 case "10" : a10+=1;break;   case "11" : a11+=1;break;
				 case "12" : a12+=1;break;   case "13" : a13+=1;break;
				 case "14" : a14+=1;break;   case "15" : a15+=1;break;
				 case "16" : a16+=1;break;   case "17" : a17+=1;break;
				 case "18" : a18+=1; break;   case "19": a19+=1; break;
				 case "20" : a20+=1;break;   case "21" : a21+=1; break;
				 case "22" : b22+=1;break;   case "23" : a23+=1;break;
				 case "24" : a24+=1;break;*/   			 
				 //이게 무슨 노가다야...
				 }
			}
			System.out.println();
		}
		System.out.println("00 "+a00);
		System.out.println("01 "+a01);
		System.out.println("03 "+a02);
		System.out.println("04 "+a03);
		System.out.println("05 "+a04);
		System.out.println("06 "+a05);
		
		return list;
	}
	
}
