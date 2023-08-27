<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Body -->
<!-- 이름 -->
<div class="welcome">
  <div class="icon_my"><img src="/assets/admin/icon_my.png" width="" height="" border="0" alt=""></div>
  <div class="txt_h2"><span style="font-weight:bold" id="userName"></div>
</div>
<!-- 날씨 -->
<div class="weather_position" id="detailLink">
  <div class="w_area">
    <div class="weather_left">
      <div class="weather_detail">
        <div class="icon_weather">
          <img src="/assets/icon_weather_good.png" alt="Weather Icon">
        </div>
        <div class="temp" id="currentTemperature">&#8451;</div>
        <div class="conditions" id="todayIconPhrase"></div>
    </div>    
    <div class="weather_right">
      <div class="txt_s">
        <span id="regionName" class="txt_normal"></span>
        <a href="#"><img src="/assets/icon_areaSearch.png" alt="위치찾기" class="icon_weather2"></a>
      </div>
    </div>
    </div>
  </div>
<!-- 업무 내용 -->
<div id="container">	
  <div class="main_menu2 mt30">
    <a href="/work/manager/fieldinformation/fieldinformationlist">
    <div class="btn_main_menu2">
      <div class="icon_menu2"><img src="/assets/admin/icon_main01.png" alt=""></div>
      <div class="menu_txt2">MY 현장 정보</div>
    </div>
    </a>
    <a href="/board/noticeBoard?Gubun=Notice">
    <div class="btn_main_menu2">
      <div class="icon_menu2"><img src="/assets/admin/icon_main02.png" alt=""></div>
      <div class="menu_txt2">공지사항</div>
    </div>
    </a>
  </div>
  <div class="main_menu2 mt20">
    <a href="">
    <div class="btn_main_menu2">
      <div class="icon_menu2"><img src="/assets/admin/icon_main03.png" alt=""></div>
      <div class="menu_txt2">불합리 적발</div>
    </div>
    </a>
    <a href="workReview.html">
    <div class="btn_main_menu2">
      <div class="icon_menu2"><img src="/assets/admin/icon_main04.png" alt=""></div>
      <div class="menu_txt2">작업 후기</div>
    </div>
    </a>
  </div>
  <!-- 뉴스 영역 시작 -->
  <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
      <c:forEach var="notice" items="${noticeList}" varStatus="status">
        <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
            <a href="${notice.url}"><img src="${notice.imgPaths}" class="d-block w-100"></a>
        </div>
    </c:forEach>
    </div>
  </div>
</div>
</div>
<script src="/js/work/manager/main.js"></script>


