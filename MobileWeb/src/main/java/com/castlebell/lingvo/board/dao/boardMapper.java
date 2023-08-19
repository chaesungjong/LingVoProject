package com.castlebell.lingvo.board.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.castlebell.lingvo.board.dao.domain.request.NewsFilter;
import com.castlebell.lingvo.board.dao.domain.response.Board;

/**
 * 공지사항 관련 매퍼
 */
@Mapper
public interface boardMapper {
    
    /**
     * 공지사항 리스트 가져오기
     * @return
     */
    List<Board> getboardList(NewsFilter newsFilter);
}
