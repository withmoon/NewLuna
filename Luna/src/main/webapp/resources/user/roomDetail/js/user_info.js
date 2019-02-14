var userInfo = (function (jq) {
	"use strict";

	var validTel = false;
	var validBirthDate = false;
	var validSubmit = false;
	var paymentStopMsg = "카카오페이 결제를 중단하시겠습니까?";

	function eventBind() {
		jq("#tfPhone").on('focus', activateInput);
		jq("#tfPhone").on('blur', inactivateInput);
		jq("#tfBirthday").on('focus', activateInput);
		jq("#tfBirthday").on('blur', inactivateInput);
		/*[-
		 *	입력 필드 변경,keyup,붙여넣기,input,cut 이벤트 시
		 *	validate format
		 * -]*/
		jq("#tfPhone").on("change keyup paste input cut", checkTelFormat);
		jq("#tfBirthday").on("change keyup paste input cut", checkBirthdayFormat);

		jq(".btn_close").on('click', function () {
            teslaBaseCommon.payConfirm(paymentStopMsg,
				function(){return teslaCommonPayment.paymentStop(hash, isCancelPost, blockUserEvents, "#actionPost");}
			);
		});
	}

	function activateInput(e) {
		jq(e.target).parent().toggleClass("data_focus");
	}

	function inactivateInput(e) {
		jq(e.target).parent().removeClass("data_focus");
	}

	function isValidTel(tel) {
		var regexTel = /^0\d{9,10}$/;
		if (regexTel.test(tel)) {
			validTel = true;
		} else {
			validTel = false;
		}
	}

	function isValidBirthday(birthDay) {
		var regexBirthDay = /^\d{6}$/;
		if (regexBirthDay.test(birthDay)) {
			validBirthDate = true;
		} else {
			validBirthDate = false;
		}
	}

	function updateSubmitStatus() {
		if (validTel === true && validBirthDate === true) {
			validSubmit = true;
			jq(".btn_submit").removeAttr("disabled");
		} else {
			validSubmit = false;
			jq(".btn_submit").attr("disabled", "disabled");
		}
	}

	function checkTelFormat(e) {
		var tel = jq(this).val();
		isValidTel(tel);
		updateSubmitStatus();
	}

	function checkBirthdayFormat(e) {
		var birthDay = jq(this).val();
		isValidBirthday(birthDay);
		updateSubmitStatus();
	}

	function blockUserEvents() {
		$("#userPost").attr("disabled", "disabled");
		$(".btn_close").click(
			function (e) {
				e.preventDefault();
			}
		)
	}

	return {
		"eventBind": eventBind
	}

})(jQuery);
jQuery(document).ready(function () {
	userInfo.eventBind();
});