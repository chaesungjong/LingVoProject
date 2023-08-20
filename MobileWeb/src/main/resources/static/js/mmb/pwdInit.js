$(document).ready(function() {

    /**
     * 로그인 버튼
     */
    $("#pweInitBtn").click(function() {

      // 유저 로그인 정보
      var temp_userid = $('#temp_userid').val();
      var pwd = $('#pwd').val();
      var pwdNext = $('#pwdNext').val();
      var pwdNextRe = $('#pwdNextRe').val();

      // 유효성 검사
      if (pwd.trim() === '' || pwdNext.trim() === ''|| pwdNextRe.trim() === '') {
        alert('비밀번호를 정확히 입력해주세요.');
        $('#pwdNext').focus();
        return;
      }
      if (pwdNext.trim() != pwdNextRe.trim()) {
        alert('변경할 비밀번호와 변경할 비밀번호 확인이 일치하지 않습니다.');
        $('#pwdNextRe').focus();
        return;
      }
      // 로그인 시도
      $("#frmLogin").prop("action", "/mmb/pwdInitProcess.do");
      $("#frmLogin").submit();

    });

});