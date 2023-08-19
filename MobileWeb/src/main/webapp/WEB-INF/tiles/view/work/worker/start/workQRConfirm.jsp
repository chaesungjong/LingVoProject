<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <div id="container">		
    <div class="info_wrap">			
      <div class="txt_h1">아래 정보를 꼭 확인 후 진행하여 주세요.</div>
      <div class="txt_h2 mb30">실제 현장과 다른 경우 고객센터 1234-1111로 문의 바랍니다</div>
    </div>
    <div class="today_wrap mt30">			
      <div class="today_info">
        <div class="today_th">위치</div>
        <div class="today_td">${siteAddress}</div>
      </div>
      <div class="today_info">
        <div class="today_th">현장</div>
        <div class="today_td">${siteName}</div>
      </div>
      <div class="today_info">
        <div class="today_th">시공사</div>
        <div class="today_td">${constName}</div>
      </div>
      <div class="today_info">
        <div class="today_th">소속회사</div>
        <div class="today_td">${companyName}</div>
      </div>
      <div class="today_info">
        <div class="today_th">공통</div>
        <div class="today_td">${workType}</div>
      </div>
      <div class="btn_strock mt30"><a id="next" href="#" class="btn_ok_s">확인</a></div>
    </div>
  </div>
</div>
<script src="/js/work/worker/start/workQRConfirm.js"></script>