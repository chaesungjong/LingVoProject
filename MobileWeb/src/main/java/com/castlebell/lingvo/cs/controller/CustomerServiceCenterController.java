package com.castlebell.lingvo.cs.controller;

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
import com.castlebell.lingvo.cs.dao.domain.responese.EmergencyInfo;
import com.castlebell.lingvo.cs.service.CustomerServiceCenterService;

/*
 * 고객센터
 */
@Controller
@RequestMapping("cs")
public class CustomerServiceCenterController extends CommonController{

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceCenterController.class);
    private final CustomerServiceCenterService customerServiceCenterService;

    
	@Autowired
    public CustomerServiceCenterController(CustomerServiceCenterService customerServiceCenterService) {
        this.customerServiceCenterService = customerServiceCenterService;
    }

    /**
     * 비상연락망
     * @return
     */
    @RequestMapping(value = "/emrContact", method=RequestMethod.GET)
	public String emrContact(HttpServletRequest request, Model model ,HttpSession session, RedirectAttributes redirectAttributes) {
        
        logger.debug("emrContact 진입");
        
        if(checkLogin( session,redirectAttributes) == false ) {
            return "redirect:/mmb/login"; 
		}

		Member member = (Member) session.getAttribute("member");
		List<EmergencyInfo> list = customerServiceCenterService.getEmergencyContactList(session,member.getsiteCode(), member.getUserid());
		model.addAttribute("list", list);
        
	    return "cs/emrContact";
	}

    /**
     * faq
     * @return
     */
    @RequestMapping(value = "/faq", method=RequestMethod.GET)
	public String faq(RedirectAttributes redirectAttributes) {
        return "cs/faq";
	}
}
