package com.castlebell.lingvo.work.service;

import java.util.List;

import com.castlebell.lingvo.work.dao.domain.request.StateMySiteInfoRequest;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionSiteResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionCompanyResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkAllResponse;

public interface ManagerService {

    /**
     * My현장정보 통계
     */
    StatMySiteInfoWorkAllResponse statMySiteInfoWorkAllResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     */
    List<StatMySiteInfoRegionAllResponse> statMySiteInfoRegionAllResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     */
    List<StatMySiteInfoRegionSiteResponse> statMySiteInfoRegionSiteResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     */
    List<StatMySiteInfoRegionCompanyResponse> statMySiteInfoRegionCompanyResponse(StateMySiteInfoRequest statMySiteInfoRequest);

}
