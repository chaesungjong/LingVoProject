package com.castlebell.lingvo.mmb.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;
import com.castlebell.lingvo.mmb.service.MemberService;
import com.castlebell.lingvo.work.util.SHA256Util;
import com.castlebell.lingvo.work.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 로그인 및 회원 가입 관련 컨트롤러
 */
@Controller
@RequestMapping("mmb")
public class MemberController extends CommonController{
	
	@Autowired
    private  MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);


	/**
	 * 로그인 화면
	 * @return
	 */
    @RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginLayout() {
		logger.debug("loginPage 진입");
	    return "mmb/login";
	}

	/**
	 * 사용자 로그인 처리를 위한 컨트롤러 메서드.
	 *
	 * @param request 사용자의 로그인 요청 정보
	 * @param model 화면에 전달할 모델
	 * @param session 현재 세션
	 * @param redirectAttributes 리다이렉트 시 전달할 속성
	 * @return 로그인 처리 후 이동할 페이지 경로
	 */
	@RequestMapping(value="/loginProcess.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String login(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

		// 사용자 입력 정보 추출
		String userid = (request.getHeader("userID") != null) ? request.getHeader("userID") : request.getParameter("userid");
		String pwd = (request.getHeader("pwd") != null) ? request.getHeader("pwd") : SHA256Util.hashWithSHA256(request.getParameter("pwd"));
		String userIP = request.getRemoteAddr();
		String clientType = request.getHeader("User-Agent");

		// 아이디와 비밀번호 유효성 검사
		if (StringUtil.isNull(pwd) || StringUtil.isNull(userid)) {
			model.addAttribute("errMsg", "아이디 또는 비밀번호를 입력해주세요.");
			return "mmb/login";
		}

		RequestLogin requestLogin = new RequestLogin();

		requestLogin.setUserid(userid);
		requestLogin.setUserpw(pwd);
		requestLogin.setIp(userIP);
		requestLogin.setClienttype(clientType);

		logger.debug("사용자 로그인 처리 : requestLogin : {}", requestLogin);
		// 로그인 처리
		HashMap<String, Object> resultMap = authenticateUser(requestLogin, session);
		String retVal = StringUtil.objectToString(resultMap.get("retVal"));

		//로그인 실패
		session.setAttribute("temp_userid", "");
		if(!"0".equals(retVal)){
			if("-4".equals(retVal)){
				session.setAttribute("temp_userid", userid);
				return "redirect:/mmb/pwdInit";
			}else{
				model.addAttribute("errMsg", StringUtil.objectToString(resultMap.get("errMsg")));
				return "mmb/login";
			}
		}

		session.setAttribute("autoLogin", requestLogin);

		// 사용자 등급에 따라 페이지 리다이렉트
		Member member = (Member) resultMap.get("member");
		String grade = StringUtil.objectToString(member.getGrade());


		if(grade.contains("S") || grade.contains("C") ){
			return "redirect:/work/manager/main";// 정부 관리자, 링보 관리자
		}else if(grade.contains("U")){
			return "redirect:/work/worker/main";// 근로자
		}else{
			model.addAttribute("errMsg", "정상적인 사용자가 아닙니다.");
			return "mmb/login";
		}
		
	}

	/**
	 * 비밀번호 초기화
	 * @return
	 */
    @RequestMapping(value = "/pwdInit", method=RequestMethod.GET)
	public String pwdInit(HttpServletRequest request, 	Model model ,HttpSession session) {
		String temp_userid = (String) session.getAttribute("temp_userid");
		model.addAttribute("temp_userid", temp_userid);
		//logger.info("temp_user:"+temp_userid);
	    return "mmb/pwdInit";
	}

	
	/*
	 * 비밀번호 초기화 처리
	 * @return
	 */
	@RequestMapping(value="/pwdInitProcess.do", method = {RequestMethod.POST})
	public String pwdInitProcess(HttpServletRequest request, 	Model model ,HttpSession session) {
 
		String retVal = "";
		String retErrMsg = "";

		String temp_userid    	= request.getParameter("temp_userid");		//아이디
		String pwd        		= request.getParameter("pwd");				//비밀번호
		String pwdNext       	= request.getParameter("pwdNext");			//변경할 비밀번호 
		String pwdNextRe        = request.getParameter("pwdNextRe");		//변경할 비밀번호 확인
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		if(StringUtil.isNull(pwd) || StringUtil.isNull(pwdNext) || StringUtil.isNull(pwdNextRe)) {
			model.addAttribute("errMsg", "비밀번호를 입력해주세요.");
			return "mmb/pwdInit";
		}

		String session_temp_userid = (String) session.getAttribute("temp_userid");	
		if(!session_temp_userid.equals(temp_userid)){
			model.addAttribute("errMsg", "try login again!");
			session.setAttribute("temp_userid", "");
			return "mmb/login";
		}
		
		pwd = SHA256Util.hashWithSHA256(pwd);
		pwdNext = SHA256Util.hashWithSHA256(pwdNext);

		resultMap = memberService.pwdInitProcess(request, temp_userid, pwd, pwdNext);

		Member member = (Member) resultMap.get("member");
		if(member != null) {
			retVal = StringUtil.objectToString(member.getEetVal());
			retErrMsg = StringUtil.objectToString(member.getErrMsg());
		}

		session.setAttribute("temp_userid", "");

		//if(!"0".equals(retVal)){
			model.addAttribute("errMsg", retErrMsg);	
		//}	
		return "mmb/login";
			
	}

	/**
	 * 로그 아웃 처리	
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate(); // 세션 무효화
        return "redirect:/mmb/login"; // 로그인 페이지로 리다이렉트
    }

}

