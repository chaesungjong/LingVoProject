package com.castlebell.lingvo.work.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Component
public class ForbiddenWordFilter extends OncePerRequestFilter {

    private static final List<String> FORBIDDEN_WORDS = Arrays.asList(
        // SQL 인젝션
        "OR '1'='1'", "DROP TABLE", "--", ";", "UNION", "SELECT", "INSERT", "UPDATE", "DELETE", 
    
        // 크로스 사이트 스크립팅(XSS)
        "<script>", "alert(", "document.cookie", "window.location", "<img", "onload", "onerror",
    
        // 시스템 명령어 실행
        ";", "&&", "|", ">", "rm ", "shutdown ", "echo", "ls ", "cat ", 
    
        // 디렉토리 탐색(Directory Traversal)
        "../", "..\\", "%2e%2e/", "%2e%2e\\"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
        throws ServletException, IOException {
        
        // ContentCachingRequestWrapper로 요청을 래핑합니다.
        ContentCachingRequestWrapper cachingRequest = new ContentCachingRequestWrapper(request);

        filterChain.doFilter(cachingRequest, response);  // 필터 체인을 계속 진행

        String body = getRequestBody(cachingRequest);

        for (String word : FORBIDDEN_WORDS) {
            if (body.contains(word)) {
                response.sendRedirect("/errorPage");
                return;
            }
        }
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        return new String(wrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
    }
}