package com.castlebell.lingvo.cs.service;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castlebell.lingvo.cs.dao.csMapper;
import com.castlebell.lingvo.cs.dao.domain.responese.EmergencyInfo;

@Service
public class CustomerServiceCenterImpl implements CustomerServiceCenterService {
    
    private final csMapper customerServiceCenterMapper;

    @Autowired
    public CustomerServiceCenterImpl(csMapper customerServiceCenterMapper) {
        this.customerServiceCenterMapper = customerServiceCenterMapper;
    }

    @Override
    public List<EmergencyInfo> getEmergencyContactList(HttpSession session, String qrCode) {

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("gubun","InfoList");
        result.put("siteCode", qrCode);
        result.put("etcparam", "");

        return customerServiceCenterMapper.getEmergencyInfoList(result);


    }
}
