package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Board;

public class BoardService {
	
	public ArrayList<Board> selectList() {
        Connection conn = getConnection();
        
        ArrayList<Board> list = new BoardDao().selectList(conn);
        
        close(conn);
        return list;
    }
	
	public int insertBoard(Board b) {
        Connection conn = getConnection();
        int result1 = new BoardDao().insertBoard(conn, b);
        
        int result2 = 1;
        
        if (result1 > 0 && b.getOriginName() != null) {
            int boardNo = new BoardDao().selectBoardNo(conn);
            b.setBoardNo(boardNo);
            result2 = new BoardDao().insertAttachment(conn, b);
        }
        
        
        if(result1 > 0 && result2 > 0) {
        	commit(conn);
        } else { 
        	rollback(conn);
        }
        
        close(conn);
        return (result1 * result2);
    }
	
	public Board selectBoard(int boardNo) {
        Connection conn = getConnection();
        
        int result = new BoardDao().increaseCount(conn, boardNo);
        Board b = new BoardDao().selectBoard(conn, boardNo);

        if (result > 0) commit(conn);
        else rollback(conn);

        close(conn);
        return b;
    }

	public Board updateBoard(Board b) {
	    Connection conn = getConnection();
	    int result = new BoardDao().updateBoard(conn, b);
	    
	    Board updateBoard = null;
	    if(result > 0) { 
	    	commit(conn);
	    	updateBoard = new BoardDao().selectBoard(conn, b.getBoardNo());
	    } else {
	    	rollback(conn);
	    }
	    
	    close(conn);
	    return updateBoard;
	}
	
	public int deleteBoard(int boardNo) {
	    Connection conn = getConnection();
	    int result = new BoardDao().deleteBoard(conn, boardNo);

	    if (result > 0) commit(conn);
	    else rollback(conn);

	    close(conn);
	    return result;
	}
	
}
