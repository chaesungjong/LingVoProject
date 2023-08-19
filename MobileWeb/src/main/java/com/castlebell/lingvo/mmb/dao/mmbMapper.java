package com.castlebell.lingvo.mmb.dao;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;

/**
 * 회원 정보 관련 매퍼
 */
@Mapper
public interface mmbMapper {
    
    /**
     * 로그인 시도
     * @return
     */
    void memLogin(RequestLogin RequestLogin);

    /**
     * 로그인 정보 가져온다.
     * @return
     */
    Member memUserInfo(Map<String, Object> params);
}
