<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <div class="Notice_wrap">
    <c:forEach var="board" items="${list}">
      <a href="/board/noticeBoard?Gubun=boardView&seq=${board.seq}">
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
</div>