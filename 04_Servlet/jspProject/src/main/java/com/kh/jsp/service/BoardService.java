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

}
