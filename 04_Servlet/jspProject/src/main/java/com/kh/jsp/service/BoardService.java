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
        int result = new BoardDao().insertBoard(conn, b);
        
        if(result > 0) {
        	commit(conn);
        } else { 
        	rollback(conn);
        }
        
        close(conn);
        return result;
    }
	
	public Board selectBoard(int boardNo) {
        Connection conn = getConnection();
        Board b = new BoardDao().selectBoard(conn, boardNo);
        
        close(conn);
        return b;
    }

	public int updateBoard(Board b) {
	    Connection conn = getConnection();
	    int result = new BoardDao().updateBoard(conn, b);
	    if(result > 0) commit(conn);
	    else rollback(conn);
	    close(conn);
	    return result;
	}
	
}
