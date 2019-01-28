//<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('da37e5836c002230d358ce5af57a57ca');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {

        Kakao.API.request({
            url: '/v2/user/me',
            success: function(res) {
            	
            	$("input[name=kid]").val(res.id);
            	$("input[name=knic]").val(res.properties.nickname);
            	
            	kform.submit();

            },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
        });
      },
      fail: function(err) {
       alert(JSON.stringify(err));
      }
    });
    
  	// ]]>
