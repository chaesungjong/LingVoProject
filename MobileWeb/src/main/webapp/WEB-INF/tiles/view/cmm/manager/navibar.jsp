<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="popup_layer" id="popup_layer">
	<div class="popup_box">
      <div class="pop_header">
	  	<div class="user" id="userInfor"></div>
		<div class="pop_close"><a href="javascript:closePop();"><img src="/assets/icon_close.png" class="m_header-banner-close" ></a></div>
	  </div>
	  <div class="pop_date_wrap">
		<!-- <div class="date">[최근 접속일] 2023.07.20 16:40:10</div> -->
		<div class="logout"><a href="javascript:logOut();">로그아웃</a></div>
	  </div>
      <!--팝업 컨텐츠 영역-->
      <div class="popup_cont">
		<div class="tit_category"><a href="/work/worker/main">메인</a></div>
		<ul>
			<li><a href="/work/manager/fieldinformation/fieldinformationlist">My 현장정보</a></li>
			<li><a href="/board/noticeBoard?Gubun=Notice">공지사항</a></li>
			<li><a href="/work/manager/irrationality/Mainirrationality">부합리 적발</a></li>		
			<li><a href="/cs/emrContact">비상 연락망</a></li>
		</ul>
		<div class="tit_category">고객센터</div>
		<ul>
			<li><a href="/board/noticeBoard?Gubun=Notice">공지 사항</a></li>
			<li><a href="tel:02-1111-2222">고객센터 전화걸기</a></li>
		</ul>
		<!-- <div class="tit_category">회원정보</div>
		<ul>
			<li><a href="#">회원정보 수정</a></li>
			<li><a href="#">생체 인증 로그인 설정</a></li>
		</ul> -->
      </div>
	</div>
</div>