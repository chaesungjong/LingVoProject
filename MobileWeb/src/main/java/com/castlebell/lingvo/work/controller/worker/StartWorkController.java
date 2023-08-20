package com.castlebell.lingvo.work.controller.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.request.WorkClassMsgListRequest;
import com.castlebell.lingvo.work.dao.domain.response.WorkClassMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;
/**
 * 작업 시작과 관련된 기능들을 제공하는 컨트롤러
 */
@Controller
@RequestMapping("work/worker/start")
public class StartWorkController extends CommonController {
    
    private static final Logger logger = LoggerFactory.getLogger(StartWorkController.class);
    private final WorkService workService;

    @Autowired
    public StartWorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
     * 작업 시작에 필요한 QR코드 인증 화면을 제공한다.
     *
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */
    @RequestMapping(value = "/workQRConfirm", method=RequestMethod.GET)
    public String workQRConfirm(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workQRConfirm 접근");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        // 작업 정보 조회
        WorkSafetyCheck result = workService.getSiteInfo(session, request);
        // if (!"0".equals(result.getErrCode())) {
        //     redirectAttributes.addAttribute("errMsg", result.getErrMsg());
        //     return "redirect:/work/worker/main";
        // }

        model.addAttribute("siteAddress", result.getSiteAddress());
        model.addAttribute("siteName", result.getSiteName());
        model.addAttribute("constName", result.getConstName());
        model.addAttribute("companyName", result.getCompanyName());
        model.addAttribute("workType", result.getWorkType());
        
        session.setAttribute("WorkSafetyCheck", result); 

        return StartWorkMapping + "/workQRConfirm";
    }

    /**
     * 사용자가 시작할 작업 목록을 보여준다.
     *
     * @return 페이지 뷰 이름
     */
    @RequestMapping(value = "/workedList", method=RequestMethod.GET)
    public String workedList(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workedList 접근");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        Member member = (Member) session.getAttribute("member");
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

        model.addAttribute("name", member.getName());
        model.addAttribute("siteName", workSafetyCheck.getSiteName());
        model.addAttribute("constName", workSafetyCheck.getConstName());
        model.addAttribute("companyName", workSafetyCheck.getCompanyName());
        model.addAttribute("workType", workSafetyCheck.getWorkType());

        return StartWorkMapping + "/workedList";
    }

    /**
     * 작업에 따른 안전 점검 단계별 매뉴얼을 보여준다.
     *
     * @return 페이지 뷰 이름
     */
    @RequestMapping(value = "/workCheckStep", method=RequestMethod.GET)
    public String workCheckStep(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workCheckStep 접근");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        WorkClassMsgListRequest workClassMsgListRequest = new WorkClassMsgListRequest();
        workClassMsgListRequest.setWorkGubun(request.getParameter("workGubun"));
        workClassMsgListRequest.setWorkType(request.getParameter("workType"));

        List<WorkClassMsgListResponse> workClassMsgList = workService.getWorkClassMsgList(workClassMsgListRequest);

        model.addAttribute("messageList", workClassMsgList);			

        return StartWorkMapping + "/workCheckStep";
    }

    /**
     * 안전 점검의 완료 여부와 결과를 전송하고 확인한다.
     *
     * @return 페이지 뷰 이름 또는 리디렉션 경로
     */
    @RequestMapping(value = "/workCheckStepConfirm", method=RequestMethod.GET)
    public String workCheckStepConfirm(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workCheckStepConfirm 접근");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        String workGubun = StringUtil.objectToString(request.getParameter("workGubun"));
        WorkSafetyCheck result = workService.checkSurvey(session, request, "SURVEY_END", workGubun);

        // if (result.getErrCode() != null && !"0".equals(result.getErrCode())) {
        //     redirectAttributes.addAttribute("errMsg", result.getErrMsg());
        //     return "redirect:/work/worker/main";
        //}

        return StartWorkMapping + "/workCheckStepConfirm";
    }

    /**
     * 작업 시작에 필요한 ARS 인증을 요청한다.
     *
     * @return 응답 엔터티(인증 실패/성공 정보 포함)
     */
    @RequestMapping(value = "workStartARSCall", method=RequestMethod.GET)
    public ResponseEntity<Object> workStartARSCall(HttpServletRequest request, HttpSession session) {
        logger.debug("workStartARSCall 접근");
        
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("errMsg", "ARS 인증 요청을 실패 하였습니다.");

        if (!checkLogin(session)) { 
            return new ResponseEntity<>(responseMap, HttpStatus.OK); 
        }

        WorkSafetyCheck result = workService.checkSurvey(session, request, "AICALL_START", "N");

        if (result.getErrCode() != null && !"0".equals(result.getErrCode())) {
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        
        responseMap.put("errCode", result.getErrCode());
        responseMap.put("errMsg", result.getErrMsg());

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}