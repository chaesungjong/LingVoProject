package com.castlebell.lingvo.work.service;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.request.WorkStopReqModify;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;

public interface WorkService {

    /**
     * QRCode 인식 하여 현장 정보 가져오기
     * @param qrCode
     * @param session
     * @param request
     * @return
     */
    WorkSafetyCheck getSiteInfo(HttpSession session, HttpServletRequest request);

    /**
     * 안전예방활동체크 질문 리스트
     * @param qrCode
     * @param session
     * @param request
     * @return
     */
    List<WorkClassMsgListResponse> getWorkClassMsgList(WorkClassMsgListRequest workClassMsgListRequest);

    /**
     * 예방활동체크 
     * @param session
     * @param request
     * @return
     */
    WorkSafetyCheck checkSurvey(HttpSession session, HttpServletRequest request,String gubun,String WorkGubun);

    /**
     * 작업중지 상황별 메시지 리스트 
     * @param HashMap
     * @return
     */
    List<workIssueMsgListResponse> workIssueMsgList(HashMap<String, String> map);

    /**
     * 작업 중지 요청
     * @param HashMap
     * @return
     */
    WorkStopReqModify workStopReqModify(String gubun, String userID, String sitCode, String isuusuGubun, String location, String reqReason, String imgPaths,String state,String ip, String workSeq);
    

}
