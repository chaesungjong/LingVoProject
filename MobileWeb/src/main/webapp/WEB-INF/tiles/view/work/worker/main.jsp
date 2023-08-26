<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.castlebell.lingvo.cmm.session.Member" %>
<%@ page import="com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin" %>
<%  
    // 세션에서 사용자 정보 가져오기
    Member member = (Member) session.getAttribute("member");
    RequestLogin autoLogin = (RequestLogin) session.getAttribute("autoLogin");
    String userName = (member != null) ? member.getName() : "";
    String userid = (member != null) ? member.getUserid() : "";
    String userPw = (autoLogin != null) ? autoLogin.getUserpw() : "";
%>

<script>
    // 사용자 이름과 아이디 변수 선언
    var userid    = '<%= userid %>';
    var userPw    = '<%= userPw %>';
    if (userid!= ''||userPw !== '') {
		getloginInfo(userid, userPw);
	}
</script>
<!-- 환영 메시지 영역 시작 -->
<div class="welcome">
  <div class="icon_my">
    <img src="/assets/icon_my.png" alt="My Icon">
  </div>
  <div class="txt_h2" id="Welcome">
    <span style="font-weight:bold"></span>
  </div>
</div>
<!-- 환영 메시지 영역 종료 -->

<!-- 날씨 정보 영역 시작 -->
<div class="weather_position">
  <div class="w_area">
    <div class="weather_left">
      <div class="weather_detail">
        <div class="icon_weather">
          <img src="/assets/icon_weather_good.png" alt="Weather Icon">
        </div>
        <div class="temp" id="currentTemperature">&#8451;</div>
        <div class="conditions" id="todayIconPhrase"></div>
      </div>
      <div class="txt_s" id="todayTemperature"></div>
    </div>
    <div class="weather_right">
      <div class="txt_s">
        <span id="regionName" class="txt_normal"></span>
        <a href="#"><img src="/assets/icon_areaSearch.png" alt="위치찾기" class="icon_weather2"></a>
      </div>
    </div>
  </div>
</div>
<!-- 날씨 정보 영역 종료 -->

<!-- 주요 메뉴 영역 시작 -->
<div id="container">	
  <div class="main_menu mt80">
    <!-- 금일 작업 시작 버튼 -->
    <a id="workStart" href="#">
      <div class="btn_main_menu">
        <div class="icon_menu"><img src="/assets/icon_main01.png" alt="금일작업시작 아이콘"></div>
        <div class="menu_txt">금일작업시작</div>
        <div class="icon_arrow_r"><img src="/assets/icon_arrow_next.png" alt="바로가기"></div>
      </div>
    </a>
    <!-- 작업 중지 요청 버튼 -->
    <a href="/work/worker/stop/requestStopWorkList">
      <div class="btn_main_menu">
        <div class="icon_menu"><img src="/assets/icon_main02.png" alt="작업중지요청 아이콘"></div>
        <div class="menu_txt">작업중지요청</div>
        <div class="icon_arrow_r"><img src="/assets/icon_arrow_next.png" alt="바로가기"></div>
      </div>
    </a>
    <!-- 작업 후기 버튼 -->
    <a href="/work/worker/end/workReview">
      <div class="btn_main_menu">
        <div class="icon_menu"><img src="/assets/icon_main03.png" alt="작업후기 아이콘"></div>
        <div class="menu_txt">작업후기</div>
        <div class="icon_arrow_r"><img src="/assets/icon_arrow_next.png" alt="바로가기"></div>
      </div>
    </a>
  </div>
  <!-- 주요 메뉴 영역 종료 -->

  <!-- 뉴스 영역 시작 -->
  <div class="news_area">
    <div class="news_info">
      <div><img src="/assets/news01-1.png" alt="연합뉴스"> 1시간 전</div>
      <div>[네이버 뉴스]</div>
    </div>
    <div class="news_title">
      <div><a href="#">서울 33도 등 무더위, 전국 대부분 폭염특보 </a></div>
      <div><a href="#">해병대 "순직 해병대원 명복 빌어.유족께.</a></div>
    </div>
  </div>
  <!-- 뉴스 영역 종료 -->
</div>

<!-- 하단 자바스크립트 포함 영역 시작 -->
<script src="/js/work/worker/main.js"></script>
<!-- 하단 자바스크립트 포함 영역 종료 -->