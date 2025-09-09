package com.kh.jdbc.apple.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.*;

import javax.swing.*;

import com.kh.jdbc.apple.model.vo.Member;
import com.kh.jdbc.apple.service.MemberService;
import com.kh.jdbc.apple.view.AppleButton;
import com.kh.jdbc.apple.view.AppleGameScore;
import com.kh.jdbc.apple.view.GameEnd;
import com.kh.jdbc.apple.view.GameRanking;

public class AppleController {
	
	private Random random;
	private AppleButton ab;
	private AppleGameScore ags;
	private DrawSquare ds = new DrawSquare();
	
	public AppleController() {
		super();
	}

//	public AppleController(AppleButton ab) {
//		super();
//		this.random = new Random();
//		this.ab = ab;
//	}

	public AppleController(AppleButton ab, AppleGameScore ags) {
		super();
		this.random = new Random();
		this.ab = ab;
		this.ags = ags;
		
		AppleClick();
	}
	
	public AppleController(AppleButton ab, AppleGameScore ags, JFrame jframe) {
		super();
		this.random = new Random();
		this.ab = ab;
		this.ags = ags;
		
		this.ds = new DrawSquare();
		
		jframe.setGlassPane(ds);
	    ds.setVisible(true);
	    AppleClick();
	}

	public void AppleNumber() {
		
		int row = ab.getButtons().length;
		int col = ab.getButtons()[0].length;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int num = random.nextInt(9) + 1;
				ab.getButtons()[i][j].setText(String.valueOf(num));
			}
		}
		
	}
	
	public void AppleClick() {
		
		int row = ab.getButtons().length;
		int col = ab.getButtons()[0].length;
		int score = 0;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				JButton btn = ab.getButtons()[i][j];
				btn.addActionListener(new AppleButtonClick(this, ags, i, j, score));
				
			}
		}
		
	}
	
	private int[] firstClick = null;
	
	public void AppleChooseCheck(int row, int col) {
		
		if(firstClick == null) {
	        // 첫 번째 클릭
	        firstClick = new int[]{row, col};
	        System.out.println("첫 클릭 좌표: (" + row + ", " + col + ")");		// 확인용
	    } else {
	        // 두 번째 클릭 → 사각형 테두리 표시
	        int[] secondClick = new int[]{row, col};
	        DrawSquare(firstClick, secondClick);
	        CheckSum(firstClick, secondClick);
	        firstClick = null; // 초기화해서 다음 선택 대기
	    }
		
	}
	
//	public void DrawSquare(int[] start, int[] end) {
//	
//		int row1 = Math.min(start[0], end[0]);
//	    int col1 = Math.min(start[1], end[1]);
//	    int row2 = Math.max(start[0], end[0]);
//	    int col2 = Math.max(start[1], end[1]);
//
//	    JButton[][] buttons = ab.getButtons();
//
//	    // 기존 테두리 초기화
//	    for (int r = 0; r < buttons.length; r++) {
//	        for (int c = 0; c < buttons[0].length; c++) {
//	            buttons[r][c].setBorder(UIManager.getBorder("Button.border"));
//	        }
//	    }
//
//	    // 외곽만 빨간 테두리 적용	    
//	    for(int i = row1; i <= row2; i++) {
//	        for(int j = col1; j <= col2; j++) {
//	            int top = 0, left = 0, bottom = 0, right = 0;
//
//	            if(i == row1) top = 2;        // 위쪽 라인
//	            if(i == row2) bottom = 2;     // 아래쪽 라인
//	            if(j == col1) left = 2;       // 왼쪽 라인
//	            if(j == col2) right = 2;      // 오른쪽 라인
//
//	            if(top + left + bottom + right > 0) {
//	                buttons[i][j].setBorder(BorderFactory.createMatteBorder(
//	                        top, left, bottom, right, Color.RED));
//	            }
//	        }
//	    }
//		
//	}
	
	public void CheckSum(int[] start, int[] end) {
		
		int row1 = Math.min(start[0], end[0]);
	    int col1 = Math.min(start[1], end[1]);
	    int row2 = Math.max(start[0], end[0]);
	    int col2 = Math.max(start[1], end[1]);
		
	    JButton[][] buttons = ab.getButtons();
	    
	    int count = 0;
	    int sum = 0;
	    
	    for(int row = row1; row <= row2; row++) {
	    	for(int col = col1; col <= col2; col++) {
		    	
	    		if(!buttons[row][col].isEnabled()) continue;
	    		
	    		String text = buttons[row][col].getText();
	    		if(text != null && !text.isEmpty()) {
	    			sum += Integer.parseInt(text);
	    		}
	    		
		    }
	    }
	    
	    System.out.println("선택된 영역 합계 : " + sum);
	    
	    if(sum == 10) {
	    	System.out.println("합이 10임");
	    	for(int row = row1; row <= row2; row++) {
		    	for(int col = col1; col <= col2; col++) {
			    	
		    		if(buttons[row][col].isEnabled()) {
			    		buttons[row][col].setText("");
			    		buttons[row][col].setEnabled(false);
		//		    		buttons[row][col].setBorder(null);
			    		count++;
		    		}
			    }
		    }
	    	
	    	ags.updateScore(count);
	    	
	    }
	}
	
	public void DrawSquare(int[] start, int[] end) {
	    int row1 = Math.min(start[0], end[0]);
	    int col1 = Math.min(start[1], end[1]);
	    int row2 = Math.max(start[0], end[0]);
	    int col2 = Math.max(start[1], end[1]);

	    JButton[][] buttons = ab.getButtons();

	    // 첫 번째 버튼과 두 번째 버튼의 실제 위치 좌표 계산
	    Rectangle first = buttons[row1][col1].getBounds();
	    Rectangle last  = buttons[row2][col2].getBounds();

	    // 버튼들이 포함된 패널 기준 좌표 → GlassPane 좌표로 변환
	    Point p1 = SwingUtilities.convertPoint(buttons[row1][col1].getParent(), first.getLocation(), ds);
	    Point p2 = SwingUtilities.convertPoint(buttons[row2][col2].getParent(), last.getLocation(), ds);

	    int x = Math.min(p1.x, p2.x);
	    int y = Math.min(p1.y, p2.y);
	    int w = Math.abs(p1.x - p2.x) + last.width;
	    int h = Math.abs(p1.y - p2.y) + last.height;

	    ds.setRectangle(new Rectangle(x, y, w, h));
	}
	
	private void GameEnd(JFrame jframe) {
	    int score = ags.getScore();
	    // 점수 계산 완료 후 종료 화면 띄우기
	    new GameEnd(score, e -> {
	        GameEnd view = (GameEnd) e.getSource();
	        String userName = view.getUserName();

	        // DB 저장
	        Member m = new Member();
	        m.setUserName(userName);
	        m.setScore(score);
	        new MemberService().insertMember(m);

	        // 랭킹 조회 후 새 창 띄우기
	        List<Member> rankingList = new MemberService().selectRanking();
	        new GameRanking(rankingList);

	        view.dispose();
	        jframe.dispose(); // 게임판 닫기
	    });
	}
	
}
