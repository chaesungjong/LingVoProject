package com.castlebell.lingvo.work.controller.manager;

import java.time.LocalDate;
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
import com.castlebell.lingvo.work.dao.domain.request.StateMySiteInfoRequest;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionCompanyResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionSiteResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkAllResponse;
import com.castlebell.lingvo.work.service.ManagerService;
import com.castlebell.lingvo.work.util.StringUtil;

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

    @Autowired
    private ManagerService managerService;
    private static final Logger logger = LoggerFactory.getLogger(FieldInformationController.class);

    /**
     * MY 현장 정보 메인 페이지를 요청하는 메서드
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes 리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/fieldinformationlist", method = RequestMethod.GET)
    public String fieldInformationList(
            HttpServletRequest request, Model model, HttpSession session,
            RedirectAttributes redirectAttributes) {
        logger.debug("fieldInformationList 진입");
        
        // 로그인 체크 및 처리
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }
        
        // 현장 정보 리스트 페이지 URL 반환
        return FieldInformationMapping + "/fieldinformationlist";
    }

    /**
     * MY 현장 정보 (전체보기) 페이지를 요청하는 메서드
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes 리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 (전체보기) 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoToday", method = RequestMethod.GET)
    public String myFieldInfoToday(
            HttpServletRequest request, Model model, HttpSession session,
            RedirectAttributes redirectAttributes) {
        logger.debug("myFieldInfoToday 진입");
        
        // 로그인 체크 및 처리
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }
        
        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        
        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "WORK_ALL", "", "", "", "", "", "");
        
        // 현장 정보 조회 요청 및 결과 모델에 추가
        StatMySiteInfoWorkAllResponse result = managerService.statMySiteInfoWorkAllResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result);
        
        // 현장 정보 (전체보기) 페이지 URL 반환
        return FieldInformationMapping + "/myFieldInfoToday";
    }

    /**
     * MY 현장 정보 전체 조회 페이지를 요청하는 메서드
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes 리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 전체 조회 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoAll", method = RequestMethod.GET)
    public String myFieldInfoAll(
            HttpServletRequest request, Model model, HttpSession session,
            RedirectAttributes redirectAttributes) {
        logger.debug("myFieldInfoAll 진입");
        
        // 로그인 체크 및 처리
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }
        
        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        
        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "REGION_ALL", "", "", "", "", "", "");
        
        // 현장 정보 전체 조회 요청 및 결과 모델에 추가
        List<StatMySiteInfoRegionAllResponse> result = managerService.statMySiteInfoRegionAllResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result);
        
        // 현장 정보 전체 조회 페이지 URL 반환
        return FieldInformationMapping + "/myFieldInfoAll";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoField", method = RequestMethod.GET)
    public String myFieldInfoField(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoAll 진입");

        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
       
        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest( member, "REGION_SITE",StringUtil.objectToString(request.getParameter("siteSubAddr2")), "", "", "", "", "");

        
        List<StatMySiteInfoRegionSiteResponse> result = managerService.statMySiteInfoRegionSiteResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result); // 구분
        return FieldInformationMapping + "/myFieldInfoField";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoCompany", method = RequestMethod.GET)
    public String myFieldInfoCompany(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoAll 진입");

        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.toString(); // "YYYY-MM-DD" 형식의 문자열로 변환

        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest( member, "REGION_COMPANY","", "", "", "", formattedDate, "");
     
        List<StatMySiteInfoRegionCompanyResponse> result = managerService.statMySiteInfoRegionCompanyResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result); // 구분
        return FieldInformationMapping + "/myFieldInfoCompany";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoEmployee", method = RequestMethod.GET)
    public String myFieldInfoEmployee(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoEmployee 진입");

        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        return FieldInformationMapping + "/myFieldInfoEmployee";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoStop", method = RequestMethod.GET)
    public String myFieldInfoStop(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoStop 진입");
        
        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        return FieldInformationMapping + "/myFieldInfoStop";
    }

    /**
     * My현장정보 통계 요청 데이터 생성 메서드
     * @param member     회원 정보 객체
     * @param gubun      통계 구분 (WORK_ALL, REGION_ALL 등)
     * @param sdate      시작 날짜
     * @param edate      종료 날짜
     * @param pageNo     페이지 번호
     * @param pageSize   페이지 크기
     * @param etcParam   기타 파라미터
     * @return My현장정보 통계 요청 데이터
     */
    private StateMySiteInfoRequest createStateMySiteInfoRequest(
            Member member, String gubun, String regionName,
            String sdate, String edate, String pageNo,
            String pageSize, String etcParam) {
        // My현장정보 통계 요청 데이터 객체 생성
        StateMySiteInfoRequest stateMySiteInfoRequest = new StateMySiteInfoRequest();
        
        // 통계 구분 설정
        stateMySiteInfoRequest.setGubun(gubun);
        
        // 회원 정보 설정
        stateMySiteInfoRequest.setUserid(member.getUserid());
        stateMySiteInfoRequest.setGrade(member.getGrade());
        stateMySiteInfoRequest.setSvgCode(member.getSvgCode());
        stateMySiteInfoRequest.setSiteCode(member.getsiteCode());
        
        // 지역 이름 설정 (3단 연산자로 변경)
        stateMySiteInfoRequest.setRegionName(StringUtil.isNull(regionName) ? member.getSvgRegion() : regionName);
        
        stateMySiteInfoRequest.setCompnayName(member.getCompanyName());
        
        // 날짜 및 페이지 설정
        stateMySiteInfoRequest.setSdate(sdate);
        stateMySiteInfoRequest.setEdate(edate);
        stateMySiteInfoRequest.setPageNo(pageNo);
        stateMySiteInfoRequest.setPageSize(pageSize);
        
        // 기타 파라미터 설정
        stateMySiteInfoRequest.setEtcParam(etcParam);
        
        // 생성된 통계 요청 데이터 반환
        return stateMySiteInfoRequest;
    }
}