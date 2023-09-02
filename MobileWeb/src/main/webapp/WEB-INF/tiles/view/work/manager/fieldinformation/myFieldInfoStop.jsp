<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h1">${title}</div>			
    </div>

    <div class="table_wrap mt30">			
        <div class="table_th name">작업자</div>
        <div class="table_th">작업중지 요청 사유</div>	
    </div>

    <c:forEach items="${result}" var="data">
        <div class="table_wrap mt10">
            <div class="table_td name">${data.name}</div>
            <div class="table_td">${data.reqReason}</div>
        </div>
    </c:forEach>

    <div class="btn_strock mt30">
        <a  href="/work/manager/fieldinformation/fieldinformationlist" class="btn_ok_s">확인</a>
    </div>
</div>