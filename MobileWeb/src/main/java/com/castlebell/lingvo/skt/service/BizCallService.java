package com.castlebell.lingvo.skt.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;

public interface BizCallService {
    
    /**
     * 비즈콜 예약
     * 단순 예약만 하는 API, 실 발신을 위해선 통화 대상자 추가 API 요청 필수
     * 예약은 아직 발신전 상태로 취소(비즈콜 삭제) 가능
     * @return
     */
    HashMap<String, Object> reservation(RequestLogin requestLogin, HttpSession session);
}
