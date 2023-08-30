package com.castlebell.lingvo.cmm;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;
import com.castlebell.lingvo.mmb.service.MemberService;

@Controller
public class CommonController {

	protected final String StartWorkMapping = "work/worker/start";
	protected final String StopWorkMapping = "work/worker/stop";
	protected final String EndWorkMapping = "work/worker/end";
	protected final String IrrationalityMapping = "work/manager/irrationality";
	protected final String FieldInformationMapping = "work/manager/fieldinformation";
	protected final String StopMapping = "work/manager/stop";

	@Autowired
	private MemberService memberService;

	/**
	 * 최초 화면
	 * @return
	 */
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String main() {
	    return "mmb/login";
	}

	/**
	 * 로그인 상태 체크
	 */   
	protected boolean checkLogin( HttpSession session ,RedirectAttributes redirectAttributes ) {
		
		Member member = (Member) session.getAttribute("member");

		if(member == null){
			redirectAttributes.addAttribute("errMsg", "잘못 된 접근 입니다.");
			return false;
		}
		
	    return true;
	}

	/**
	 * 로그인 상태 체크
	 */   
	protected boolean checkLogin(HttpSession session) {
		
		Member member = (Member) session.getAttribute("member");

		if(member == null){
			return false;
		}
		
	    return true;
	}

	/**
	 * 사용자 로그인 처리를 위한 메서드.
	 * 
	 * @param userid 사용자 ID
	 * @param pwd 사용자 비밀번호
	 * @param userIP 사용자 IP 주소
	 * @param clientType 클라이언트 타입
	 * @param session HttpSession
	 * @return 로그인 처리 결과를 담은 맵
	 */
	protected HashMap<String, Object> authenticateUser(RequestLogin requestLogin, HttpSession session) {
		// memberService를 통해 로그인 처리 후 결과 반환
		return memberService.loginProcess(requestLogin, session);
	}

	/*
	 * 금일 작업 시작 체크
	 */
	protected boolean checkTodayWork(HttpSession session ,RedirectAttributes redirectAttributes ) {

		boolean state = checkLogin(session, redirectAttributes);
		Member member = (Member) session.getAttribute("member");
		// 로그인 실패
		if(!state) return false;
		// 로그인 성공
		if(state && "Y".equals(member.getTodayWorkYN()) ){
			return true;
		}

		redirectAttributes.addAttribute("errMsg", "금일작업시작을 먼저 진행해주세요.");
		return false;
		
	}
	
}

