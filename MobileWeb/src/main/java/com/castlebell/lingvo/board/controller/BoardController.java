package com.castlebell.lingvo.board.controller;

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

import com.castlebell.lingvo.board.dao.domain.request.NewsFilter;
import com.castlebell.lingvo.board.dao.domain.response.Board;
import com.castlebell.lingvo.board.service.BoardService;
import com.castlebell.lingvo.cmm.CommonController;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.work.util.StringUtil;

/**
 * 공지사항 관련 컨트롤러
 */
@Controller
@RequestMapping("board")
public class BoardController extends CommonController{

	@Autowired
	private BoardService boardservice;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/**
	 * 공지사항 정보 가져오기
	 * @return
	 */
    @RequestMapping(value = "/noticeBoard", method=RequestMethod.GET)
	public String noticeBoard(HttpServletRequest request, Model model,HttpSession session, RedirectAttributes redirectAttributes) {

		logger.debug("noticeBoard 진입");

		String Gubun = StringUtil.objectToString(request.getParameter("Gubun"));
		String Seq = StringUtil.objectToString(request.getParameter("seq"));
		String url = "board/noticeBoard";

		if(checkLogin( session,redirectAttributes) == false ) {
			return "redirect:";
		}

		Member member = (Member) session.getAttribute("member");

		if(Gubun == null || Gubun.equals("")){
			if(member.getGender().contains("S") || member.getGender().contains("C") ){
				return "redirect:/work/manager/main";// 정부 관리자, 링보 관리자
			}else if(member.getGender().contains("U")){
				return "redirect:/work/worker/main";// 근로자
			}else{
				model.addAttribute("errMsg", "정상적인 사용자가 아닙니다.");
				return "redirect:/";
			}
		}

		if(!"".equals(Seq)){
			url =  "board/noticeBoardDitail";
		}

		NewsFilter notice = new NewsFilter();
		notice.setGubun(Gubun);
		notice.setPageNo("");
		notice.setPageSize("");
		notice.setEdate("");
		notice.setEdate("");
		notice.setSearchGubun("");
		notice.setSearchVal(Seq);

		List<Board> noticeList = boardservice.getboardList(notice);
		model.addAttribute("list", noticeList);

	    return url;
	}

	
	/**
	 * 십짱TV 정보 가져오기
	 * @return
	 */
    @RequestMapping(value = "/videoBoard", method=RequestMethod.GET)
	public String videoBoard(HttpServletRequest request, Model model) {

		logger.debug("videoBoard 진입");

		String Gubun = StringUtil.objectToString(request.getParameter("Gubun"));
		Gubun = "TV";
		String Seq = StringUtil.objectToString(request.getParameter("seq"));
		String url = "board/videoBoard";

		if(Gubun == null || Gubun.equals("")){
			return "redirect:/work/worker/main";
		}
		
		// if(!"".equals(Seq)){
		// 	url =  "board/noticeBoardDitail";
		// }

		NewsFilter notice = new NewsFilter();
		notice.setGubun(Gubun);
		notice.setPageNo("");
		notice.setPageSize("");
		notice.setEdate("");
		notice.setEdate("");
		notice.setSearchGubun("");
		notice.setSearchVal(Seq);

		List<Board> noticeList = boardservice.getboardList(notice);
		model.addAttribute("list", noticeList);

	    return url;
	}
}