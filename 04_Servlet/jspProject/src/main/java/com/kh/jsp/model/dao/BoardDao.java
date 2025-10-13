package com.kh.jsp.model.dao;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jsp.common.JDBCTemplate;
import com.kh.jsp.model.vo.Board;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		super();
		
		String path = JDBCTemplate.class.getResource("/db/sql/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertBoard(Connection conn, Board b) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertBoard");

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

        String sql = prop.getProperty("selectList");

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Board b = new Board();
                b.setBoardNo(rset.getInt("BOARD_NO"));
                b.setCategoryNo(rset.getInt("CATEGORY_NO"));
                b.setCategoryName(rset.getString("CATEGORY_NAME"));
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
	    String sql = prop.getProperty("selectBoard");
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
	            b.setWriterId(rset.getString("WRITER_ID"));
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
	    String sql = prop.getProperty("deleteBoard");

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
	    String sql = prop.getProperty("insertAttachment");

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
	    String sql = prop.getProperty("selectBoardNo");
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
	
	public int increaseCount(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
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
	
}
