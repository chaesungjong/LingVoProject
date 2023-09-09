<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="footers">	
	<a href="/board/videoBoard">
	<div class="mn_wrap">
		<div class="icon_mn"><img src="/assets/admin/icon_mn04_10jjang.png" alt=""></div>
		<div class="txt_mn">십짱TV</div>
	</div>
	</a>
	<a href="/work/manager/main">
	<div class="mn_wrap">
		<div class="icon_mn"><img src="/assets/admin/icon_mn01_home_on.png" alt=""></div>
		<div class="txt_mn">home</div>
	</div>
	</a>
	<a href="/cs/emrContact">
	<div class="mn_wrap">
		<div class="icon_mn"><img src="/assets/admin/icon_mn02_network.png" alt=""></div>
		<div class="txt_mn">비상연락망</div>
	</div>
	</a>	
</div>
<div class="popup_Alert" id="popup_Alert">
	<div class="popup_cont_wrap">
		<div class="pop_cont" id="popup_message"></div>
		<div class="popBtn_wrap">
			<div><a href="#" id="popup_cancel" class="btn_cancel">취소</a></div>
			<div><a href="#" id="popup_ok"     class="btn_ok">확인</a></div>
		</div>
	</div>
</div>