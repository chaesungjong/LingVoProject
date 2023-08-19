package com.castlebell.lingvo.board.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.castlebell.lingvo.board.dao.domain.request.NewsFilter;
import com.castlebell.lingvo.board.dao.domain.response.Board;
import com.castlebell.lingvo.board.service.BoardService;
import com.castlebell.lingvo.util.StringUtil;

/**
 * 공지사항 관련 컨트롤러
 */
@Controller
@RequestMapping("board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private final BoardService boardservice;

    @Autowired
    public BoardController(BoardService boardservice) {
        this.boardservice = boardservice;
    }

	/**
	 * 공지사항 정보 가져오기
	 * @return
	 */
    @RequestMapping(value = "/noticeBoard", method=RequestMethod.GET)
	public String noticeBoard(HttpServletRequest request, Model model) {

		logger.debug("noticeBoard 진입");

		String Gubun = StringUtil.objectToString(request.getParameter("Gubun"));
		String Seq = StringUtil.objectToString(request.getParameter("seq"));
		String url = "board/noticeBoard";

		if(Gubun == null || Gubun.equals("")){
			return "redirect:/work/worker/main";
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
}