package com.castlebell.lingvo.cs.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.castlebell.lingvo.cs.dao.domain.responese.EmergencyInfo;

/**
 * 고객센터 매퍼
 */
@Mapper
public interface csMapper {

    /**
     * 금일 작업시작하기
     * @return
     */
    List<EmergencyInfo> getEmergencyInfoList(HashMap<String, Object> params);
}