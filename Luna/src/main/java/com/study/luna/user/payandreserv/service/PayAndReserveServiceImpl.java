package com.study.luna.user.payandreserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.dao.SetBaseLineDAO;
import com.study.luna.user.payandreserv.dao.Impl.CancleReserveDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.CheckReservStartdateDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetPreDayReserveCountDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetPreMonthReserveCountDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetPreYearReserveCountDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetTermSalesDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetThisYearReserveCountDAOImpl;
import com.study.luna.user.payandreserv.dao.Impl.GetUserPayCountDAOImpl;
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
	@Autowired
	GetUserPayCountDAOImpl gupcDAOImpl;
	@Autowired
	GetPreYearReserveCountDAOImpl gpyrcDAOImpl;
	@Autowired
	GetThisYearReserveCountDAOImpl gtyrcDAOImpl;
	@Autowired
	GetPreDayReserveCountDAOImpl gpdrcDAOImpl;
	@Autowired
	GetPreMonthReserveCountDAOImpl gpmrcDAOImpl;
	@Autowired
	GetTermSalesDAOImpl gtsDAOImpl;
	@Autowired
	SetBaseLineDAO setBaseLineDAO;
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
	public List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate) {
		return gupiDAOImpl.getUserPayInfo(start,end,status,id,startdate,enddate);
	}
	@Override
	public void cancleReserve(MyPageInfoDTO mpif) {
		crDAOImpl.cancleReserve(mpif);
	}
	@Override
	public Integer getUserPayCount(String status, String id,String startdate,String enddate) {
		return gupcDAOImpl.getUserPayCount(status, id,startdate,enddate);
	}
	@Override
	public Integer getPreYearReserveCount() {
		return gpyrcDAOImpl.getPreYearReserveCount();
	}
	@Override
	public Integer getThisYearReserveCount() {
		return gtyrcDAOImpl.getThisYearReserveCount();
	}
	@Override
	public Integer getPreDayReserveCount() {
		return gpdrcDAOImpl.getPreDayReserveCount();
	}
	@Override
	public Integer getPreMonthReserveCount() {
		return gpmrcDAOImpl.getPreMonthReserveCount();
	}
	@Override
	public List<RoomPaymentDTO> getTermSales(String paid_at_start, String paid_at_end) {
		return gtsDAOImpl.getTermSales(paid_at_start, paid_at_end);
	}
	@Override
	public void setBaseLine(RoomPaymentDTO dto) {
		setBaseLineDAO.setBaseLine(dto);
	}
}
