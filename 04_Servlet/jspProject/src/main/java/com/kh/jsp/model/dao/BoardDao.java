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
                   + "(BOARD_NO, "
                   + "BOARD_TYPE, "
                   + "CATEGORY_NO, "
                   + "BOARD_TITLE, "
                   + "BOARD_CONTENT, "
                   + "BOARD_WRITER, "
                   + "COUNT, "
                   + "CREATE_DATE, "
                   + "STATUS) "
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

        String sql = "SELECT "
        		   + "B.BOARD_NO, "
        		   + "B.BOARD_TYPE, "
        		   + "B.CATEGORY_NO, "
                   + "B.BOARD_TITLE, "
                   + "B.BOARD_CONTENT, "
                   + "M.MEMBER_ID AS WRITER_ID, "
                   + "B.COUNT, "
                   + "B.CREATE_DATE, "
                   + "B.STATUS "
                   + "FROM BOARD B "
                   + "JOIN MEMBER M ON (B.BOARD_WRITER = M.MEMBER_NO) "
                   + "WHERE B.STATUS = 'Y' "
                   + "ORDER BY B.BOARD_NO DESC";

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Board b = new Board();
                b.setBoardNo(rset.getInt("BOARD_NO"));
                b.setCategoryNo(rset.getInt("CATEGORY_NO"));
                b.setBoardTitle(rset.getString("BOARD_TITLE"));
                b.setWriterId(rset.getString("WRITER_ID"));
                b.setCount(rset.getInt("COUNT"));
                b.setCreateDate(rset.getDate("CREATE_DATE"));

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
	    ResultSet rset = null;
	    String sql = "SELECT "
	    		   + "B.BOARD_NO, "
	    		   + "B.BOARD_TYPE, "
	    		   + "B.CATEGORY_NO, "
	    		   + "C.CATEGORY_NAME, "
	               + "B.BOARD_TITLE, "
	               + "B.BOARD_CONTENT, "
	               + "B.BOARD_WRITER AS BOARD_WRITER_NO, "
	               + "M.MEMBER_ID AS BOARD_WRITER, "
	               + "B.COUNT, "
	               + "B.CREATE_DATE, "
	               + "A.FILE_NO, "
	               + "A.ORIGIN_NAME, "
	               + "A.CHANGE_NAME, "
	               + "A.FILE_PATH, "
	               + "A.UPLOAD_DATE, "
	               + "A.FILE_LEVEL "
	               + "FROM BOARD B "
	               + "JOIN MEMBER M ON (B.BOARD_WRITER = M.MEMBER_NO) "
	               + "JOIN CATEGORY C ON (B.CATEGORY_NO = C.CATEGORY_NO) "
	               + "LEFT JOIN ATTACHMENT A ON (B.BOARD_NO = A.REF_BNO AND A.STATUS = 'Y') "
	               + "WHERE B.BOARD_NO = ? AND B.STATUS = 'Y'";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, boardNo);
	        rset = pstmt.executeQuery();

	        if (rset.next()) {
	            b = new Board();
	            b.setBoardNo(rset.getInt("BOARD_NO"));
	            b.setBoardType(rset.getInt("BOARD_TYPE"));
	            b.setCategoryNo(rset.getInt("CATEGORY_NO"));
	            b.setCategoryName(rset.getString("CATEGORY_NAME"));
	            b.setBoardTitle(rset.getString("BOARD_TITLE"));
	            b.setBoardContent(rset.getString("BOARD_CONTENT"));
	            b.setBoardWriter(rset.getInt("BOARD_WRITER_NO"));
	            b.setWriterId(rset.getString("BOARD_WRITER"));
	            b.setCount(rset.getInt("COUNT"));
	            b.setCreateDate(rset.getDate("CREATE_DATE"));
	            
	            b.setFileNo(rset.getInt("FILE_NO"));
	            b.setOriginName(rset.getString("ORIGIN_NAME"));
	            b.setChangeName(rset.getString("CHANGE_NAME"));
	            b.setFilePath(rset.getString("FILE_PATH"));
	            b.setUploadDate(rset.getDate("UPLOAD_DATE"));
	            b.setFileLevel(rset.getInt("FILE_LEVEL"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rset);
	        close(pstmt);
	    }
	    return b;
	}
	
	public int updateBoard(Connection conn, Board b) {
	    int result = 0;
	    PreparedStatement pstmt = null;
	    String sql = "UPDATE BOARD SET CATEGORY_NO = ?, BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_NO = ?";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, b.getCategoryNo());
	        pstmt.setString(2, b.getBoardTitle());
	        pstmt.setString(3, b.getBoardContent());
	        pstmt.setInt(4, b.getBoardNo());
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}
	
	public int deleteBoard(Connection conn, int boardNo) {
	    int result = 0;
	    PreparedStatement pstmt = null;
	    String sql = "UPDATE BOARD SET STATUS = 'N' WHERE BOARD_NO = ?";

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, boardNo);
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}
	
	public int insertAttachment(Connection conn, Board b) {
	    int result = 0;
	    PreparedStatement pstmt = null;
	    String sql = "INSERT INTO ATTACHMENT "
	               + "("
	               + "FILE_NO, "
	               + "REF_BNO, "
	               + "ORIGIN_NAME, "
	               + "CHANGE_NAME, "
	               + "FILE_PATH, "
	               + "FILE_LEVEL"
	               + ") "
	               + "VALUES "
	               + "("
	               + "SEQ_FNO.NEXTVAL, "
	               + "?, "
	               + "?, "
	               + "?, "
	               + "?, "
	               + "?"
	               + ")";

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, b.getBoardNo());
	        pstmt.setString(2, b.getOriginName());
	        pstmt.setString(3, b.getChangeName());
	        pstmt.setString(4, b.getFilePath());
	        pstmt.setInt(5, b.getFileLevel());
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}
	
	public int selectBoardNo(Connection conn) {
	    int boardNo = 0;
	    String sql = "SELECT SEQ_BNO.CURRVAL FROM DUAL";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rset = pstmt.executeQuery()) {
	        if (rset.next()) {
	            boardNo = rset.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return boardNo;
	}
	
}
