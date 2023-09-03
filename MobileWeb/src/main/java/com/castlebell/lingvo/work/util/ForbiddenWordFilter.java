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
         "DROP TABLE",  "UNION", "SELECT", "INSERT", "UPDATE", "DELETE"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
        throws ServletException, IOException {
        
        // ContentCachingRequestWrapper로 요청을 래핑합니다.
        ContentCachingRequestWrapper cachingRequest = new ContentCachingRequestWrapper(request);

        filterChain.doFilter(cachingRequest, response);  // 필터 체인을 계속 진행

        String body = getRequestBody(cachingRequest);

        for (String word : FORBIDDEN_WORDS) {
            //if (body.toLowerCase().contains(word)) {
            if(body.toLowerCase().contains(word.toLowerCase()) && body.length() > 0 ) {
                
                response.sendRedirect(request.getContextPath() + "/mmb/login");
                
                return;
            }
        }
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        return new String(wrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
    }
}