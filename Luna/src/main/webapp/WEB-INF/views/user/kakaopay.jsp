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
<script>

var email="";
var name="";
var tel="";

IMP.init('imp55565811'); 

IMP.request_pay({
    pg : 'kakaopay',
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : 'room', //아이템 명
    amount : 1000, //총결제 금액
    buyer_email : 'iamport@siot.do', //구매자 이메일
    buyer_name : '구매자이름', //id
    buyer_tel : '010-1234-5678', //번호
    company : '달빛 스터디카페'+'지점명' //지점명
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
        theField = doc.getElementById("theField");
 	   	theField.value ="";
 	   
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
