package com.castlebell.lingvo.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castlebell.lingvo.board.dao.boardMapper;
import com.castlebell.lingvo.board.dao.domain.request.NewsFilter;
import com.castlebell.lingvo.board.dao.domain.response.Board;

/**
 * 공지사항 서비스
 */
@Service
public class BoardServiceImpl  implements BoardService{

    boardMapper bmMapper;

    @Autowired
    public BoardServiceImpl(boardMapper bmMapper) {
        this.bmMapper = bmMapper;
    }

    /**
     * 공지사항 리스트 가져오기
     */
    @Override
    public List<Board> getboardList(NewsFilter newsFilter) {
        return bmMapper.getboardList(newsFilter);
    }

    
}
