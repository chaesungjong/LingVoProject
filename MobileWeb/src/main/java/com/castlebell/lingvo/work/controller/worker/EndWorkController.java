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
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.dao.domain.request.WorkReviewModify;
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

        if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

	    return EndWorkMapping + "/workReview";
	}

    /**
	 * 작업 완료 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEnd", method=RequestMethod.GET)
	public String workReviewEnd(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

		session.setAttribute("WorkSafetyCheck", null);
	    return EndWorkMapping + "/workReviewEnd";
	}

    /**
	 * 작업 후기 개선 사항 요청 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workImprovementReview", method=RequestMethod.GET)
	public String workImprovementReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

	    return EndWorkMapping + "/workImprovementReview";
	}

    /**
	 * 작업 후기 개선 사항 관련 문제 요청 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewissues", method=RequestMethod.GET)
	public String workReviewissues(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

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

		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }
		
	    return EndWorkMapping + "/workReviewEndPicturePlus";
	}

    /**
	 * 작업 후기 개선 사항 요청의 사진 첨부 상세 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEndPlusDitail", method=RequestMethod.GET)
	public String workReviewEndPlusDitail(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }
		
		Member member = (Member) session.getAttribute("member");
		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", member.getSiteName());						//현장
		model.addAttribute("location", member.getSiteAddress());					//위치
	    return EndWorkMapping + "/workReviewEndPlusDitail";
	}

    /**
	 * 작업 후기 개선 사항 요청의 사진 첨부 상세 내용 페이지
	 * @return 페이지 경로
	 */
    @RequestMapping(value = "/workReviewEndPicturePlusDitail", method=RequestMethod.GET)
	public String workReviewEndPicturePlusDitail(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }
		
		Member member = (Member) session.getAttribute("member");
		model.addAttribute("name", member.getName());								//이름
		model.addAttribute("siteName", member.getSiteName());						//현장
		model.addAttribute("location", member.getSiteAddress());					//위치
	    return EndWorkMapping + "/workReviewEndPicturePlusDitail";
	}

	/**
	 * 작업 중지 후의 리뷰 요청 처리
	 * @return 페이지 경로
	 */
	@RequestMapping(value = "/sendWorkReview", method = RequestMethod.POST)
	public String sendWorkReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		
		// 로그인 상태 확인
		if(checkTodayWork(session, redirectAttributes) == false){
            return "redirect:/work/worker/main";
        }

		// 세션에서 회원 정보와 안전 검사 정보 추출
		Member member = (Member) session.getAttribute("member");

		// 리뷰 수정 정보 객체 초기화 및 설정
		WorkReviewModify workReviewModify = new WorkReviewModify();
		workReviewModify.setGubun("regist");
		workReviewModify.setUserid(StringUtil.objectToString(member.getUserid()));
		workReviewModify.setSiteCode(StringUtil.objectToString(member.getsiteCode()));
		workReviewModify.setReviewClass("NO");
		workReviewModify.setReviewGubun(StringUtil.objectToString(request.getParameter("issueGubun")));
		workReviewModify.setLocation(StringUtil.objectToString(request.getParameter("location")));
		workReviewModify.setContent(StringUtil.objectToString(request.getParameter("reqReason")));
		workReviewModify.setImgPaths(StringUtil.objectToString(request.getParameter("imgPaths")));
		workReviewModify.setState("Y");
		workReviewModify.setIp(StringUtil.objectToString(request.getRemoteAddr()));
		workReviewModify.setWrSeq(StringUtil.objectToString(""));

		// 리뷰 수정 정보를 서비스로 전달 및 처리
		workService.workReviewModify(workReviewModify);

		// 처리 결과에 따른 메시지 설정
		if (workReviewModify != null) {
			String errMsg = workReviewModify.getErrMsg();
			if (workReviewModify.getRetVal() == 0) {
				errMsg = "감사합니다.<br/>개선 요청 사항이<br/>등록되었습니다.<br/>현장 확인 후<br/><span class='txt_point'>즉시 조치하도록 하겠습니다.</span>";
			}
			model.addAttribute("Msg", errMsg);
		}
		
		// 결과 페이지로 리다이렉트
		return EndWorkMapping + "/sendWorkReview";
	}

}