package com.castlebell.lingvo.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.castlebell.lingvo.board.dao.domain.request.NewsFilter;
import com.castlebell.lingvo.board.dao.domain.response.Board;
import com.castlebell.lingvo.board.service.BoardService;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.work.service.WorkService;
import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("work")
public class WorkController extends CommonController {
	
    @Autowired
    private WorkService workService;

    @Autowired
    private BoardService boardservice;

    private static final Logger logger = LoggerFactory.getLogger(WorkController.class);


    /**
     * 작업자 메인 화면을 반환한다.
     * 
     * @param errMsg 오류 메시지
     * @param request HttpServletRequest
     * @param autoLoginJson 자동 로그인 정보 (JSON 형태)
     * @param model Model
     * @param session HttpSession
     * @param redirectAttributes RedirectAttributes
     * @return 작업자 메인 페이지 경로
     */
    @RequestMapping(value = "/worker/main", method = RequestMethod.GET)
    public String workerMain(  @ModelAttribute("errMsg") String errMsg, Model model,  HttpSession session,  RedirectAttributes redirectAttributes) {
    
        // 이미 로그인한 상태가 아닐 경우, 로그인 페이지로 리다이렉트
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }
        
		RequestLogin requestLogin = (RequestLogin) session.getAttribute("autoLogin");

        if(requestLogin != null){
            try{
                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper.writeValueAsString(requestLogin);
                model.addAttribute("autoLogin", jsonString);
            }catch(Exception e){
                logger.error("제이슨 파일 파싱 실패", e);
            }
        }

        if (errMsg != null && !errMsg.isEmpty()) {
            model.addAttribute("errMsg", errMsg);
        }

        NewsFilter notice = new NewsFilter();
		notice.setGubun("TV");
		notice.setPageNo("");
		notice.setPageSize("");
		notice.setEdate("");
		notice.setEdate("");
		notice.setSearchGubun("");
		notice.setSearchVal("");

		List<Board> noticeList = boardservice.getboardList(notice);
        model.addAttribute("noticeList", noticeList);
        
        return "work/worker/main";
    }


    /**
     * 시공 관리자 메인 화면을 반환한다.
     * 
     * @param errMsg 오류 메시지
     * @param request HttpServletRequest
     * @param model Model
     * @param session HttpSession
     * @param redirectAttributes RedirectAttributes
     * @return 시공 관리자 메인 페이지 경로
     */
    @RequestMapping(value = "/manager/main", method = RequestMethod.GET)
    public String managerMain(
            @ModelAttribute("errMsg") String errMsg,
            HttpServletRequest request, Model model,
            HttpSession session, RedirectAttributes redirectAttributes) {

        // 로그인 상태 체크
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        Member member = (Member) session.getAttribute("member");
        logger.debug("main 진입 : " + member.toString());

        model.addAttribute("name", member.getName() + " 님 환영합니다.");

        if (errMsg != null && !errMsg.isEmpty()) {
            model.addAttribute("errMsg", errMsg);
        }

        return "work/manager/main";
    }

    /**
     * 시청 관리자 메인 화면을 반환한다.
     * 
     * @param errMsg 오류 메시지
     * @param request HttpServletRequest
     * @param model Model
     * @param session HttpSession
     * @param redirectAttributes RedirectAttributes
     * @return 시청 관리자 메인 페이지 경로
     */
    @RequestMapping(value = "/city/main", method = RequestMethod.GET)
    public String cityMain(
            @ModelAttribute("errMsg") String errMsg,
            HttpServletRequest request, Model model,
            HttpSession session, RedirectAttributes redirectAttributes) {

        // 로그인 상태 체크
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        Member member = (Member) session.getAttribute("member");
        logger.debug("main 진입 : " + member.toString());

        model.addAttribute("name", member.getName() + " 님 환영합니다.");

        if (errMsg != null && !errMsg.isEmpty()) {
            model.addAttribute("errMsg", errMsg);
        }

        return "work/city/main";
    }


}