package com.kh.jdbc.apple.service;

import static com.kh.jdbc.apple.common.JDBCTemplate.close;
import static com.kh.jdbc.apple.common.JDBCTemplate.commit;
import static com.kh.jdbc.apple.common.JDBCTemplate.getConnection;
import static com.kh.jdbc.apple.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.apple.model.dao.MemberDao;
import com.kh.jdbc.apple.model.vo.Member;

/*
 * Service
 * 트랜잭션 관리와같은 비즈니스 로직을 처리하는 계층, Dao와 Contoller의 중간역할
 */
public class MemberService {
	
	private MemberDao md = new MemberDao();
	
	public MemberService() {
		super();
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public List<Member> selectMemberList(){
		Connection conn = getConnection();
		
		List<Member> list = md.selectMemberList(conn);
		close(conn);
		
		return list;
	}

	public List<Member> selectRanking() {
	    Connection conn = getConnection();
	    
	    ArrayList<Member> list = new MemberDao().selectRanking(conn);
	    close(conn);
	    
	    return list;
	}
	
}
