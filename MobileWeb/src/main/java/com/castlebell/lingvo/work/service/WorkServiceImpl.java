package com.castlebell.lingvo.work.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.work.dao.WorkMapper;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.request.WorkReviewModify;
import com.castlebell.lingvo.work.dao.domain.request.WorkStopReqModify;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;

@Service
public class WorkServiceImpl implements WorkService{

    // WorkMapper 인터페이스를 통한 DB 작업
    @Autowired
    private  WorkMapper workMapper;

    /**
     * 사이트 정보 조회
     * @param session 세션 정보
     * @param request 요청 객체
     * @return WorkSafetyCheck 사이트 정보
     */
    @Override
    public WorkSafetyCheck getSiteInfo(HttpSession session, HttpServletRequest request) {

        Member member = (Member) session.getAttribute("member");
        String qrCode = request.getParameter("qrCode");
        String userid = member.getUserid();
        String ip = request.getRemoteAddr();

        WorkSafetyCheck workSafetyCheck = new WorkSafetyCheck();
        workSafetyCheck.setGubun("QR_CHECKIN");
        workSafetyCheck.setUserid(userid);
        workSafetyCheck.setQrCode(qrCode);
        workSafetyCheck.setWorkGubun("");
        workSafetyCheck.setWorkClass("");
        workSafetyCheck.setState("");
        workSafetyCheck.setIp(ip);
        workSafetyCheck.setWorkSeq("0");
        workSafetyCheck.setEtcParam1("");

        workSafetyCheck = workMapper.workSafetyCheck(workSafetyCheck);

        return workSafetyCheck;
    }

    /**
     * 작업 클래스 메시지 목록 조회
     * @param workClassMsgListRequest 요청 데이터
     * @return 작업 클래스 메시지 응답 목록
     */
    @Override
    public List<WorkClassMsgListResponse> getWorkClassMsgList(WorkClassMsgListRequest workClassMsgListRequest) {
        return workMapper.getWorkClassMsgList(workClassMsgListRequest);
    }

    /**
     * 설문 확인
     * @param session 세션 정보
     * @param request 요청 객체
     * @param gubun 구분자
     * @param WorkGubun 작업 구분자
     * @return WorkSafetyCheck 설문 확인 정보
     */
    @Override
    public WorkSafetyCheck checkSurvey(HttpSession session, HttpServletRequest request, String gubun, String WorkGubun) {

        Member member = (Member) session.getAttribute("member");
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
        String ip = request.getRemoteAddr(); // 접속자 IP
        String userid = member.getUserid();  // 접속자 ID

        workSafetyCheck.setGubun(gubun);    // QR_CHECKIN
        workSafetyCheck.setWorkGubun(WorkGubun);
        workSafetyCheck.setWorkClass("");
        workSafetyCheck.setIp(ip);
        workSafetyCheck.setUserid(userid);

        workSafetyCheck = workMapper.workSafetyCheck(workSafetyCheck);
        
        return workSafetyCheck;
    }

    /**
     * 작업 이슈 메시지 목록 조회
     * @param map 요청 파라미터 맵
     * @return 작업 이슈 메시지 응답 목록
     */
    @Override
    public List<workIssueMsgListResponse> workIssueMsgList(HashMap<String, String> map) {
        return workMapper.getWorkIssueMsgList(map);
    }

    /**
     * 작업 중지 요청 처리
     * @param map 요청 파라미터 맵
     * @return 작업 이슈 메시지 응답 목록
     */
    @Override
    public WorkStopReqModify workStopReqModify(WorkStopReqModify workStopReqModify) {
        workMapper.workStopReqModify(workStopReqModify);
        return workStopReqModify;
    }

    /**
     * 작업 개선 요청 등록/수정
     * @param workReviewModify
     * @return
     */
    @Override
    public WorkReviewModify workReviewModify(WorkReviewModify workReviewModify){
        workMapper.workReviewModify(workReviewModify);
        return workReviewModify;
    }
}