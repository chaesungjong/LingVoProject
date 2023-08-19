$(document).ready(function() {

    /**
     * 로그인 버튼
     */
    $("#loginBtn").click(function() {

      // 유저 로그인 정보
      var username = $('#userid').val();
      var password = $('#pwd').val();

      // 유효성 검사
      if (username.trim() === '' || password.trim() === '') {
        alert('로그인 정보를 정확히 입력해주세요.');
        return;
      }
      // 로그인 시도
      $("#frmLogin").prop("action", "/mmb/loginProcess.do");
      $("#frmLogin").submit();

    });

});