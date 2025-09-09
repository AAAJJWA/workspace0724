package com.kh.jdbc.apple.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kh.jdbc.apple.view.AppleGameScore;

public class AppleButtonClick implements ActionListener{
	
	private AppleGameScore ags;
	private AppleController ac;
	private int row;
	private int col;
	private int score;
	
	public AppleButtonClick(AppleController ac, AppleGameScore ags, int row, int col, int score) {
		super();
		this.ac = ac;
		this.ags = ags;
		this.row = row;
		this.col = col;
		this.score = score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton) e.getSource();
		String text = btn.getText();
		
		int value = 0;
		if(!text.isEmpty()) {
			value = Integer.parseInt(text);
		}
		
		ac.AppleChooseCheck(row, col);
		
		System.out.println("클릭된 버튼: (" + row + "," + col + ") 값 = " + value); // 클릭 확인용
	}
	
	
	
	
	
}
