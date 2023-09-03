package com.castlebell.lingvo.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castlebell.lingvo.work.dao.ManagerMapper;
import com.castlebell.lingvo.work.dao.domain.request.IllegalInfoModify;
import com.castlebell.lingvo.work.dao.domain.request.StateMySiteInfoRequest;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionCompanyResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionSiteResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoSiteWorkAllCompResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoUserWorkStopResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkStopResponse;

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

    @Override
    public List<StatMySiteInfoWorkStopResponse> statMySiteInfoWorkStopResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoWorkStopResponse(statMySiteInfoRequest);
    }

    @Override
    public List<StatMySiteInfoSiteWorkAllCompResponse> statMySiteInfoSiteWorkAllCompResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoSiteWorkAllCompResponse(statMySiteInfoRequest);
    }

    @Override
    public List<StatMySiteInfoUserWorkStopResponse> statMySiteInfoUserWorkStopResponse(StateMySiteInfoRequest statMySiteInfoRequest) {
        return managerMapper.statMySiteInfoUserWorkStopResponse(statMySiteInfoRequest);
    }
    
    @Override
    public void illegalInfoModify(IllegalInfoModify illegalInfoModify){
        managerMapper.illegalInfoModify(illegalInfoModify);
    }
    

}