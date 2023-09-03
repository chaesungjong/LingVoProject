<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="today_safety">			
        <div class="safety_result">"전송이 완료되었습니다."</div>
        <div class="safety_result_info">${Msg}</div>
        <div class="btn_strock mt30">
            <a  id="next" href="#" class="btn_ok_s">확인</a>
        </div>
    </div>
</div>
<script src="/js/work/worker/stop/requestPictureComfirm.js"></script>