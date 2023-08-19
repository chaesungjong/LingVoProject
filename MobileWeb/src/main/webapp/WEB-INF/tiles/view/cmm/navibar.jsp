<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="popup_layer" id="popup_layer">
	<div class="popup_box">
      <div class="pop_header">
	  	<div class="user" id="userInfor"></div>
		<div class="pop_close"><a href="javascript:closePop();"><img src="/assets/icon_close.png" class="m_header-banner-close" ></a></div>
	  </div>
	  <div class="pop_date_wrap">
		<!-- <div class="date">[최근 접속일] 2023.07.20 16:40:10</div> 
		<div class="logout"><a href="/login/login.html">로그아웃</a></div>-->
	  </div>
      <!--팝업 컨텐츠 영역-->
      <div class="popup_cont">
		<div class="tit_category">메인</div>
		<ul>
			<li><a href='javascript:openQRCode("/work/worker/start/workQRConfirm");'>금일 작업 시작</a></li>
			<li><a href="/work/worker/stop/requestStopWorkList">작업 중지 요청</a></li>
			<li><a href="/work/worker/end/workReview">작업 후기</a></li>
			<li><a href="/cs/emrContact">비상연락망</a></li>
			<li><a href="/board/noticeBoard?Gubun=Notice">공지 사항</a></li>
			<li><a href="/board/videoBoard">십짱TV</a></li>
		</ul>
		<!--<div class="tit_category">고객센터</div>
		<ul>
			<li><a href="#">공지사항</a></li>
			<li><a href="/cs/customer_FAQ.html">FAQ</a></li>
			<li><a href="#">고객센터 전화걸기</a></li>
		</ul>
		 <div class="tit_category">회원정보</div>
		<ul>
			<li><a href="#">회원정보 수정</a></li>
			<li><a href="#">생체 인증 로그인 설정</a></li>
		</ul> -->
      </div>
	</div>
</div>