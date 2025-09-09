package com.kh.jdbc.apple.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class AppleGameStart extends JFrame{
	
	private JButton startButton;
    private JButton rankingButton;
    private JButton exitButton;

	public AppleGameStart() {
		super();
	}

	public void AppleStartMain() {
        setTitle("사과 게임 시작 화면");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 설정 (세로 정렬)
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // 버튼 생성
        startButton = new JButton("시작하기");
        rankingButton = new JButton("랭킹 확인");
        exitButton = new JButton("종료");

        // 버튼 추가
        buttonPanel.add(startButton);
        buttonPanel.add(rankingButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

    }

    // Getter 메서드 → Controller에서 이벤트 연결할 수 있도록
    public JButton getStartButton() {
        return startButton;
    }

    public JButton getRankingButton() {
        return rankingButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

}
