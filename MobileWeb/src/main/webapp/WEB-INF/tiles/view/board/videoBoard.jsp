<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <div class="Notice_wrap">
    <div class="info_wrap">			
      <div class="txt_h1">대한민국 최초의 <br>
        현장 근로자를 위한 방송
        </div>
      <div class="txt_h2 mb30"></div>
    </div>
    <c:forEach var="board" items="${list}">
      <div class="list">     
        <a href="${board.url}" target="_blank">
          <img src="${board.imgPaths}" width="50%" style="display:inline-block; vertical-align:middle;">
          <span style="display:inline-block; vertical-align:middle;">${board.title}<br><br>${board.regdate}</span>
        </a>
      </div>
    </c:forEach>			
  </div>
</div>