package com.castlebell.lingvo.work.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;

/**
 * 작업 관련 프로시저 매퍼
 */
@Mapper
public interface WorkMapper {
    

    /**
     * 금일 작업시작하기
     * @return
     */
    
    WorkSafetyCheck workSafetyCheck(WorkSafetyCheck workSafetyCheck);

    /**
     * 안전예방활동체크 질문 리스트
     * @return
     */
    List<WorkClassMsgListResponse> getWorkClassMsgList(WorkClassMsgListRequest workClassMsgListRequest);

    /**
     * 금일 작업시작하기
     * @return
     */
    WorkSafetyCheck checkSurvey(WorkSafetyCheck workSafetyCheck);

    /**
     * 작업중지 상황별 메시지 리스트
     * @return
     */
    List<workIssueMsgListResponse> getWorkIssueMsgList(HashMap<String, String> map);
}
