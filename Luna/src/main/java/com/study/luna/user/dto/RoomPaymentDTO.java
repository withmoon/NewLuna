package com.study.luna.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomPaymentDTO {
	int seq; //로그번호
	String imp_uid; //고유번호
	String merchant_uid; //주문번호
	String branchName; //지점명
	int roomNum; //룸번호
	String id; //user id
	String reserveTime; //예약한 시간
	String reserveEndTime; //예약한 시간
	int payAmount; //결제금액
	int varAmount; //부가세
	int status; //결제상태
	long paid_ats; //결제 시간
	String paid_at;
	String receipt_url; //결제 영수증
	String pg_provider; //결제승인된 pg사
	String pg_tid; //pg사 거래고유번호
	String reservdate; //예약 날짜
	String reservenddate;
	
	String paid_at_start; //시작 날짜 --검색용
	String paid_at_end; //끝날짜 --검색용
	
	String baseline;
}
