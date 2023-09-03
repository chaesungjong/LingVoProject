<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="info_wrap">			
  <div><img src="/assets/admin/img_Manager.png" /></div>
</div>

<div class="main_menu">
  <a href="/work/manager/fieldinformation/myFieldInfoToday">
  <div class="btn_main_menu">
    <div class="icon_menu"><img src="/assets/admin/icon_all.png" alt=""></div>
    <div class="menu_txt">전체 보기</div>
    <div class="icon_arrow_r"><img src="/assets/admin/icon_arrow_next.png" alt="바로가기"></div>
  </div>
  </a>
  <a href="/work/manager/fieldinformation/myFieldInfoAll">
  <div class="btn_main_menu">
    <div class="icon_menu"><img src="/assets/admin/icon_district.png" alt=""></div>
    <div class="menu_txt">행정 구역별 보기</div>
    <div class="icon_arrow_r"><img src="/assets/admin/icon_arrow_next.png" alt="바로가기"></div>
  </div>
  </a>
  <a href="/work/manager/fieldinformation/myFieldInfoAll?gubun=CONST_ALL" id="grade" style="display: none;">
    <div class="btn_main_menu">
      <div class="icon_menu"><img src="/assets/admin/icon_main02.png" alt=""></div>
      <div class="menu_txt">시공사별 보기</div>
      <div class="icon_arrow_r"><img src="/assets/admin/icon_arrow_next.png" alt="바로가기"></div>
    </div>
  </a>
<script src="/js/work/manager/fieldinformation/fieldinformationlist.js"></script>
