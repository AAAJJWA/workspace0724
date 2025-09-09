package com.kh.jdbc.apple.model.vo;

import java.time.LocalDateTime;

public class Member {
	
	private int userNo;
	private String userName;
	private int score;
	private LocalDateTime enrollDate;
	
	public Member() {
		super();
	}

	public Member(int userNo, String userName, int score, LocalDateTime enrollDate) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.score = score;
		this.enrollDate = enrollDate;
	}

//	public Member(String userName) {
//		super();
//		this.userName = userName;
//	}
//
//	public Member(int userNo, String userName) {
//		super();
//		this.userNo = userNo;
//		this.userName = userName;
//	}
//	
//	public Member(String userName, int score) {
//		super();
//		this.userName = userName;
//		this.score = score;
//	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDateTime getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(LocalDateTime enrollDate) {
		this.enrollDate = enrollDate;
	}	
	
}
