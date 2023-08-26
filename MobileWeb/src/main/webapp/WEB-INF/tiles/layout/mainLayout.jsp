<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.castlebell.lingvo.cmm.session.Member" %>
<%@ page import="com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin" %>

<!-- 외부 스크립트 및 리소스 연결 -->
<script src="/js/include/html_meta.js"></script>
<script src="/js/Utility.js"></script>
<script src="/js/base.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<%  
    // 세션에서 사용자 정보 가져오기
    Member member = (Member) session.getAttribute("member");
    RequestLogin autoLogin = (RequestLogin) session.getAttribute("autoLogin");
    String userName = (member != null) ? member.getName() : "";
    String userid = (member != null) ? member.getUserid() : "";
    String userPw = (autoLogin != null) ? autoLogin.getUserpw() : "";
%>

<script>
    // 서버로부터 전달받은 에러 메시지를 확인하고 알림창으로 보여주기
	var message = "${errMsg}";
	if (message !== '') {
		alert(message);
	}
    
    // 사용자 이름과 아이디 변수 선언
    var userName = '<%= userName %>';
    var userid = '<%= userid %>';
    var userName     = '<%= userName %>';
</script>

<!-- 주요 콘텐츠 영역 -->
<main>
    <!-- 페이지의 각 부분을 Tiles 템플릿으로 삽입 -->
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="navibar" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</main>
</body>
</html>