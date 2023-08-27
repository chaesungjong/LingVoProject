<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="currentURL" value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:choose>
    <c:when test="${fn:contains(currentURL, 'manager/fieldinformation')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">MY 현장 정보</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>
    <c:otherwise>
      <div id="headers">
        <div class="logo"><a href="/work/manager/main"><img src="/assets/admin/logo.png" alt="링보" ></a></div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/admin/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:otherwise>
</c:choose>