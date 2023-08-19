<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="container">
	<div class="workStop_wrap">			
		<div class="workStop_title" id="title"></div>
	</div>
	<div class="today_wrap">
		<c:forEach items="${result}" var="workIssueMsgListResponse" varStatus="status">		
			<div class="workStop_list">
				<div class="issue_name">${workIssueMsgListResponse.issueDetail}</div>
				<div class="select">
					<input type="radio" name="checkboxValues${status.index * 2 + 1}" id="inlineCheckbox${status.index * 2 + 1}" value="${workIssueMsgListResponse.issueDetail}${workIssueMsgListResponse.choice1}"><label for="inlineCheckbox${status.index * 2 + 1}">${workIssueMsgListResponse.choice1}</label>
					<c:if test="${not empty workIssueMsgListResponse.choice2}">
						<input type="radio" name="checkboxValues${status.index * 2 + 1}" id="inlineCheckbox${status.index * 2 + 2}" value="${workIssueMsgListResponse.issueDetail}${workIssueMsgListResponse.choice2}"><label for="inlineCheckbox${status.index * 2 + 2}">${workIssueMsgListResponse.choice2}</label>
					</c:if>
				</div>
			</div>
		</c:forEach>
		<div class="btn_strock mt30"><a id="next" href="#" class="btn_ok_s">확인</a></div>
	</div>
</div>
<script src="/js/work/worker/stop/stopMessageList.js"></script>