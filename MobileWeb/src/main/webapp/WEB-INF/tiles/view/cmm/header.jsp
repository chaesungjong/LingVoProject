<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="currentURL" value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:choose>
    <c:when test="${fn:contains(currentURL, 'worker/start')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">금일 작업 시작</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>
    <c:when test="${fn:contains(currentURL, 'worker/stop')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">작업 중지 요청</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>
    <c:when test="${fn:contains(currentURL, 'worker/end')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">작업 후기</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>
    <c:when test="${fn:contains(currentURL, 'cs/emrContact')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">비상 연락망</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>
    <c:when test="${fn:contains(currentURL, 'board/noticeBoard')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">공지사항</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>    
    <c:when test="${fn:contains(currentURL, 'board/videoBoard')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">십짱TV</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>  
    <c:when test="${fn:contains(currentURL, 'cs/faq')}">
      <div id="headers">
        <div class="logo"><a href="javascript:history.back()"><img src="/assets/icon_arrow_back.png" alt="뒤로" ></a></div>
        <div class="title">FAQ</div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:when>
    <c:when test="${fn:contains(currentURL, 'mmb/pwdInit')}">
      <div id="headers">
        <div class="logo"></div>
        <div class="title">비밀번호 재설정</div>
        <div class="menu_more"></div>	
      </div>
    </c:when>
    <c:otherwise>
      <div id="headers">
        <div class="logo"><a href="/work/worker/main"><img src="/assets/logo.png" alt="링보" ></a></div>
        <div class="menu_more"><a href="javascript:openPop()"><img src="/assets/icon_list.png" alt="더보기"></a></div>	
      </div>
    </c:otherwise>
</c:choose>