package com.castlebell.lingvo.mmb.service;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;

public interface MemberService {

    /**
     * 로그인 처리
     * @return
     */
    HashMap<String, Object> loginProcess(RequestLogin requestLogin, HttpSession session);

}
