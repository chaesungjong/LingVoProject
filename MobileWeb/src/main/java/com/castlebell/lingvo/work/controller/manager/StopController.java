package com.castlebell.lingvo.work.controller.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.castlebell.lingvo.cmm.CommonController;


/**
 * @since 2023. 8. 28.
 * @version 1.0
 * <pre>
 * 작업 후기 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/manager/stop")
public class StopController extends CommonController {
    

    private static final Logger logger = LoggerFactory.getLogger(StopController.class);

    /**
     * 관리자 작업 후기 메인
     * @return 페이지 경로
     */
    @RequestMapping(value = "/workReview", method = RequestMethod.GET)
    public String workReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workReview 진입");


        return StopMapping + "/workReview";
    }

    /**
     * 관리자 작업 후기 완료
     * @return 페이지 경로
     */
    @RequestMapping(value = "/workReviewEnd", method = RequestMethod.GET)
    public String workReviewEnd(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workReviewEnd 진입");
        return StopMapping + "/workReviewEnd";
    }

    /**
     * 관리자 작업 후기 개선 사항 체크
     * @return 페이지 경로
     */
    @RequestMapping(value = "/workImprovementReview", method = RequestMethod.GET)
    public String workImprovementReview(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workImprovementReview 진입");

        return StopMapping + "/workImprovementReview";
    }

    /**
     * 관리자 작업 후기 개선 사항 체크 완료
     * @return 페이지 경로
     */
    @RequestMapping(value = "/workImprovementReviewResult", method = RequestMethod.GET)
    public String workImprovementReviewResult(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("workImprovementReview 진입");

        return StopMapping + "/workImprovementReviewResult";
    }
}
