<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>카카오페이</title>
    <meta charset="utf-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
	<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
	<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script> <!-- 아임포트를 사용한 카카오 페이 -->
</head>
<body>
<!-- 여기서 쓰고 말거 -->
<input type="hidden" id="roomName" name="roomName" value="${roomInfo.roomName}"/>
<input type="hidden" id="branchName" name="branchName" value="${roomInfo.branchName}"/>
<input type="hidden" id="payAmount" name="payAmount" value="${roomPay.payAmount}"/>

<input type="hidden" id="email" name="email" value="${member.email}"/>
<input type="hidden" id="email" name="email" value="${member.name}"/>
<input type="hidden" id="phone" name="phone" value="${member.phone}"/>

<script>
var roomname=$("#roomName").val();
var payamount=$("#payAmount").val();
var branchName=$("#branchName").val();
var email=$("#email").val();
var name=$("#name").val();
var phone=$("#phone").val();

IMP.init('imp55565811'); 

IMP.request_pay({
    pg : 'kakaopay',
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : roomname, //아이템 명
    amount : payamount, //총결제 금액
    buyer_email : email, //구매자 이메일
    buyer_name : name, //id
    buyer_tel : phone, //번호
    company : '달빛 스터디카페'+branchName //지점명
}, function(rsp) {
    if ( rsp.success ) {
       var result = '';
        result += '고유번호ID:' + rsp.imp_uid+':';
        result += '주문번호:' + rsp.merchant_uid+':';
        result += '실결제금액:' + rsp.paid_amount+':';
        result += '결제승인된 pg사:' + rsp.pg_provider+':';
        result += 'pg사 거래고유번호:' + rsp.pg_tid+':';
        result += '결제승인시각:' +rsp.paid_at+':';
        result += 'pg사에서 발행된 거래 매출 전표:' + rsp.receipt_url;

        var doc = window.opener.document,
        theForm = doc.getElementById("theForm"),
        branchName = doc.getElementById("branchName");
       	//alert(branchName.value);
 	   	/*
 	   		<input type="hidden" id="branchName" name="branchName" value="${roomInfo.branchName}"/>
 	  		<input type="hidden" id="roomNum" name="roomNum" value="${roomInfo.roomNum}"/>
 			<input type="hidden" id="reserveTime" name="reserveTime" value="${roomPay.reserveTime}"/>
 	        <input type="hidden" id="imp_uid" name="imp_uid" value="${roomPay.imp_uid}"/>
 	        <input type="hidden" id="merchant_uid" name="merchant_uid" value="${roomPay.merchant_uid}"/>
 	        <input type="hidden" id="payAmount" name="payAmount" value="${roomPay.payAmount}"/>
 	        <input type="hidden" id="paid_at" name="paid_at" value="${roomPay.paid_at}"/>
 	        <input type="hidden" id="receipt_url" name="receipt_url" value="${roomPay.receipt_url}"/> 
 	   */
 	   	window.close();
   	 	theForm.submit();
 		
  	 	alert("결제가 성공적으로 이루어졌습니다", {
            icon: "success"
        });	
  	 	
    } else {
		var msg = '결제에 실패하였습니다.';              
        alert(msg);             	
     	window.close();
    }
});
</script>
</body>
</html>
