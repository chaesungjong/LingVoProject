package com.castlebell.lingvo.work.controller.manager;

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
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoSiteWorkAllCompResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoUserWorkStopResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkStopResponse;
import com.castlebell.lingvo.work.service.ManagerService;
import com.castlebell.lingvo.work.util.DateFormatter;
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
     * MY 현장 정보
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes  리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/fieldinformationlist", method = RequestMethod.GET)
    public String fieldInformationList( HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("fieldInformationList 진입");
        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";
        
        // 현장 정보 리스트 페이지 URL 반환
        return FieldInformationMapping + "/fieldinformationlist";
    }

    /**
     * 관리자 MY 현장 정보         (전체보기 총 근로자 수 확인) 
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes  리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 (전체보기) 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoToday", method = RequestMethod.GET)
    public String myFieldInfoToday( HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoToday 진입");
        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";
        
        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("result", totalResult(member));
        model.addAttribute("date", DateFormatter.formatCurrentDate());
        
        // 현장 정보 (전체보기) 페이지 URL 반환
        return FieldInformationMapping + "/myFieldInfoToday";
    }

    /**
     * 모든 현장 정보를 조회하는 함수입니다. 
     * 이는 현장 정보 리스트 페이지에서 사용됩니다.
     *
     * @param request HttpServletRequest 객체로부터 받아온 요청 정보입니다.
     * @param model 뷰로 전달될 데이터를 담기 위한 객체입니다.
     * @param session 현재 사용자의 세션 정보입니다.
     * @param redirectAttributes 리다이렉트 시 전달될 속성 정보입니다.
     * @return 현장 정보 조회 페이지의 URL을 반환합니다.
     */
    @RequestMapping(value = "/myFieldInfoAll", method = RequestMethod.GET)
    public String myFieldInfoAll(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoAll 진입");

        // 사용자의 로그인 상태 확인
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        // 세션으로부터 회원 정보를 가져옵니다.
        Member member = (Member) session.getAttribute("member");

        // 요청으로부터 gubun 파라미터 값을 가져옵니다.
        String gubun = StringUtil.objectToString(request.getParameter("gubun"));
        String category;

        // gubun 값에 따라 카테고리 정보 설정
        if ("".equals(gubun)) {
            gubun = "REGION_ALL";
            category = "현장명";
        } else {
            gubun = "CONST_ALL";
            category = "시공사";
        }

        // 현장 정보 조회를 위한 요청 객체를 생성하고 설정합니다.
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, gubun, "", "", "", "", "", "");

        // 현장 정보를 조회하고 결과를 가져옵니다.
        List<StatMySiteInfoRegionAllResponse> result = managerService.statMySiteInfoRegionAllResponse(stateMySiteInfoRequest);

        // 결과 데이터를 모델에 추가합니다.
        model.addAttribute("result", result);
        model.addAttribute("category", category);
        model.addAttribute("totalResult", totalResult(member));

        // 현장 정보 조회 페이지의 URL을 반환합니다.
        return FieldInformationMapping + "/myFieldInfoAll";
    }

    /**
     * MY 건설 현장 정보 메인 페이지를 반환합니다.
     *
     * @param request HttpServletRequest 객체로부터 받아온 요청 정보입니다.
     * @param model 뷰로 전달될 데이터를 담기 위한 객체입니다.
     * @param session 현재 사용자의 세션 정보입니다.
     * @param redirectAttributes 리다이렉트 시 전달될 속성 정보입니다.
     * @return 현장 정보 메인 페이지의 URL을 반환합니다.
     */
    @RequestMapping(value = "/myFieldInfoField", method = RequestMethod.GET)
    public String myFieldInfoField(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoField 진입");

        // 사용자의 로그인 상태 확인
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        // 세션으로부터 회원 정보를 가져옵니다.
        Member member = (Member) session.getAttribute("member");
        String addr = StringUtil.objectToString(request.getParameter("siteSubAddr2"));
        String gubun = "REGION_SITE";
        String nWork = StringUtil.objectToString(request.getParameter("nWork"));
        String nWorkStopRequest = StringUtil.objectToString(request.getParameter("nWorkStopRequest"));
        String nSafeEnd = StringUtil.objectToString(request.getParameter("nSafeEnd"));
        String constCode = StringUtil.objectToString(request.getParameter("constCode"));
        String constName = StringUtil.objectToString(request.getParameter("constName"));

        // 회원 등급 및 주소에 따른 분기 처리
        if (member.getGrade().equals("C2") || "".equals(addr)) {
            if (member.getGrade().equals("C2")) {
                constCode = member.getConstCode();
                constName = member.getConstName();
            }
            gubun = "CONST_SITE";
        } else {
            constName = addr;
        }

        // 현장 정보 조회를 위한 요청 객체를 생성하고 설정합니다.
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, gubun, addr, constCode, "", "", "", "");

        // 현장 정보를 조회하고 결과를 가져옵니다.
        List<StatMySiteInfoRegionSiteResponse> result = managerService.statMySiteInfoRegionSiteResponse(stateMySiteInfoRequest);

        // 결과 데이터를 모델에 추가합니다.
        model.addAttribute("title", constName);
        model.addAttribute("result", result);
        model.addAttribute("nWork", nWork);
        model.addAttribute("nSafeEnd", nSafeEnd);
        model.addAttribute("nWorkStopRequest", nWorkStopRequest);
        if (member.getGrade().equals("C2")) model.addAttribute("totalResult", totalResult(member));

        // 현장 정보 메인 페이지의 URL을 반환합니다.
        return FieldInformationMapping + "/myFieldInfoField";
    }

    /**
     * MY 현장 정보 회사 페이지를 반환합니다.
     *
     * @param request HttpServletRequest 객체로부터 받아온 요청 정보입니다.
     * @param model 뷰로 전달될 데이터를 담기 위한 객체입니다.
     * @param session 현재 사용자의 세션 정보입니다.
     * @param redirectAttributes 리다이렉트 시 전달될 속성 정보입니다.
     * @return 현장 정보 회사 페이지의 URL을 반환합니다.
     */
    @RequestMapping(value = "/myFieldInfoCompany", method = RequestMethod.GET)
    public String myFieldInfoCompany(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoCompany 진입");

        // 사용자의 로그인 상태 확인
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        // 세션으로부터 회원 정보를 가져옵니다.
        Member member = (Member) session.getAttribute("member");

        String title = StringUtil.objectToString(request.getParameter("siteName"));
        String siteCode = StringUtil.objectToString(request.getParameter("siteCode"));
        String nWork = StringUtil.objectToString(request.getParameter("nWork"));
        String nSafeEnd = StringUtil.objectToString(request.getParameter("nSafeEnd"));
        String nWorkStopRequest = StringUtil.objectToString(request.getParameter("nWorkStopRequest"));

        // 현장 정보 조회를 위한 요청 객체를 생성하고 설정합니다.
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "REGION_COMPANY", "", "", siteCode, "", DateFormatter.formatShortDate(), "");

        // 현장 정보를 조회하고 결과를 가져옵니다.
        List<StatMySiteInfoRegionCompanyResponse> result = managerService.statMySiteInfoRegionCompanyResponse(stateMySiteInfoRequest);

        // 결과 데이터를 모델에 추가합니다.
        model.addAttribute("result", result);
        model.addAttribute("title", title);
        model.addAttribute("nWork", nWork);
        model.addAttribute("nSafeEnd", nSafeEnd);
        model.addAttribute("nWorkStopRequest", nWorkStopRequest);

        if ("C1".equals(member.getGrade())) {
            model.addAttribute("totalResult", totalResult(member));
            model.addAttribute("title", ""+member.getSiteName()); 
        }

        // 현장 정보 회사 페이지의 URL을 반환합니다.
        return FieldInformationMapping + "/myFieldInfoCompany";
    }

    /**
     * MY 현장 작업 중지 정보 페이지를 반환합니다.
     *
     * @param request HttpServletRequest 객체로부터 받아온 요청 정보입니다.
     * @param model 뷰로 전달될 데이터를 담기 위한 객체입니다.
     * @param session 현재 사용자의 세션 정보입니다.
     * @param redirectAttributes 리다이렉트 시 전달될 속성 정보입니다.
     * @return 현장 작업 중지 정보 페이지의 URL을 반환합니다.
     */
    @RequestMapping(value = "/myFieldInfoStop", method = RequestMethod.GET)
    public String myFieldInfoStop(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoStop 페이지 진입");

        // 사용자의 로그인 상태 확인
        if (!checkLogin(session, redirectAttributes)) {
            return "redirect:/mmb/login";
        }

        // 세션으로부터 회원 정보를 가져옵니다.
        Member member = (Member) session.getAttribute("member");

        String siteCode = StringUtil.objectToString(request.getParameter("siteCode"));
        String companyName = StringUtil.objectToString(request.getParameter("companyName"));

        // 현장 작업 중지 정보 조회를 위한 요청 객체를 생성하고 설정합니다.
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "SITE_WORKSTOP", "", "", siteCode, companyName, DateFormatter.formatShortDate(), "");

        // 현장 작업 중지 정보를 조회하고 결과를 가져옵니다.
        List<StatMySiteInfoWorkStopResponse> result = managerService.statMySiteInfoWorkStopResponse(stateMySiteInfoRequest);

        // 결과 데이터를 모델에 추가합니다.
        model.addAttribute("result", result);
        model.addAttribute("title", companyName);  // 회사 이름을 타이틀로 설정

        // 현장 작업 중지 정보 페이지의 URL을 반환합니다.
        return FieldInformationMapping + "/myFieldInfoStop";
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

        String siteCode = StringUtil.objectToString(request.getParameter("siteCode"));
        String companyName = StringUtil.objectToString(request.getParameter("companyName"));

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");

        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "SITE_WORKALL_COMP", "", "", siteCode, companyName, DateFormatter.formatShortDate(), "");
     
        List<StatMySiteInfoSiteWorkAllCompResponse> result = managerService.statMySiteInfoSiteWorkAllCompResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result); // 구분
        model.addAttribute("title", companyName); // 제목
        return FieldInformationMapping + "/myFieldInfoEmployee";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfodetails", method = RequestMethod.GET)
    public String myFieldInfodetails(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfodetails 진입");

        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        String userid = StringUtil.objectToString(request.getParameter("userid"));
        String title = StringUtil.objectToString(request.getParameter("title"));

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");

        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "USER_WORKSTOPREQUEST", "", "", "", "", DateFormatter.formatShortDate(), "");
        stateMySiteInfoRequest.setWorkUserid(userid);
     
        List<StatMySiteInfoUserWorkStopResponse> result = managerService.statMySiteInfoUserWorkStopResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result); // 구분
        model.addAttribute("title", title); // 제목
        return FieldInformationMapping + "/myFieldInfodetails";
    }

     /**
     * My현장정보 통계 요청 데이터를 생성하는 메서드
     * 
     * @param member     현재 세션의 회원 정보
     * @param gubun      통계 구분 값
     * @param regionName 지역 이름
     * @param constCode  회사 코드
     * @param siteCode   현장 코드
     * @param companyName 회사 이름
     * @param sdate      조회 시작 날짜
     * @param edate      조회 종료 날짜
     * @return My현장정보 통계 요청 데이터 객체
     */
    private StateMySiteInfoRequest createStateMySiteInfoRequest(Member member, String gubun, String regionName, String constCode, String siteCode, String companyName, String sdate, String edate) {
        
        StateMySiteInfoRequest request = new StateMySiteInfoRequest();

        request.setGubun(gubun);   
        request.setUserid(member.getUserid());               
        request.setGrade(member.getGrade());
        request.setConstCode(constCode);

        // 사용자의 등급이 'C'를 포함하면 회사 코드 설정
        if (member.getGrade().contains("C")) {
            request.setConstCode(member.getConstCode());
        }
        
        request.setSvgCode(member.getSvgCode());
        request.setSiteCode(siteCode);

        // 사용자의 등급이 'C1'일 경우 현장 코드 설정
        if (member.getGrade().contains("C1")) {
            request.setSiteCode(member.getsiteCode());
        }

        request.setRegionName(regionName);
        request.setCompanyName(companyName);  // 오타 수정: setCompnayName -> setCompanyName
        request.setSdate(sdate);
        request.setEdate(edate);

        return request;
    }

    /**
     * 회원에 따른 전체 현장 정보 결과를 반환하는 메서드
     * 
     * @param member 현재 세션의 회원 정보
     * @return 전체 현장 정보 응답 데이터 객체
     */
    private StatMySiteInfoWorkAllResponse totalResult(Member member) {
        
        StateMySiteInfoRequest request = createStateMySiteInfoRequest(member, "WORK_ALL", "", "", "", "", "", "");
        return managerService.statMySiteInfoWorkAllResponse(request);
    }
}