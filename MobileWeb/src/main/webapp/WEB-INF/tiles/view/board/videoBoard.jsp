<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		


  <div class="NoticeDetail_wrap">	
    <a href="">	
    <div class="Detail_view">
      <div class="title_Detail">십짱TV ! 구독 좋아요 부탁드리요.</div>
    </div>
    </a>	
  </div>

  <div class="Notice_wrap">
    <c:forEach var="board" items="${list}">
      ${board.url}
      <a href="${board.url}">
        <div class="list">
          <div class="title"> 
            <c:choose>
            <c:when test="${ board.importantYN == 'Y'}">
                [<span>중요</span>]${board.title}</div>
            </c:when>
            <c:otherwise>
              ${board.title}</div>
            </c:otherwise>
          </c:choose>
          <div class="date">${board.regdate}</div>
        </div>
      </a>
    </c:forEach>			
  </div>

  <!-- <div class="info_wrap">			
    <div class="txt_h1">십짱TV ! 구독 좋아요 부탁드리요.</div>
    <div class="txt_h2 mb30">실제 현장과 다른 경우 고객센터 1234-1111로 문의 바랍니다</div>
  </div>

  <div class="today_wrap mt30">		    
    <c:forEach var="board" items="${list}">
      <div class="today_info">
        <div class="today_td">
          <iframe width="640" height="360" src="${board.url}" frameborder="0" allowfullscreen></iframe>
        </div>
        <div class="today_th">
          ${board.title}
          ${board.regdate}
        </div>
      </div>
    </c:forEach>	
  </div> -->


</div>