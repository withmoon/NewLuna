package com.study.luna.user.payandreserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.dao.Impl.CancleReserveDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.CheckReservStartdateDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetUserPayInfoDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.InReserveRoomDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.InRoomPaymentDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.UpReserveRoomDAOImpl;

@Service
public class PayAndReserveServiceImpl implements PayAndReserveService{
	@Autowired
	CheckReservStartdateDAOImpl crsdDAOImpl;
	@Autowired
	InReserveRoomDAOImpl irrDAOImpl;
	@Autowired
	UpReserveRoomDAOImpl urrDAOImpl;
	@Autowired
	InRoomPaymentDAOImpl irpDAOImp;
	@Autowired
	GetUserPayInfoDAOImpl gupiDAOImpl;
	@Autowired
	CancleReserveDAOImpl crDAOImpl;
	
	@Override
	public Integer checkReservStartdate(RoomReserveDTO romre) {
		return crsdDAOImpl.checkReservStartdate(romre);
	}
	@Override
	public void inReserveRoom(RoomReserveDTO romre) {
		irrDAOImpl.inReserveRoom(romre);
	}
	@Override
	public void upReserveRoom(RoomReserveDTO romre) {
		urrDAOImpl.upReserveRoom(romre);
	}
	@Override
	public void inRoomPayment(RoomPaymentDTO rompay) {
		irpDAOImp.inRoomPayment(rompay);
	}
	@Override
	public List<MyPageInfoDTO> getUserPayInfo(MemberCommand memcom) {
		return gupiDAOImpl.getUserPayInfo(memcom);
	}
	@Override
	public void cancleReserve(MyPageInfoDTO mpif) {
		crDAOImpl.cancleReserve(mpif);
	}
}
