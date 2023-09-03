<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
	<div class="info_wrap">			
		<div class="txt_h1">${title}</div>			
	</div>

	<div class="table_wrap mt30">			
		<div class="table_th name">이름</div>
		<div class="table_th name">안전활동<br />완료</div>
		<div class="table_th name">연락처</div>
		<div class="table_th name">불합리<br />적발내역</div>	
	</div>

	<c:forEach var="item" items="${result}">
		<div class="table_wrap">			
			<div class="table_td">${item.name}</div>
			<div class="table_td">${item.nSafeEnd}</div>
			<div class="table_td"><a href="tel:${item.hpno}"><img src="/assets/icon_calling_l.png" alt="전화걸기" class="call"></a></div>
			<div class="table_td link"><a href="/work/manager/fieldinformation/myFieldInfodetails?userid=${item.userid}&title=${title}">${item.nWorkStopRequest}</a></div>	
		</div>
	</c:forEach>
</div>