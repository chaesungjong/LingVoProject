<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">		
  <div class="NoticeDetail_wrap">		
    <c:forEach var="board" items="${list}">
      <div class="Detail_view">
				<div class="title_Detail">${board.title}</div>
				<div class="date_Detail">${board.regdate}</div>
			</div>
      <div class="notice_contents">${board.content}</div>
    </c:forEach>
  </div>
</div>