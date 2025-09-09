package com.kh.jdbc.apple.view;

import java.awt.*;

import javax.swing.*;

public class AppleGameScore extends JPanel{
	
	private JLabel scoreLabel;
	private JLabel timeLabel;
	private int sumScore = 0;
	
	public AppleGameScore() {
		super();
		
        setLayout(new GridLayout(2, 1, 10, 10));

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));

        timeLabel = new JLabel("Time: 02:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(scoreLabel);
        add(timeLabel);
    
	}
	
	public void updateScore(int score) {
		sumScore += score;
        scoreLabel.setText("Score: " + sumScore);
        
    }

    public void updateTime(String time) {
    	
        timeLabel.setText("Time: " + time);
        
    }
    
    public int getScore() {
        return sumScore;
    }

	
}
