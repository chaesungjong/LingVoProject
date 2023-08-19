<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frmLogin" method="POST">
	<div id="container">		
		<div class="login_wrap">			
			<div class="logo"><img src="/assets/logo_lingvo.png" alt="링보"></div>
			<fieldset>
				<legend>Login</legend>
				<div><input type="text" name="userid" id="userid" maxlength="16" placeholder="아이디를 입력해 주세요"/></div>
				<div><input type="text" name="pwd" id="pwd"  maxlength="16" placeholder="비밀번호를 입력해 주세요"/></div>
			</fieldset>
			<div class="btn_normal mt10">
				<div class="btn_normal mt10"><a  href="#" id="loginBtn" class="btn_ok_s">로그인</a></div>
			</div>
		</div>
	</div>
</form>
<script src="/js/mmb/login.js"></script>