<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="container">		
	<div class="today_safety">			
		<div class="safety_result_info txt_normal">감사합니다.<br/>개선 요청 사항이<br/>등록되었습니다.<br/>현장 확인 후<br/><span class="txt_point">즉시 조치하도록 하겠습니다.</span></div>
	</div>	
	<div class="btn_strock mt30">
		<a href="#" class="btn_ok_s" id="next">확인</a>
	</div>
</div>

<script>
    $("#next").click(function() {
        location.href = "/work/worker/main";
    });
</script>
