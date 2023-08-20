<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="frmLogin" method="POST">
	
	<div id="container">		
		<div class="find_pw">			
			<div class="find_tit">아이디 : ${temp_userid} <input type="hidden" name="temp_userid" id="temp_userid" value="${temp_userid}"></div> 
			<div class="find_tit">현재 비밀번호</div>
			<div class="mt10"><input type="password" name="pwd" id="pwd"  placeholder="현재 비밀번호를 입력해 주세요"></div>
			<div class="find_tit">변경할 비밀번호</div>
			<div class="mt10"><input type="password" name="pwdNext" id="pwdNext"  placeholder="변경할 비밀번호를 입력해 주세요"></div>
			<div class="find_tit">변경할 비밀번호 확인</div>
			<div class="mt10"><input type="password" name="pwdNextRe" id="pwdNextRe"  placeholder="변경할 비밀번호를 입력해 주세요"></div>
		</div>	
	</div>

	<!-- Btn --> 
	<div class="btn_wrap"><a href="#" id="pweInitBtn" class="btn_next">비밀번호 재설정</a></div>
	<!-- //Btn -->
	
</form>
<script src="/js/mmb/pwdInit.js"></script>