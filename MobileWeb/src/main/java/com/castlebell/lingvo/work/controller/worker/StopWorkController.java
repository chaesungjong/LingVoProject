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
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;

/**
 * 작업 중단과 관련된 기능들을 제공하는 컨트롤러
 */
@Controller
@RequestMapping("work/worker/stop")
public class StopWorkController extends CommonController{
    
    private static final Logger logger = LoggerFactory.getLogger(StopWorkController.class);
    private final WorkService workService;

    @Autowired
    public StopWorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
     * 사용자가 중단하려는 작업 목록을 보여준다.
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */   
    @RequestMapping(value = "/requestStopWorkList", method=RequestMethod.GET)
    public String requestStopWorkList(HttpServletRequest request, Model model ,HttpSession session ,RedirectAttributes redirectAttributes) {
        logger.debug("requestStopWorkList 진입");

        // 로그인 확인
        if(!checkLogin(session, redirectAttributes)){ 
            return "redirect:/mmb/login"; 
        }

        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
        // if(workSafetyCheck == null){
        //     redirectAttributes.addAttribute("errMsg", "현재 작업중이지 않습니다.");
        //     return "redirect:/work/worker/main";
        // }
        return StopWorkMapping + "/requestStopWorkList";
    }

    /**
     * 사용자가 중단하려는 작업의 사유를 입력한다.
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */
    @RequestMapping(value = "/stopMessageList", method=RequestMethod.GET)
    public String stopMessageList(HttpServletRequest request, Model model ,HttpSession session,RedirectAttributes redirectAttributes) {
        logger.debug("stopMessageList 진입");

        // 로그인 확인
        if(!checkLogin(session, redirectAttributes)){ 
            return "redirect:/mmb/login"; 
        }

        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
        // if(workSafetyCheck == null){
        //     redirectAttributes.addAttribute("errMsg", "현재 작업중이지 않습니다.");
        //     return "redirect:/work/worker/main";
        // }

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
        
        // 로그인 확인
        if(!checkLogin(session, redirectAttributes)){ 
            return "redirect:/mmb/login"; 
        }
        
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
        // if(workSafetyCheck == null){
        //     redirectAttributes.addAttribute("errMsg", "현재 작업중이지 않습니다.");
        //     return "redirect:/work/worker/main";
        // }

        Member member = (Member) session.getAttribute("member");

        // 작업 중단 요청 상세 내용 설정
        model.addAttribute("name", member.getName());    //이름
        model.addAttribute("siteName", workSafetyCheck.getSiteName());   //현장 이름
        model.addAttribute("location", workSafetyCheck.getSiteAddress());   //현장 위치
        model.addAttribute("constName", workSafetyCheck.getConstName());    //시공사 이름
        
        return StopWorkMapping + "/requestPicturePlusDitail";
    }

    /**
     * 작업 중단 요청을 완료하고 그 결과를 사용자에게 보여준다.
     * @return 페이지 뷰 이름
     */
    @RequestMapping(value = "/requestPictureComfirm", method=RequestMethod.POST)
    public String requestPictureComfirm(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("requestPictureComfirm 진입");

        // 로그인 확인
        if(!checkLogin(session, redirectAttributes)){ 
            return "redirect:/mmb/login"; 
        }

        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
        Member member = (Member) session.getAttribute("member");

        String userID = member.getUserid(); // 사용자 ID
        String siteCode = member.getsiteCode(); // 현장 코드
        String issueGubun = StringUtil.objectToString(request.getParameter("issueGubun")); // 이슈 구분
        String location = StringUtil.objectToString(request.getParameter("location")); // 현장 위치
        String reqReason = StringUtil.objectToString(request.getParameter("reqReason")); // 요청 사유
        String imgPaths = StringUtil.objectToString(request.getParameter("imgPaths")); // 사진 경로
        String state = StringUtil.objectToString(request.getParameter("state")); // 상태
        String ip = request.getRemoteAddr(); // 접속자 IP
        String workSeq = StringUtil.objectToString(request.getParameter("workSeq")); // 작업 순번


        //List<workIssueMsgListResponse> result = workService.RequestToEndTheWork("regist",userID,siteCode,issueGubun,location,reqReason,imgPaths,state,workSeq);
        

        // 작업 중단 요청에 필요한 데이터 추출 및 처리 과정 (현재 로직에는 처리 로직이 구현되지 않았음)

        return StopWorkMapping + "/requestPictureComfirm";
    }
}