<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>카카오페이</title>
    <meta charset="utf-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
	<script type="text/javascript" src="<c:url value="/resources/public/jquery/jquery-3.3.1.min.js"/>"></script>
	<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
</head>
<body>
<script>
IMP.init('imp55565811'); 

IMP.request_pay({
    pg : 'kakao',
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '주문명:결제테스트',
    amount : 1000,
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자이름',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456'
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
        
        $("#hiddenForm").submit();
  		opener.parent.location='/zest/clientPage';		
  	 	swal("결제가 성공적으로 이루어졌습니다", {
            icon: "success"
        });		
        
    } else {
		var msg = '결제에 실패하였습니다.';              
        alert(msg);             	
     	window.close();
    }

    alert(msg);
});
</script>

<!-- 결제 폼 -->
	<form id="hiddenForm" action="/zest/payment/kkaoPayMent" method="post">
		<input type="hidden" name="cl_no" value="${client.cl_no}">
		<input type="hidden" name="talent_no" value="${talent.talent_no}">
		<input type="hidden" name="tt_no" value="${talent.talent_tt_no}">
		<input type="hidden" name="to_real_price" value="${realPrice}">
		<input type="hidden" name="to_use_point" value="${point}"> <input
			type="hidden" name="to_price_total"
			value="${talent.talent_total_price}"> <input type="hidden"
			name="to_meet_count" value="${talent.talent_meet_count}"> <input
			type="hidden" name="to_type" value="kkoPay">			
	</form>

</body>
</html>
