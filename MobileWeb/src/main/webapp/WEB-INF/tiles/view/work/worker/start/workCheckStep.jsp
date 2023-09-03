<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input type="hidden" id="messageList"    value="${messageList}">
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h3">작업 전 안전예방활동</div>			
    </div>
    <div class="today_safety">			
        <div><img src="/assets/img_noti_top.png"  alt=""></div>
        <div class="safety_box">
            <div class="safety_txt" id="title">
            </div>
            <div class="safety_num"><strong id="click"></strong><span>/</span><strong id="total">10</strong></div>
        </div>
        <div><img src="/assets/img_noti_bottom.png" alt=""></div>
    </div>
    <div class="btn_strock mt30">
        <a id="next" href="#" class="btn_ok_stop">확인</a>
    </div>
</div>
<script src="/js/work/worker/start/workCheckStep.js"></script>