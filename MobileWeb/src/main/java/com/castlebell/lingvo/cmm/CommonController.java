package com.castlebell.lingvo.cmm;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castlebell.lingvo.cmm.session.Member;

@Controller
public class CommonController {

	protected final String StartWorkMapping = "work/worker/start";
	protected final String StopWorkMapping = "work/worker/stop";
	protected final String EndWorkMapping = "work/worker/end";
	protected final String IrrationalityMapping = "work/manager/irrationality";
	protected final String FieldInformationMapping = "work/manager/fieldinformation";

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
}

