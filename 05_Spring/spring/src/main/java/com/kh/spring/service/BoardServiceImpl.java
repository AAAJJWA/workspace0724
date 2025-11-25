package com.kh.spring.service;

import com.kh.spring.model.mapper.BoardMapper;
import com.kh.spring.model.vo.Board;
import com.kh.spring.model.vo.Category;
import com.kh.spring.model.vo.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<Category> getCategories() {
        return boardMapper.selectCategories();
    }

    @Override
    public Map<String, Object> getBoardList(int currentPage) {
        int listCount = boardMapper.selectBoardListCount();

        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);

        int offset = (currentPage - 1) * pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());

        ArrayList<Board> list = (ArrayList)boardMapper.selectBoardList(rowBounds);

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("pi", pi);

        return map;
    }

    // spring에서 기본적으로 mvc 패턴을 사용하고
    // service 계층에서는 하나의 기능을 정의하며, dao에서는 개별 sql 단위로 처리되므로
    // 업무단위인 서비스 계층에 트랜잭션을 걸어준다
    @Override
    @Transactional
    public int insertBoard(Board board, MultipartFile file) {
       int result = boardMapper.insertBoard(board);

       if(result > 0 && file != null && !file.isEmpty()) {
           log.info("boardNo : {}", board.getBoardNo());
           Attachment at = new Attachment();
       }

        return 0;
    }
}
