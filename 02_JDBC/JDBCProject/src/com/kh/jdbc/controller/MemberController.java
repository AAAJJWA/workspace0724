package com.kh.jdbc.controller;

import java.util.List;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : View 를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 * 				해당 메서드로 전달된 데이터를 가공한 후 dao 로 전달하여 기능ㅇ르 수행
 * 				dao 로부터 반환받은 결과에 따라서 성공/실패 여부를 판단해서 응답화면 결정 -> View 호출
 * */

public class MemberController {
	private MemberDao md;
	
	public MemberController() {
		super();
		this.md = new MemberDao();
	}
	
	/*
	 * 사용자의 추가 요청을 처리하는 메서드
	 * userId ~ hobby : 사용자가 입력한 정보를 매개변수로 받음
	 * */
	
	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		
		// View로부터 전달받은 값을 바로 dao 에 전달 x
		// vo 에 잘 담아서 전달
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		int result = md.insertMember(m);
		
		if(result > 0) {
			// 성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다");
		}
		else {
			// 실패화면
			new MemberMenu().displayFail("회원추가에 실패하였습니다");
		}
		
	}
	
	public void selectMemberAll() {
		
		List<Member> list = md.selectMemberList();
		
		//조회된 결과에 따라서 사용자가 보게될 화면
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("회원목록 조회결과가 없습니다.");
		}else {
			new MemberMenu().displayList(list, "회원 목록");
		}
	}
	
	// userId, email, phone, address, hobby 를 전달받아
	// Member 를 수정하는 메서드
	public void updateMember(String userId, String email, String phone, String address, String hobby) {
		
		Member m = new Member();
		
		m.setUserId(userId);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = md.updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보를 수정하였습니다");
		} else {
			new MemberMenu().displayFail("회원정보를 삭제하는데 실패하였습니다");
		}
		
	}
	
	public void deleteMember(String userId, String userPwd) {
		
		Member m = new Member();
		
		m.setUserId(userId);
		m.setUserPwd(userPwd);
//		m.setPhone(phone);
//		m.setUserName(userName);
//		m.setEmail(email);
		
		int result = md.deleteMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보를 삭제하였습니다");
		} else {
			new MemberMenu().displayFail("삭제하는데 실패하였습니다");
		}
		
	}

}
