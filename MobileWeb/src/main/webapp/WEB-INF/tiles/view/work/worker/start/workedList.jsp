<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input type="hidden" id="name"        value="${name}">
<input type="hidden" id="siteName"    value="${siteName}">
<input type="hidden" id="constName"   value="${constName}">
<input type="hidden" id="companyName" value="${companyName}">
<input type="hidden" id="workType"    value="${workType}">
<div id="container">		
    <div class="info_wrap">			
        <div><img src="/assets/img_worker.png" /></div>
    </div>
    <div class="main_menu">
        <div class="btn_main_menu" name="next" value="N">
            <div class="icon_menu"><img src="/assets/icon_main04.png" alt=""></div>
            <div class="menu_txt">새로운 작업</div>
            <div class="icon_arrow_r"><img src="/assets/icon_arrow_next.png" alt="바로가기"></div>
        </div>
        <div class="btn_main_menu" name="next" value="R">
            <div class="icon_menu"><img src="/assets/icon_main05.png" alt=""></div>
            <div class="menu_txt">어제와 동일한 작업</div>
            <div class="icon_arrow_r"><img src="/assets/icon_arrow_next.png" alt="바로가기"></div>
        </div>
        <div class="btn_main_menu" name="next" value="S">
            <div class="icon_menu"><img src="/assets/icon_main02.png" alt=""></div>
            <div class="menu_txt txt_point">돌발 작업</div>
            <div class="icon_arrow_r"><img src="/assets/icon_arrow_next.png" alt="바로가기"></div>
        </div>
    </div>
</div>
<script src="/js/work/worker/start/workedList.js"></script>

