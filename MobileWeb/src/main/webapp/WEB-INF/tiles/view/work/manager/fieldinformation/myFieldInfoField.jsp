<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h1"><span>전체보기</span> > 현장명</div>			
    </div>

    <div class="table_wrap mt30">			
        <div class="table_th name">현장명</div>
        <div class="table_th">총인원</div>
        <div class="table_th">안전활동<br/>완료</div>
        <div class="table_th">작업중지<br/>요청</div>
        <div class="table_th">자세히<br/>보기</div>			
    </div>

    <c:forEach items="${result}" var="data">
        <div class="table_wrap mt10">
            <div class="table_td name"><a href="/work/manager/fieldinformation/myFieldInfoCompany">${data.siteName}</a></div>
            <div class="table_td"><c:out value="${data.nWork}" /></div>
            <div class="table_td"><c:out value="${data.nSafeEnd}" /></div>
            <div class="table_td"><c:out value="${data.nWorkStopRequest}" /></div>
            <div class="table_td"><a href="/work/manager/fieldinformation/myFieldInfoCompany">보기</a></div>			
        </div>
    </c:forEach>

    <div class="table_wrap mt10">			
        <div class="table_td name bold">합계</div>
        <div class="table_td bold">500</div>
        <div class="table_td bold">400</div>
        <div class="table_td bold">5</div>
        <div class="table_td"><a href="/work/manager/fieldinformation/myFieldInfoCompany">보기</a></div>			
    </div>
</div>