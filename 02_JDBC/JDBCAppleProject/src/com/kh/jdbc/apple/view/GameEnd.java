package com.kh.jdbc.apple.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameEnd extends JFrame{

	private JTextField nameField;
    private JButton saveButton;
    private JLabel scoreLabel;

    public GameEnd(int score, ActionListener saveListener) {
        setTitle("게임 종료");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        // 점수 표시
        scoreLabel = new JLabel("당신의 점수: " + score, SwingConstants.CENTER);
        panel.add(scoreLabel);

        // 이름 입력
        nameField = new JTextField("이름 입력");
        panel.add(nameField);

        // 저장 버튼
        saveButton = new JButton("저장하기");
        saveButton.addActionListener(e -> {
            // 버튼 눌렀을 때 Controller로 이벤트 전달
            if (saveListener != null) {
                e.setSource(this); // 이벤트 source를 view로 전달
                saveListener.actionPerformed(e);
            }
        });
        panel.add(saveButton);

        add(panel);
        setVisible(true);
    }

    public String getUserName() {
        return nameField.getText();
    }
	
}
