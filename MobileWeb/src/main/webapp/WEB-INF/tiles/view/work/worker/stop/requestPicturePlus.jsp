<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="container">		
  <div class="workStop_wrap">			
    <div class="workStop_title">사진 첨부</div>
  </div>	
  <div class="today_wrap">
      <a href="#" id="addGallery">
        <div class="workStop_list">				
          <div class="icon_menu"><img src="/assets/icon_gallery.png" alt=""></div>
          <div class="menu_txt">사진 보관함</div>
          <div class="icon_arrow_r"><img src="/assets/icon_arrow_right.png" alt="바로가기"></div>			
        </div>
      </a>
      <a href="#" id="addPicture">
        <div class="workStop_list">				
          <div class="icon_menu"><img src="/assets/icon_camera.png" alt=""></div>
          <div class="menu_txt">사진 찍기</div>
          <div class="icon_arrow_r"><img src="/assets/icon_arrow_right.png" alt="바로가기"></div>			
        </div>
      <div class="btn_strock mt30"><a id="next" href="#" class="btn_ok_s">다음</a></div>		
      <div class="workStop_wrap" id="pictureList" style="display: none;">			
        <div class="workStop_title">사진</div>
      </div>	
    <div class="icon_photo_wrap" id="imageDiv">
    </div>
  </div>
</div>
<script src="/js/work/worker/stop/requestPicturePlus.js"></script>


