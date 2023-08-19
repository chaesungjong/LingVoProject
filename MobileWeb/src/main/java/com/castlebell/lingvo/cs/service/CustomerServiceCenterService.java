package com.castlebell.lingvo.cs.service;

import java.util.List;
import javax.servlet.http.HttpSession;

import com.castlebell.lingvo.cs.dao.domain.responese.EmergencyInfo;


/**
 * 고객센터 서비스
 */
public interface CustomerServiceCenterService {
    

    /**
     * 비상연락망 리스트 가져오기 
     * @return
     */
    List<EmergencyInfo>  getEmergencyContactList(HttpSession session,String qrCode);
}
