package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * JDBC를 사용하기 위해서는 자바 프로젝트에 JDBC 드라이버를 추가해줘야 한다
 * 
 * JDBC
 * */

public class Run {
	
//	public static void main(String[] args) {
//		
//		Connection conn = null;		// DB 연결정보 보관 객체
//		Statement stmt = null;		// sql문을 전달해서 실행 후 결과를 받아올 객체
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int result = 0;
//		
//		System.out.println("번호 : ");
//		int tno = sc.nextInt();
//		
//		System.out.println("이름 : ");
//		String tname = sc.next();
//		sc.nextLine();
//		
//		// 실행할 sql문 (완전한 상태로 만듬, sql 뒤에는 ; 이 없어야 함 있으면 에러 남
//		String sql = "INSER INTO TEST VALUES("+tno+", '"+tname+"', SYSDATE)";
//		
//		
//		try {
//			// 1) JDBC Driver 등록
//			// Clss.forName() -> 문자열로 주어진 클래스 이름을 찾아서 JVM 에 로드함
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("OracleDrive 등록성공");
//			
//			// 127.0.0.1 -> 무조건적으로 지금 실행중인 컴퓨터의 ip(localhost)
//			// 2) Connection 생성(db url, 계정명, 비밀번호)
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##JDBC", "JDBC");
//			conn.setAutoCommit(false);
//			
//			// 3) Statement 생성
//			stmt = conn.createStatement();
//			
//			// 4, 5) sql문 전달 후 결과를 받음(insert, update, delete -> 처리된 행 수)
//			result = stmt.executeUpdate(sql);
//			
//			// insert, update, delete -> stmt.executeUpdate : int
//			// select -> stmt.executeQuery : ResultSet
//			
//			// 6) 트랜잭션 처리
//			
//			
//		}	catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}	catch (SQLException e) {
//			e.printStackTrace();
//		}	finally {
//			try { 
//				// 7) 다 쓴 자원 반납(생성의 역순)
//				rset.close();
//				stmt.close();
//				conn.close();
//			}	catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		sc.close();
//		
//		if(list.isEmpty()) {
//			System.out.println("데이터가 없습니다");
//		}
//		else {
//			System.out.println(list);
//		}
//	}
	
	// 3. PreparedStatement 객체 사용 -> sql 문 형태를 먼저 정의하고 각 데이터는 추후에 넣는 방법
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println("수정할 번호를 입력하세요 : ");
		int tno = sc.nextInt();
		
		System.out.println("새로운 이름을 입력하세요 : ");
		String newName = sc.next();
		
		System.out.println("새로운 날짜를 입력하세요(YYYY-MM-DD) : ");
		String newDate = sc.next();
		sc.nextLine();
		
		
//		String sql = "UPDATE TEST SET TNAME = '" + newName + ", TDATE = TO_DATE('" + newDate + "', 'YYYY-MM-DD')" + "WHERE TNO = " + tno;
		
		String sql = "UPDATE TEST SET TNAME = ?, TDATE = TO_DATE(?, 'YYYY-MM-DD') WHERE TNO = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			// 미완성된 sql 문을 전달해서 pstmt 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// pstmt 에 작성하지 않은 값들을 메서드를 통해 완성시키기(? 개수만큼)
			pstmt.setString(1, newName);
			pstmt.setString(2, newDate);
			pstmt.setInt(3, tno);
			
			pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
		}	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			try {
				pstmt.close();
				conn.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(result > 0) {
			System.out.println(result + "개의 행 UPDATE");
		}
		else {
			System.out.println("UPDATE 실패");
		}
		
	}
	
	
}
