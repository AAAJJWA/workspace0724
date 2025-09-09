package com.kh.jdbc.apple.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.kh.jdbc.apple.controller.AppleController;
import com.kh.jdbc.apple.controller.AppleTimer;
import com.kh.jdbc.apple.controller.DrawSquare;

// Swing 참고 사이트 https://wikidocs.net/208032

public class AppleMapMenu extends JFrame{
    
	private AppleButton ab = new AppleButton();
	private AppleGameScore ags = new AppleGameScore();
	private AppleController ac;
	private AppleTimer at;
	private DrawSquare ds = new DrawSquare();
	
	public AppleMapMenu() {
		super();
	}
	
	public void AppleMainMenu() {
	
		setTitle("사과 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        add(ab, BorderLayout.CENTER);		// 사과 버튼 레이블 중앙에 배치
        add(ags, BorderLayout.EAST);		// 점수 레이블 우측에 배치
        
        setGlassPane(ds);
        ds.setVisible(true);
        
        ac = new AppleController(ab, ags);
        at = new AppleTimer(ags, ab);

        pack(); // 내부 컴포넌트 크기에 맞춰 창 크기 자동 조절
        setLocationRelativeTo(null); // 화면 중앙 배치
        setVisible(true);
        
        ac.AppleNumber();
        at.UpdateTimer();
		
	}
	
}

