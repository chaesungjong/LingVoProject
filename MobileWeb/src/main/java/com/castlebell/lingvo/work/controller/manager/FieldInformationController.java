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
     * @param redirectAttributes 리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
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
     * MY 현장 정보 (전체보기 총 근로자 수 확인) 
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes 리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 (전체보기) 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoToday", method = RequestMethod.GET)
    public String myFieldInfoToday( HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoToday 진입");
        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";
        
        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        
        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "WORK_ALL", "","", "","","","");
        
        // 현장 정보 조회 요청 및 결과 모델에 추가
        StatMySiteInfoWorkAllResponse result = managerService.statMySiteInfoWorkAllResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result);
        model.addAttribute("date", DateFormatter.formatCurrentDate());
        
        // 현장 정보 (전체보기) 페이지 URL 반환
        return FieldInformationMapping + "/myFieldInfoToday";
    }

    /**
     * MY 현장 정보 전체 보기 ( 현장 정보 리스트 페이지 )
     * @param request             HttpServletRequest 객체
     * @param model               데이터를 뷰에 전달하기 위한 Model 객체
     * @param session             현재 세션 객체
     * @param redirectAttributes 리다이렉트 시 속성을 전달하기 위한 RedirectAttributes 객체
     * @return 현장 정보 전체 조회 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoAll", method = RequestMethod.GET)
    public String myFieldInfoAll( HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoAll 진입");
        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";
        
        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        String gubun = StringUtil.objectToString(request.getParameter("gubun"));
        String category = "";

        if("".equals(gubun)){
            gubun = "REGION_ALL";
            category = "현장명";
        }else{
            category = "업체명";
        }
        
        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest(member, gubun, "","", "","", "","");
        
        // 현장 정보 전체 조회 요청 및 결과 모델에 추가
        List<StatMySiteInfoRegionAllResponse> result = managerService.statMySiteInfoRegionAllResponse(stateMySiteInfoRequest);

        model.addAttribute("result", result);
        model.addAttribute("category", category);

        // 현장 정보 요청 객체 생성 및 설정
        stateMySiteInfoRequest = createStateMySiteInfoRequest(member, "WORK_ALL", "","", "","","","");
        
        // 현장 정보 조회 요청 및 결과 모델에 추가
        StatMySiteInfoWorkAllResponse totalResult = managerService.statMySiteInfoWorkAllResponse(stateMySiteInfoRequest);
        model.addAttribute("totalResult", totalResult);
        
        // 현장 정보 전체 조회 페이지 URL 반환
        return FieldInformationMapping + "/myFieldInfoAll";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoField", method = RequestMethod.GET)
    public String myFieldInfoField(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoField 진입");

        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");
        // 현장명
        String title = StringUtil.objectToString(request.getParameter("siteSubAddr2"));
        String gubun = "REGION_SITE";
        String nWork = StringUtil.objectToString(request.getParameter("nWork"));
        String nSafeEnd = StringUtil.objectToString(request.getParameter("nSafeEnd"));
        String nWorkStopRequest = StringUtil.objectToString(request.getParameter("nWorkStopRequest"));

        if("".equals(title)){
            title = StringUtil.objectToString(request.getParameter("constCode"));
            gubun = "CONST_SITE";
        }
       
        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest( member, gubun,title, title, "","","","");

        
        List<StatMySiteInfoRegionSiteResponse> result = managerService.statMySiteInfoRegionSiteResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result);                       // 구분
        model.addAttribute("title", title);                         // 타이틀
        model.addAttribute("nWork", nWork);                         // 총 인원
        model.addAttribute("nSafeEnd", nSafeEnd);                   // 안전 활동 완료
        model.addAttribute("nWorkStopRequest", nWorkStopRequest);   // 작업 중지 요청
        return FieldInformationMapping + "/myFieldInfoField";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoCompany", method = RequestMethod.GET)
    public String myFieldInfoCompany(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoCompany 진입");

        // 로그인 체크
        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");

         // 현장명
        String title = StringUtil.objectToString(request.getParameter("siteName"));
        String siteCode = StringUtil.objectToString(request.getParameter("siteCode"));
        String nWork = StringUtil.objectToString(request.getParameter("nWork"));
        String nSafeEnd = StringUtil.objectToString(request.getParameter("nSafeEnd"));
        String nWorkStopRequest = StringUtil.objectToString(request.getParameter("nWorkStopRequest"));

        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest( member, "REGION_COMPANY","","", siteCode,"", DateFormatter.formatShortDate(), "");
     
        List<StatMySiteInfoRegionCompanyResponse> result = managerService.statMySiteInfoRegionCompanyResponse(stateMySiteInfoRequest);
        
        model.addAttribute("result", result);                       // 구분
        model.addAttribute("title", title);                         // 타이틀
        model.addAttribute("nWork", nWork);                         // 총 인원
        model.addAttribute("nSafeEnd", nSafeEnd);                   // 안전 활동 완료
        model.addAttribute("nWorkStopRequest", nWorkStopRequest);   // 작업 중지 요청

        return FieldInformationMapping + "/myFieldInfoCompany";
    }

    /**
     * MY 현장 정보 메인 페이지
     * @return 현장 정보 리스트 페이지 URL
     */
    @RequestMapping(value = "/myFieldInfoStop", method = RequestMethod.GET)
    public String myFieldInfoStop(HttpServletRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        logger.debug("myFieldInfoStop 진입");

        if (checkLogin(session, redirectAttributes) == false ) return "redirect:/mmb/login";

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");

        String siteCode = StringUtil.objectToString(request.getParameter("siteCode"));
        String companyName = StringUtil.objectToString(request.getParameter("companyName"));

        // 현장 정보 요청 객체 생성 및 설정
        StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest( member, "SITE_WORKSTOP","","", siteCode, companyName, DateFormatter.formatShortDate(), "");
     
        List<StatMySiteInfoWorkStopResponse> result = managerService.statMySiteInfoWorkStopResponse(stateMySiteInfoRequest);
        model.addAttribute("result", result);               //결과
        model.addAttribute("title", companyName);               //결과
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

        // 현재 세션에서 회원 정보 가져오기
        Member member = (Member) session.getAttribute("member");

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.toString(); // "YYYY-MM-DD" 형식의 문자열로 변환

        // 현장 정보 요청 객체 생성 및 설정
        //StateMySiteInfoRequest stateMySiteInfoRequest = createStateMySiteInfoRequest( member, "REGION_COMPANY","", formattedDate, "");
     
        //List<StatMySiteInfoRegionCompanyResponse> result = managerService.statMySiteInfoRegionCompanyResponse(stateMySiteInfoRequest);
        //model.addAttribute("result", result); // 구분
        return FieldInformationMapping + "/myFieldInfoEmployee";
    }

    /**
     * My현장정보 통계 요청 데이터 생성 메서드
     * @param member     현재 세션에서 가져온 회원 정보
     * @param gubun      통계 구분 값
     * @param siteCode   현장 코드 (ST_0000001)
     * @param regionName 지역 이름 설정 (3단 연산자로 변경)
     * @param sdate      시작 날짜
     * @param edate      종료 날짜
     */
    private StateMySiteInfoRequest createStateMySiteInfoRequest( Member member, String gubun, String regionName,String constCode,String siteCode,String companyName, String sdate, String edate) {
        // My현장정보 통계 요청 데이터 객체 생성
        StateMySiteInfoRequest stateMySiteInfoRequest = new StateMySiteInfoRequest();
        // 통계 구분 설정
        stateMySiteInfoRequest.setGubun(gubun);   
        // 사용자 아이디 
        stateMySiteInfoRequest.setUserid(member.getUserid()); 
        // 사용자 구분 값 (관리자, 감독관, 노무자)              
        stateMySiteInfoRequest.setGrade(member.getGrade());
        if(member.getGrade().contains("C2")){
            // 업체 코드 (HYUNDAI, SAMSUNG 등등 업체 이름)
            stateMySiteInfoRequest.setConstCode(member.getConstCode());
        }else{
            // 업체 코드 (HYUNDAI, SAMSUNG 등등 업체 이름)
            stateMySiteInfoRequest.setConstCode(constCode);
        }
        // 지역 구분 값 (sacheon 기타 등등 지역 이름)
        stateMySiteInfoRequest.setSvgCode(member.getSvgCode());
        // 현장 코드 (ST_0000001)
        stateMySiteInfoRequest.setSiteCode(siteCode);
        if(member.getGrade().contains("C1")){
            // 업체 코드 (HYUNDAI, SAMSUNG 등등 업체 이름)
            stateMySiteInfoRequest.setSiteCode(member.getsiteCode());
        }else{
            // 현장 코드 (ST_0000001)
            stateMySiteInfoRequest.setSiteCode(siteCode);
        }
        // 지역 이름 설정 (3단 연산자로 변경)
        stateMySiteInfoRequest.setRegionName(regionName);
        // 회사 이름 
        stateMySiteInfoRequest.setCompnayName(companyName);
        // 날짜 및 페이지 설정
        stateMySiteInfoRequest.setSdate(sdate);
        stateMySiteInfoRequest.setEdate(edate);
        // 생성된 통계 요청 데이터 반환
        return stateMySiteInfoRequest;
    }
}