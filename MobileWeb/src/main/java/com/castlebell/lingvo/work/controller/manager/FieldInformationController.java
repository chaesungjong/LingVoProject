package com.castlebell.lingvo.work.controller.manager;

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
import com.castlebell.lingvo.util.StringUtil;
import com.castlebell.lingvo.work.service.WorkService;

/**
 * @since 2023. 8. 13.
 * @version 1.0
 * <pre>
 * 현장 정보 컨트롤러
 * </pre>
 */
@Controller
@RequestMapping("work/manager/fieldinformation")
public class FieldInformationController extends CommonController {

    private static final Logger logger = LoggerFactory.getLogger(FieldInformationController.class);
    @Autowired
    private WorkService workService;

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/fieldinformationlist", method = RequestMethod.GET)
    public String fieldinformationlist(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("fieldinformationlist 진입");

        // 로그인 체크
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        return FieldInformationMapping + "/fieldinformationlist";
    }

    /**
     * 현장 정보 상세 보기
     * @return 현장 정보 상세 페이지 URL
     */
    @RequestMapping(value = "/choiceFiedList", method = RequestMethod.GET)
    public String choiceFiedList(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("choiceFiedList 진입");

        // 로그인 체크
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        // 사용자의 선택에 따른 현장 정보 조회 및 모델 설정
        handleFieldInformation(request, model);

        return FieldInformationMapping + "/choiceFiedList";
    }

    /**
     * 사용자의 선택에 따른 현장 정보 조회 및 모델 설정
     * @param request 사용자 요청 정보
     * @param model 뷰에 전달될 데이터 모델
     */
    private void handleFieldInformation(HttpServletRequest request, Model model) {
        String select = StringUtil.objectToString(request.getParameter("select"));
        String title = StringUtil.objectToString(request.getParameter("title"));

        // 선택된 현장 정보 유형에 따른 처리
        switch (select) {
            case "allField":
                setAllFieldInfo(model);
                break;
            case "svgCode":
                setSvgCodeInfo(model);
                break;
            case "siteSubAddr2":
                setSiteSubAddr2Info(model, title);
                break;
            case "siteCode":
                setSiteCodeInfo(model, title);
                break;
            case "stopWork":
                setStopWorkInfo(model);
                break;
            default:
                // 기본 처리나 오류 처리를 위한 코드
                break;
        }
    }

    private void setAllFieldInfo(Model model) {
        model.addAttribute("totalWorker", StringUtil.objectToString("100")); // 총 근로자
        model.addAttribute("successAlCall", StringUtil.objectToString("50")); // 안전활동 완료
        model.addAttribute("stopWorker", StringUtil.objectToString("2")); // 작업중지 요청
    }

    private void setSvgCodeInfo(Model model) {
        model.addAttribute("siteSubAddr2", StringUtil.objectToString("대포동")); // 주소
        addCommonAttributes(model, "전체보기", "svgCode");
    }

    private void setSiteSubAddr2Info(Model model, String title) {
        model.addAttribute("siteName", StringUtil.objectToString("대포 아이파크 신축공사")); // 현장명
        addCommonAttributes(model, title, "siteSubAddr2");
    }

    private void setSiteCodeInfo(Model model, String title) {
        model.addAttribute("companyName", StringUtil.objectToString("깔끔 인테리어회사")); // 회사 명
        addCommonAttributes(model, title, "siteCode");
    }

    private void setStopWorkInfo(Model model) {
        model.addAttribute("siteSubAddr1", StringUtil.objectToString("경상남도 사천시")); // 위치
        model.addAttribute("siteName", StringUtil.objectToString("대포 아이파크 신축공사")); // 현장
        model.addAttribute("constName", StringUtil.objectToString("CJ건설")); // 업체명
        model.addAttribute("userid", StringUtil.objectToString("test")); // 작업자
        model.addAttribute("issuse", StringUtil.objectToString("안전난간 파손")); // 작업중지 요청 사유
        model.addAttribute("view", "작업 중지 요청 내역"); // 타이틀
        model.addAttribute("select", "stopWork"); // 구분
    }

    private void addCommonAttributes(Model model, String title, String select) {
        model.addAttribute("totalWorker", StringUtil.objectToString("100")); // 총 근로자
        model.addAttribute("successAlCall", StringUtil.objectToString("50")); // 안전활동 완료
        model.addAttribute("stopWorker", StringUtil.objectToString("2")); // 작업중지 요청
        model.addAttribute("view", title); // 타이틀
        model.addAttribute("select", select); // 구분
    }
}