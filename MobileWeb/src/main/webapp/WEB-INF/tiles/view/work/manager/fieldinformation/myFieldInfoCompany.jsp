<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h1"><span>전체보기 &gt; 현장명</span> &gt; 대포동사무소리모델링</div>			
    </div>

    <div class="table_wrap mt30">			
        <div class="table_th name">업체명</div>
        <div class="table_th">총인원</div>
        <div class="table_th">안전활동<br/>완료</div>
        <div class="table_th">작업중지<br/>요청</div>	
    </div>
    <c:forEach items="${result}" var="data" varStatus="status">
        <div class="table_wrap mt10">			
            <div class="table_td name">${data.companyName}</div>
            <div class="table_td">${data.nWork}</div>
            <div class="table_td">${data.nSafeEnd}</div>
            <div class="table_td"><a href="/work/manager/fieldinformation/myFieldInfoStop?siteCode=${data.siteCode}&companyName=${data.companyName}">${data.nWorkStopRequest}</a></div>
        </div>
        <c:if test="${status.last}">
            <div class="table_wrap mt10">			
                <div class="table_td name bold">합계</div>
                <div class="table_td bold">${data.nWork}</div>
                <div class="table_td bold">${data.nSafeEnd}</div>
                <div class="table_td bold">${data.nWorkStopRequest}</div>
            </div> 
        </c:if>
    </c:forEach>
</div>