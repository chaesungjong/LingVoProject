<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <div class="Contact_wrap">	
  <c:forEach items="${list}" var="emergencyInfo">
    <a href="tel:${emergencyInfo.hpno}">
			<div class="list">
				<div class="name"><img src="/assets/icon_photo_01.png" alt="">${emergencyInfo.companyName}</div>
				<div class="icon_call"><img src="/assets/icon_calling.png" alt="전화걸기"></div>
			</div>
    </a>
  </c:forEach>
  </div>
</div>