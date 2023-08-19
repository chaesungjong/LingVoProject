package com.castlebell.lingvo.risk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 비상연락망 컨트롤러
 */
@Controller
@RequestMapping("riskcontent")
public class RiskContentController {
	
	private static final Logger logger = LoggerFactory.getLogger(RiskContentController.class);

    @RequestMapping(value = "/riskcontentMain", method=RequestMethod.GET)
	public String riskcontentMain(HttpServletRequest request, 	Model model ,HttpSession session) {

		logger.debug("riskcontentMain 진입");
	    return "riskcontent/riskcontentMain";
	}
    
}
