<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form id="Comfirm" action= "/work/manager/irrationality/exposurePicturePlusComfirm" method="post">
  <div id="container">		
    <div class="today_wrap mt30">	
      <div class="today_info" id="exposure">
        <div class="today_th">부합리 유형</div>
        <div class="today_td"><input type="text" id="InputExposure"  name="InputExposure"></div>
      </div>		
      <div class="today_info" id="worker">
        <div class="today_th">위반자 ID</div>
        <div class="today_td"><input type="text" id="InputWorker"  name="InputWorker"></div>
      </div>
      <div class="today_info" id="location">
        <div class="today_th">위치</div>
        <div class="today_td"><input type="text" id="InputLocation"  name="InputLocation"></div>
      </div>
      <div class="today_info" id="content">
        <div class="today_th">내용</div>
        <div class="today_td"><input type="text" id="InputContent"  name="InputContent"></div>
      </div>
      <div class="today_info" id="picture">
        <div class="today_th">사진</div>
        <div class="today_td" id="imgDiv">
          <input type="hidden" id="imgPaths" name="imgPaths">
        </div>
      </div>
      <div class="btn_strock mt30"><a id="next" href="#" class="btn_ok_s">다음</a></div>			
    </div>
  </div>
    <input type="hidden" id="illegalClass"  name="illegalClass">
  </form>
  <script src="/js/work/manager/irrationality/exposurePicturePlusDitail.js"></script>
