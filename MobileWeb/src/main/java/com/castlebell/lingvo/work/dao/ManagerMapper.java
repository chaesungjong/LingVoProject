package com.castlebell.lingvo.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.castlebell.lingvo.work.dao.domain.request.IllegalInfoModify;
import com.castlebell.lingvo.work.dao.domain.request.StateMySiteInfoRequest;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionCompanyResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoRegionSiteResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoSiteWorkAllCompResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoUserWorkStopResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkAllResponse;
import com.castlebell.lingvo.work.dao.domain.response.StatMySiteInfoWorkStopResponse;

/**
 * 매니저 관련 프로시저 매퍼
 */
@Mapper
public interface ManagerMapper {
    
    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    StatMySiteInfoWorkAllResponse statMySiteInfoWorkAllResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    List<StatMySiteInfoRegionAllResponse> statMySiteInfoRegionAllResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    
    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    List<StatMySiteInfoRegionSiteResponse> statMySiteInfoRegionSiteResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    List<StatMySiteInfoRegionCompanyResponse> statMySiteInfoRegionCompanyResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    List<StatMySiteInfoWorkStopResponse> statMySiteInfoWorkStopResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    List<StatMySiteInfoSiteWorkAllCompResponse> statMySiteInfoSiteWorkAllCompResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * My현장정보 통계
     * @param statMySiteInfoRequest
     * @return
     */
    List<StatMySiteInfoUserWorkStopResponse> statMySiteInfoUserWorkStopResponse(StateMySiteInfoRequest statMySiteInfoRequest);

    /**
     * 부적합 적발 사진 등록
     * @param illegalInfoModify
     */
    void illegalInfoModify(IllegalInfoModify illegalInfoModify);
}
