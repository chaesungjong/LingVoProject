<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
    <div class="info_wrap">			
        <div class="txt_h1">${title}</div>			
    </div>

    <div class="table_wrap mt30">			
        <div class="table_th name">일시</div>
        <div class="table_th name">현장명</div>
        <div class="table_th name">이름</div>
        <div class="table_th name">시유</div>	
    </div>

    <c:forEach var="item" items="${result}">
        <div class="table_wrap">			
            <div class="table_td">${item.regdate}</div>
            <div class="table_td">${item.siteName}</div>
            <div class="table_td">${item.name}</div>
            <div class="table_td">${item.reqReason}</div>	
        </div>
    </c:forEach>
</div>