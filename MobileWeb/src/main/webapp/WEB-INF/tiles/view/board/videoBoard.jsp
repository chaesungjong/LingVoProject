<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <!-- <div class="NoticeDetail_wrap">	
    <a href="">	
    <div class="Detail_view">
      <div class="title_Detail">십짱TV ! 구독 좋아요 부탁드려요.</div>
    </div>
    </a>	
  </div> -->
  <div class="Notice_wrap">
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