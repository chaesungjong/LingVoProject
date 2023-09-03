<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="Comfirm" action= "/work/worker/end/sendWorkReview" method="post">
  -<div id="container">		
    <div class="today_wrap mt30">	
      <div class="today_info" id="constName" style="display: none;">
        <div class="today_th">시공사</div>
        <div class="today_td">${constName}</div>
      </div>		
      <div class="today_info" id="field" style="display: none;">
        <div class="today_th">현장</div>
        <div class="today_td">${siteName}</div>
      </div>
      <div class="today_info" id="userid" style="display: none;">
        <div class="today_th">요청자</div>
        <div class="today_td">${name}</div>
      </div>
      <div class="today_info" id="locationDiv" style="display: none;">
        <div class="today_th">상세 위치</div>
        <div class="today_td"><input type="text" id="location"  name="location"></div>
      </div>
      <div class="today_info" id="stopwork" style="display: none;">
        <div class="today_th">작업중지<br />요청사유</div>
        <div class="today_td" id="requestWork"></div>
      </div>
      <div class="today_info" id="content" style="display: none;">
        <div class="today_th">내용</div>
        <div class="today_td"><input type="text" id="requestcontent"  name="requestcontent"></div>
      </div>
      <div class="today_info" id="picture" style="display: none;">
        <div class="today_th">사진</div>
        <div class="today_td" id="imgDiv">
          <input type="hidden" id="imgPaths"   name="imgPaths">
        </div>
      </div>
      <div class="btn_strock mt30"><a id="next" href="#" class="btn_ok_s">다음</a></div>			
    </div>
    <input type="hidden" id="reqReason"  name="reqReason">
    <input type="hidden" id="issueGubun" name="issueGubun">
  </form>
  <script src="/js/work/worker/end/workReviewEndPicturePlusDitail.js"></script>
