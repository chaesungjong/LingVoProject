<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <div class="Contact_wrap">	
  <c:forEach items="${list}" var="emergencyInfo">

    <c:choose>
      <c:when test="${not empty emergencyInfo.hpno}">
        <a href="tel:${emergencyInfo.hpno}">
          <div class="list">
            <div class="name"><img src="/assets/icon_photo_01.png" alt="">${emergencyInfo.name}</div>
            <div class="icon_call"><img src="/assets/icon_calling.png" alt="전화걸기"></div>
          </div>
        </a>       
      </c:when>
      <c:otherwise>
        <div class="list">
          <div class="name"><img src="/assets/icon_main07.png" alt="">${emergencyInfo.name}</div>
        </div>     
      </c:otherwise>
    </c:choose>
    
  </c:forEach>
  </div>
</div>