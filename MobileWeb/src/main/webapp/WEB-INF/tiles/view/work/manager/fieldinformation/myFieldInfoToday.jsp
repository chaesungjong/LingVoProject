<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <div class="info_wrap">			
    <div class="txt_h1">전체보기</div>
    <div class="txt_h4 mb30">${date}</div>
  </div>
  <div class="today_wrap mt30">			
    <div class="today_info">
      <div class="today_th">총 근로자</div>
      <div class="today_td">${result.nWork}</div>
    </div>
    <div class="today_info">
      <div class="today_th">안전활동 완료</div>
      <div class="today_td"><span class="txt_point">${result.nSafeEnd}</span></div>
    </div>
    <div class="today_info">
      <div class="today_th">작업중지 요청</div>
      <div class="today_td">${result.nWorkStopRequest}</div>
    </div>

    <div class="btn_strock mt30">
      <a href="/work/manager/fieldinformation/myFieldInfoAll" class="btn_ok_s">자세히 보기</a>
    </div>

    <div class="txt_h5 mt30">
      ＊ 총 근로자는 금일 QR코드 인증된 근로자 수 입니다.<br />
      ＊ 안전 활동 완료 조건은 AI 전화 응답 완료입니다.<br />
      ＊ 불합리 적발 과거 내역은 메인 화면 불합리 적발에서 확인 가능합니다.	
    </div>
  </div>			
  
</div>