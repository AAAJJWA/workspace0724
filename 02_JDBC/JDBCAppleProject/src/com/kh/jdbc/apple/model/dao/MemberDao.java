package com.kh.jdbc.apple.model.dao;

import static com.kh.jdbc.apple.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jdbc.apple.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Member m, Connection conn) {
		//insertMember -> insert -> 처리된 행 수(int)
		
		//필요한 변수 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		//실행할 sql(sql뒤에 ;없어야함!!!)
		String sql = prop.getProperty("insertMember");
		
		try {		
			//아직 미완성 sql문으로 ?의 값을 전부 채워야함
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setInt(2, m.getScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원목록을 반환하는 메서드
	public ArrayList<Member> selectMemberList(Connection conn){
		//select문(여러개) -> ResultSet -> ArrayList담기
		
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>(); //비어있는 상태
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			//완성된 sql
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("TNO"));
				m.setUserName(rset.getString("TNAME"));
				m.setScore(rset.getInt("TPOINT"));
				m.setEnrollDate(rset.getTimestamp("TDATE").toLocalDateTime());
				
				list.add(m);
			}
			
			//반복문이 끝난시점
			// list -> 비어있거나/ 데이터가 들어있거나
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Member> selectRanking(Connection conn) {
	    ArrayList<Member> list = new ArrayList<>();
	    PreparedStatement pstmt = null;
	    ResultSet rset = null;

	    String sql = prop.getProperty("selectRanking");

	    try {
	        pstmt = conn.prepareStatement(sql);
	        rset = pstmt.executeQuery();

	        while (rset.next()) {
	            Member m = new Member();
	            m.setUserNo(rset.getInt("TNO"));
	            m.setUserName(rset.getString("TNAME"));
	            m.setScore(rset.getInt("TPOINT"));
	            m.setEnrollDate(rset.getTimestamp("TDATE").toLocalDateTime());
	            list.add(m);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rset);
	        close(pstmt);
	    }
	    return list;
	}
	
}
