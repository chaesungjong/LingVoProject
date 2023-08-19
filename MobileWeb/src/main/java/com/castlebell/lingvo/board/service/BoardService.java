package com.castlebell.lingvo.board.service;

import java.util.List;
import com.castlebell.lingvo.board.dao.domain.request.NewsFilter;
import com.castlebell.lingvo.board.dao.domain.response.Board;

/**
 * 공지사항 서비스
 */
public interface BoardService {

    List<Board> getboardList(NewsFilter newsFilter);
    
}
