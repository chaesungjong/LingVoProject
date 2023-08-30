package com.castlebell.lingvo.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.work.dao.ManagerMapper;
import com.castlebell.lingvo.work.dao.domain.request.StateMySiteInfoRequest;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionCompanyResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionSiteResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkAllResponse;

@Service
public class ManagerServiceImpl implements ManagerService{


    @Autowired
    private  ManagerMapper managerMapper;


    @Override
    public StatMySiteInfoWorkAllResponse statMySiteInfoWorkAllResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoWorkAllResponse(statMySiteInfoRequest);
    }

    @Override
    public List<StatMySiteInfoRegionAllResponse> statMySiteInfoRegionAllResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoRegionAllResponse(statMySiteInfoRequest);
    }

    @Override
    public List<StatMySiteInfoRegionSiteResponse> statMySiteInfoRegionSiteResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoRegionSiteResponse(statMySiteInfoRequest);
    }

    @Override
    public List<StatMySiteInfoRegionCompanyResponse> statMySiteInfoRegionCompanyResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoRegionCompanyResponse(statMySiteInfoRequest);
    }

}