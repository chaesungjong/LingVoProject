package com.castlebell.lingvo.work.controller.worker;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.cmm.session.WorkSafetyCheck;
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.request.WorkStopReqModify;
import com.castlebell.lingvo.work.dao.domain.response.workIssueMsgListResponse;
import com.castlebell.lingvo.work.service.WorkService;

/**
 * @since 2023. 8. 12.
 * @version 1.0
 * <pre>
 * 작업 종료 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/worker/end")
public class EndWorkController extends CommonController {
    
    private static final Logger logger = LoggerFactory.getLogger(EndWorkController.class);
    private final WorkService workService;

    @Autowired
    public EndWorkController(WorkService workService) {
        this.workService = workService;
    }

    /**
	 * 작업 후기 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReview", method=RequestMethod.GET)
	public String workReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(!checkLogin(session, redirectAttributes)){ return "redirect:/mmb/login"; }
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		// if(workSafetyCheck == null) {
		// 	redirectAttributes.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
		// 	return "redirect:/work/worker/main";
		// }
	    return EndWorkMapping + "/workReview";
	}

    /**
	 * 작업 완료 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEnd", method=RequestMethod.GET)
	public String workReviewEnd(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(!checkLogin(session, redirectAttributes)) { return "redirect:/mmb/login"; }
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		// if(workSafetyCheck == null) {
		// 	redirectAttributes.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
		// 	return "redirect:/work/worker/main";
		// }
		session.setAttribute("WorkSafetyCheck", null);
	    return EndWorkMapping + "/workReviewEnd";
	}

    /**
	 * 작업 후기 개선 사항 요청 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workImprovementReview", method=RequestMethod.GET)
	public String workImprovementReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(!checkLogin(session, redirectAttributes)) { return "redirect:/mmb/login"; }
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		// if(workSafetyCheck == null) {
		// 	redirectAttributes.addAttribute("errMsg", "현재 진행중인 작업이 없습니다. ");
		// 	return "redirect:/work/worker/main";
		// }
	    return EndWorkMapping + "/workImprovementReview";
	}

    /**
	 * 작업 후기 개선 사항 관련 문제 요청 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewissues", method=RequestMethod.GET)
	public String workReviewissues(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(!checkLogin(session, redirectAttributes)) { return "redirect:/mmb/login"; }
		String issueGubun = StringUtil.objectToString(request.getParameter("issueGubun"));
		String etcParam1 = StringUtil.objectToString(request.getParameter("etcParam1"));
		HashMap<String, String> map = new HashMap<>();
		map.put("issueGubun", issueGubun);
		map.put("etcParam1", etcParam1);
		List<workIssueMsgListResponse> result = workService.workIssueMsgList(map);
		if(result != null && !result.isEmpty()) model.addAttribute("result", result);			//작업중지 상황별 메시지 리스트
	    return EndWorkMapping + "/workReviewissues";
	}

    /**
	 * 작업 후기 개선 사항 요청의 사진 첨부 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEndPicturePlus", method=RequestMethod.GET)
	public String workReviewEndPicturePlus(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	    return EndWorkMapping + "/workReviewEndPicturePlus";
	}

    /**
	 * 작업 후기 개선 사항 요청의 사진 첨부 상세 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEndPlusDitail", method=RequestMethod.GET)
	public String workReviewEndPlusDitail(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(!checkLogin(session, redirectAttributes)) { return "redirect:/mmb/login"; }
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		Member member = (Member) session.getAttribute("member");
		// if(workSafetyCheck == null) {
		// 	redirectAttributes.addAttribute("errMsg", "잘못 된 접근 입니다.");
		// 	return "redirect:/work/worker/main";
		// }
		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장
		model.addAttribute("location", workSafetyCheck.getSiteAddress());			//위치
	    return EndWorkMapping + "/workReviewEndPlusDitail";
	}

    /**
	 * 작업 후기 개선 사항 요청의 사진 첨부 상세 내용 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEndPicturePlusDitail", method=RequestMethod.GET)
	public String workReviewEndPicturePlusDitail(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if(!checkLogin(session, redirectAttributes)) { return "redirect:/mmb/login"; }
		WorkSafetyCheck workSafetyCheck =(WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
		// if(workSafetyCheck == null) {
		// 	redirectAttributes.addAttribute("errMsg", "잘못 된 접근 입니다.");
		// 	return "redirect:/work/worker/main";
		// }
		Member member = (Member) session.getAttribute("member");
		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", workSafetyCheck.getSiteName());			//현장
		model.addAttribute("location", workSafetyCheck.getSiteAddress());			//위치
	    return EndWorkMapping + "/workReviewEndPicturePlusDitail";
	}

    /**
	 * 작업 중지 요청 완료 처리
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/sendWorkReview", method=RequestMethod.POST)
	public String sendWorkReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

		if(!checkLogin(session, redirectAttributes)) { return "/mmb/login"; }
		
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");
        Member member = (Member) session.getAttribute("member");

        String userID = member.getUserid(); // 사용자 ID
        String siteCode = member.getsiteCode(); // 현장 코드
        String issueGubun = StringUtil.objectToString(request.getParameter("issueGubun")); // 이슈 구분
        String location = StringUtil.objectToString(request.getParameter("location")); // 현장 위치
        String reqReason = StringUtil.objectToString(request.getParameter("reqReason")); // 요청 사유
        String imgPaths = StringUtil.objectToString(request.getParameter("imgPaths")); // 사진 경로
        String ip = request.getRemoteAddr(); // 접속자 IP
        String workSeq = StringUtil.objectToString(workSafetyCheck.getWorkSeq()); // 작업 순번

        WorkStopReqModify result = workService.workStopReqModify("regist",userID,siteCode,issueGubun,location,reqReason,imgPaths,"Y",ip,workSeq);

        if(result != null){
            String errMsg = result.getErrMsg();
            if(result.getRetVal() == 0){
                errMsg = "감사합니다.<br/>개선 요청 사항이<br/>등록되었습니다.<br/>현장 확인 후<br/><span class='txt_point'>즉시 조치하도록 하겠습니다.</span>";
            }
            model.addAttribute("Msg", errMsg);
        }
		
	    return EndWorkMapping + "/sendWorkReview";
	}

}