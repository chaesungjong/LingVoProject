<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="container">		
    <div class="today_safety">			
        <div class="safety_img"><img src="/assets/img_workEnd.png" alt="안전합니다"></div>
        <div class="safety_result txt_normal">오늘 하루도<br /> 안전하게 일해 주시어<br /> 고맙습니다.</div>
        <div class="btn_strock mt30">
            <a href="#" class="btn_ok_s" id="next">확인</a>
        </div>
    </div>
</div>
<script>
    $("#next").click(function() {
        location.href = "/work/worker/main";
    });
</script>
