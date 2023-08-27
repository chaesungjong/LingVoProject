package com.castlebell.lingvo.work.controller.worker;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.request.WorkStopReqModify;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;

/**
 * 작업 중단과 관련된 기능들을 제공하는 컨트롤러
 */
@Controller
@RequestMapping("work/worker/stop")
public class StopWorkController extends CommonController{
    
    @Autowired
    private  WorkService workService;
    private static final Logger logger = LoggerFactory.getLogger(StopWorkController.class);


    /**
     * 사용자가 중단하려는 작업 목록을 보여준다.
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */   
    @RequestMapping(value = "/requestStopWorkList", method=RequestMethod.GET)
    public String requestStopWorkList(HttpServletRequest request, Model model ,HttpSession session ,RedirectAttributes redirectAttributes) {
        logger.debug("requestStopWorkList 진입");

        if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

        return StopWorkMapping + "/requestStopWorkList";
    }

    /**
     * 사용자가 중단하려는 작업의 사유를 입력한다.
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */
    @RequestMapping(value = "/stopMessageList", method=RequestMethod.GET)
    public String stopMessageList(HttpServletRequest request, Model model ,HttpSession session,RedirectAttributes redirectAttributes) {
        logger.debug("stopMessageList 진입");

        if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

        String issueGubun = StringUtil.objectToString(request.getParameter("issueGubun"));
        String etcParam1  = StringUtil.objectToString(request.getParameter("etcParam1"));

        HashMap<String, String> map = new HashMap<>();
        map.put("issueGubun", issueGubun);
        map.put("etcParam1", etcParam1);

        List<workIssueMsgListResponse> result = workService.workIssueMsgList(map);
        if(result != null && !result.isEmpty()) 
            model.addAttribute("result", result);			

        return StopWorkMapping + "/stopMessageList";
    }

    /**
     * 사용자가 중단 요청을 위한 사진을 첨부한다.
     * @return 페이지 뷰 이름
     */
    @RequestMapping(value = "/requestPicturePlus", method=RequestMethod.GET)
    public String requestPicturePlus(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
        return StopWorkMapping + "/requestPicturePlus";
    }

    /**
     * 사용자가 첨부한 중단 요청 사진의 상세 내용을 보여준다.
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */
    @RequestMapping(value = "/requestPicturePlusDitail", method=RequestMethod.GET)
    public String requestPicturePlusDitail(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("requestPicturePlusDitail 진입");
        
        if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

        Member member = (Member) session.getAttribute("member");

        // 작업 중단 요청 상세 내용 설정
        model.addAttribute("name", member.getName());               //이름
        model.addAttribute("siteName", member.getSiteName());       //현장 이름
        model.addAttribute("location", member.getSiteAddress());    //현장 위치
        model.addAttribute("constName", member.getConstName());     //시공사 이름
        
        return StopWorkMapping + "/requestPicturePlusDitail";
    }

    /**
     * 작업 중단 요청을 처리하고 그 결과를 사용자에게 반환합니다.
     *
     * @return 페이지 뷰 이름
     */
    @RequestMapping(value = "/requestPictureComfirm", method = RequestMethod.POST)
    public String requestPictureComfirm(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        
        if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

        // 세션에서 안전 검사와 회원 정보 추출
        Member member = (Member) session.getAttribute("member");

        // 작업 중단 요청 정보 객체 초기화 및 설정
        WorkStopReqModify workStopReqModify = new WorkStopReqModify();
        workStopReqModify.setGubun("regist");
        workStopReqModify.setUserid(StringUtil.objectToString(member.getUserid()));
        workStopReqModify.setSiteCode(StringUtil.objectToString(member.getsiteCode()));
        workStopReqModify.setIssueGubun(StringUtil.objectToString(request.getParameter("issueGubun")));
        workStopReqModify.setLocation(StringUtil.objectToString(""));
        workStopReqModify.setReqReason(StringUtil.objectToString(request.getParameter("reqReason")));
        workStopReqModify.setImgPaths(StringUtil.objectToString(request.getParameter("imgPaths")));
        workStopReqModify.setState("Y");
        workStopReqModify.setIp(StringUtil.objectToString(request.getRemoteAddr()));
        workStopReqModify.setWsrSeq(StringUtil.objectToString(""));

        // 작업 중단 요청 정보를 서비스로 전달 및 처리
        workService.workStopReqModify(workStopReqModify);

        // 처리 결과에 따른 메시지 설정
        if (workStopReqModify != null) {
            String errMsg = workStopReqModify.getErrMsg();
            if (workStopReqModify.getRetVal() == 0) {
                errMsg = "관리자가 빠른 시간내에<br>현장을 조치 하도록 하겠습니다.<br> 안전 조치가 완료될때까지<br>작업을 대기하시길 바랍니다.";
            }
            model.addAttribute("Msg", errMsg);
        }

        // 뷰 페이지로 리다이렉트
        return StopWorkMapping + "/requestPictureComfirm";
    }
}