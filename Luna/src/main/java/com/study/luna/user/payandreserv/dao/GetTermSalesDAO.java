package com.study.luna.user.payandreserv.dao;

import java.util.List;

import com.study.luna.user.dto.RoomPaymentDTO;

public interface GetTermSalesDAO {
	List<RoomPaymentDTO> getTermSales(String paid_at_start, String paid_at_end);
}
