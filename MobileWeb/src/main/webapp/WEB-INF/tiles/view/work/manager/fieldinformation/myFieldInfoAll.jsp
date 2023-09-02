<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h1">전체보기</div>			
    </div>
    <div class="table_wrap mt30">			
        <div class="table_th name">${category}</div>
        <div class="table_th">총인원</div>
        <div class="table_th">안전활동<br/>완료</div>
        <div class="table_th">작업중지<br/>요청</div>
        <div class="table_th">자세히<br/>보기</div>			
    </div>
    <c:forEach items="${result}" var="data">
        <div class="table_wrap mt10">
            <div class="table_td name">
                <c:choose>
                    <c:when test="${data.siteSubAddr2 == null}">
                        <c:out value="${data.constName}" />
                    </c:when>
                    <c:otherwise>
                        <c:out value="${data.siteSubAddr2}" />
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="table_td"><c:out value="${data.nWork}" /></div>
            <div class="table_td"><c:out value="${data.nSafeEnd}" /></div>
            <div class="table_td"><c:out value="${data.nWorkStopRequest}" /></div>
            <div class="table_td">
                <c:choose>
                    <c:when test="${data.siteSubAddr2 == null}">
                        <a href="/work/manager/fieldinformation/myFieldInfoField?constCode=${data.constCode}">보기</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/work/manager/fieldinformation/myFieldInfoField?siteSubAddr2=${data.siteSubAddr2}">보기</a>
                    </c:otherwise>
                </c:choose>
            </div>			
        </div>
    </c:forEach>
</div>
