<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
	<div class="today_safety">			
		<div class="safety_result_info txt_normal">${Msg}</div>
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
