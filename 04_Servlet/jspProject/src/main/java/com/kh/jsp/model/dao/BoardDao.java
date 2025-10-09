package com.kh.jsp.model.dao;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.jsp.model.vo.Board;

public class BoardDao {
	
	public int insertBoard(Connection conn, Board b) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO BOARD "
                   + "(BOARD_NO, BOARD_TYPE, CATEGORY_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, COUNT, CREATE_DATE, STATUS) "
                   + "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, b.getBoardType());
            pstmt.setInt(2, b.getCategoryNo());
            pstmt.setString(3, b.getBoardTitle());
            pstmt.setString(4, b.getBoardContent());
            pstmt.setInt(5, b.getBoardWriter());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
	
	public ArrayList<Board> selectList(Connection conn) {
        ArrayList<Board> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = "SELECT B.BOARD_NO, B.BOARD_TYPE, B.CATEGORY_NO, "
                   + "B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_WRITER, "
                   + "B.COUNT, B.CREATE_DATE, B.STATUS "
                   + "FROM BOARD B "
                   + "WHERE B.STATUS = 'Y' "
                   + "ORDER BY B.BOARD_NO DESC";

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Board b = new Board();
                b.setBoardNo(rset.getInt("BOARD_NO"));
                b.setBoardType(rset.getInt("BOARD_TYPE"));
                b.setCategoryNo(rset.getInt("CATEGORY_NO"));
                b.setBoardTitle(rset.getString("BOARD_TITLE"));
                b.setBoardContent(rset.getString("BOARD_CONTENT"));
                b.setBoardWriter(rset.getInt("BOARD_WRITER"));
                b.setCount(rset.getInt("COUNT"));
                b.setCreateDate(rset.getDate("CREATE_DATE"));
                b.setStatus(rset.getString("STATUS"));

                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
    }
	
	public Board selectBoard(Connection conn, int boardNo) {
	    Board b = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String sql = "SELECT B.BOARD_NO, B.BOARD_TYPE, B.CATEGORY_NO, C.CATEGORY_NAME, "
	               + "B.BOARD_TITLE, B.BOARD_CONTENT, M.MEMBER_ID AS BOARD_WRITER, "
	               + "B.COUNT, B.CREATE_DATE "
	               + "FROM BOARD B "
	               + "JOIN MEMBER M ON (B.BOARD_WRITER = M.MEMBER_NO) "
	               + "JOIN CATEGORY C ON (B.CATEGORY_NO = C.CATEGORY_NO) "
	               + "WHERE B.BOARD_NO = ? AND B.STATUS = 'Y'";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, boardNo);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            b = new Board();
	            b.setBoardNo(rs.getInt("BOARD_NO"));
	            b.setBoardType(rs.getInt("BOARD_TYPE"));
	            b.setCategoryNo(rs.getInt("CATEGORY_NO"));
//	            b.setCategoryName(rs.getString("CATEGORY_NAME"));
	            b.setBoardTitle(rs.getString("BOARD_TITLE"));
	            b.setBoardContent(rs.getString("BOARD_CONTENT"));
	            b.setBoardWriter(rs.getInt("BOARD_WRITER"));
	            b.setCount(rs.getInt("COUNT"));
	            b.setCreateDate(rs.getDate("CREATE_DATE"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    return b;
	}
}
