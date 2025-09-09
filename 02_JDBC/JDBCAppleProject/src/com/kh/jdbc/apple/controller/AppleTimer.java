package com.kh.jdbc.apple.controller;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.Timer;

import com.kh.jdbc.apple.model.vo.Member;
import com.kh.jdbc.apple.service.MemberService;
import com.kh.jdbc.apple.view.AppleButton;
import com.kh.jdbc.apple.view.AppleGameScore;
import com.kh.jdbc.apple.view.GameEnd;


public class AppleTimer {
	
	private AppleGameScore ags;
	private AppleButton ab;
	private Timer timer;
	private int time = 120;
	
	public AppleTimer(AppleGameScore ags, AppleButton ab) {
		super();
		this.ags = ags;
		this.ab = ab;
	}
	
	public void UpdateTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(time >= 0) {
					int min = time/60;
					int sec = time%60;
					ags.updateTime(String.format("%02d:%02d", min, sec));
					time--;
				} else {
					timer.stop();
					EndTimer();
				}
			}
		});
		timer.start();
	}
	
	private void EndTimer() {
		
		int score = ags.getScore(); // 점수 가져오기
		
		// 버튼 비활성화
		JButton[][] buttons = ab.getButtons(); // AppleButton에서 버튼 배열 가져오기
	    for (int i = 0; i < buttons.length; i++) {
	        for (int j = 0; j < buttons[i].length; j++) {
	        	JButton btn = buttons[i][j];

	        	// 1. 포커스 제거 (Tab 키 등으로 이동 불가)
	            btn.setFocusable(false);

	            // 2. ActionListener 제거 → 클릭 이벤트 차단
	            for (ActionListener al : btn.getActionListeners()) {
	                btn.removeActionListener(al);
	            }

	            // 3. rollover(hover) 효과 제거
	            btn.setRolloverEnabled(false);
	            
	        }
	    }
		
		// 게임 종료 화면 표시
		new GameEnd(score, ev -> {
			GameEnd view = (GameEnd) ev.getSource();
			String userName = view.getUserName();

			// DB 저장
			Member m = new Member();
			m.setUserName(userName);
			m.setScore(score);
			new MemberService().insertMember(m);

			view.dispose();
		});
		
	}
	

	
}
