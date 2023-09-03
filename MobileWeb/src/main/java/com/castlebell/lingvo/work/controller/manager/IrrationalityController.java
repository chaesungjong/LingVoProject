package com.castlebell.lingvo.work.controller.manager;

import java.util.Map;
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
import com.castlebell.lingvo.work.dao.domain.request.IllegalInfoModify;
import com.castlebell.lingvo.work.service.ManagerService;
import com.castlebell.lingvo.work.util.StringUtil;

/**
 * @since 2023. 8. 13.
 * @version 1.0
 * <pre>
 * 불합리 적발 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/manager/irrationality")
public class IrrationalityController extends CommonController {

    @Autowired
    private ManagerService managerService;
    private static final Logger logger = LoggerFactory.getLogger(IrrationalityController.class);

    /**
     * 부적합 적발 메인
     * @return 페이지 경로
     */
    @RequestMapping(value = "/Mainirrationality", method = RequestMethod.GET)
    public String irrationality(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("exposure 진입");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        

        return IrrationalityMapping + "/Mainirrationality";
    }

    /**
     * 부적합 적발 사진 등록
     * @return 페이지 경로
     */
    @RequestMapping(value = "/exposurePicturePlus", method = RequestMethod.GET)
    public String exposurePicturePlus(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("exposurePicturePlus 진입");
        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        return IrrationalityMapping + "/exposurePicturePlus";
    }

    /**
     * 부적합 적발 첨부 상세 내용
     * @return 페이지 경로
     */
    @RequestMapping(value = "/exposurePicturePlusDitail", method = RequestMethod.GET)
    public String exposurePicturePlusDitail(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("exposurePicturePlusDitail 진입");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }
        return IrrationalityMapping + "/exposurePicturePlusDitail";
    }

    /**
     * 부적합 적발 첨부 상세 내용
     * @return 페이지 경로
     */
    @RequestMapping(value = "/exposurePicturePlusComfirm", method = RequestMethod.POST)
    public String exposurePicturePlusComfirm(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("exposurePicturePlusComfirm 진입");

        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        Member member = (Member) session.getAttribute("member");
        String InputWorker   = StringUtil.objectToString(request.getParameter("InputWorker"));
        String InputContent  = StringUtil.objectToString(request.getParameter("InputContent"));
        String imgPaths      = StringUtil.objectToString(request.getParameter("imgPaths"));
        String illegalClass  = StringUtil.objectToString(request.getParameter("illegalClass"));
        String gubun = "build".equals(illegalClass) ? "시설물 불합리" : "근로자 불합리";

        IllegalInfoModify illegalInfoModify = new IllegalInfoModify();

        illegalInfoModify.setGubun("regist");
        illegalInfoModify.setUserid(member.getUserid());
        illegalInfoModify.setsiteCode(member.getsiteCode());
        illegalInfoModify.setillegalClass(illegalClass);
        illegalInfoModify.setillegalGubun(gubun);
        illegalInfoModify.setillegalUserid(InputWorker);
        illegalInfoModify.setlocation("");
        illegalInfoModify.setillegalClass(InputContent);
        illegalInfoModify.setimgPaths(imgPaths);
        illegalInfoModify.setstate("Y");
        illegalInfoModify.setip(request.getRemoteAddr());
        illegalInfoModify.setilgSeq("");

        managerService.illegalInfoModify(illegalInfoModify);

        return IrrationalityMapping + "/exposurePicturePlusComfirm";
    }

    /**
     * 부적합 적발 첨부 내용 저장하기
     * @return 페이지 경로
     */
    @RequestMapping(value = "/exposureEnd", method = RequestMethod.POST)
    public String exposureEnd(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        logger.debug("exposureEnd 진입");
        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        //세션에서 사용자 정보 및 작업 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

        logger.debug("member : " + member);
        logger.debug("workSafetyCheck : " + workSafetyCheck);

        //파라미터 로그 출력
        Map<String, String[]> paramMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            String valueStr = String.join(", ", values);
            logger.debug(key + " : " + valueStr);
        }

        return IrrationalityMapping + "/exposureEnd";
    }

    /**
     * 부적합 적발 첨부 내용 저장하기
     * @return 페이지 경로
     */
    @RequestMapping(value = "/myFieldInfoStop", method = RequestMethod.POST)
    public String myFieldInfoStop(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("exposureEnd 진입");
        
        if (!checkLogin(session, redirectAttributes)) { 
            return "redirect:/mmb/login"; 
        }

        //세션에서 사용자 정보 및 작업 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        WorkSafetyCheck workSafetyCheck = (WorkSafetyCheck) session.getAttribute("WorkSafetyCheck");

        logger.debug("member : " + member);
        logger.debug("workSafetyCheck : " + workSafetyCheck);

        //파라미터 로그 출력
        Map<String, String[]> paramMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            String valueStr = String.join(", ", values);
            logger.debug(key + " : " + valueStr);
        }

        return IrrationalityMapping + "/exposureEnd";
    }
}