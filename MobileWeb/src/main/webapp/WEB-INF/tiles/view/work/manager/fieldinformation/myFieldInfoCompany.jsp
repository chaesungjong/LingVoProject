<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h1"><span>전체보기 &gt; 현장명</span> &gt; ${title}</div>			
    </div>

    <div class="table_wrap mt30">			
        <div class="table_th name">업체명</div>
        <div class="table_th">총인원</div>
        <div class="table_th">안전활동<br/>완료</div>
        <div class="table_th">작업중지<br/>요청</div>	
    </div>
    <c:forEach items="${result}" var="data" varStatus="status">
        <div class="table_wrap mt10">			
            <div class="table_td name"><a href="/work/manager/fieldinformation/myFieldInfoEmployee?siteCode=${data.siteCode}&companyName=${data.companyName}">${data.companyName}</a></div>
            <div class="table_td">${data.nWork}</div>
            <div class="table_td">${data.nSafeEnd}</div>
            <div class="table_td"><a href="/work/manager/fieldinformation/myFieldInfoStop?siteCode=${data.siteCode}&companyName=${data.companyName}">${data.nWorkStopRequest}</a></div>
        </div>
    </c:forEach>
    <c:choose>
        <c:when test="${totalResult == null}">
            <div class="table_wrap mt10">			
                <div class="table_td name bold">합계</div>
                <div class="table_td bold">${nWork}</div>
                <div class="table_td bold">${nSafeEnd}</div>
                <div class="table_td bold">${nWorkStopRequest}</div>
            </div> 
        </c:when>
        <c:otherwise>
            <div class="table_wrap mt10">			
                <div class="table_td name bold">합계</div>
                <div class="table_td bold">${totalResult.nWork}</div>
                <div class="table_td bold">${totalResult.nSafeEnd}</div>
                <div class="table_td bold">${totalResult.nWorkStopRequest}</div>
            </div> 
        </c:otherwise>
    </c:choose>
</div>