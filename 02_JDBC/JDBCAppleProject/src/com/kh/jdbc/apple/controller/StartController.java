package com.kh.jdbc.apple.controller;

import java.awt.event.*;
import java.util.List;

import javax.swing.JFrame;

import com.kh.jdbc.apple.model.vo.Member;
import com.kh.jdbc.apple.service.MemberService;
import com.kh.jdbc.apple.view.AppleGameStart;
import com.kh.jdbc.apple.view.AppleMapMenu;
import com.kh.jdbc.apple.view.GameRanking;

public class StartController {

	private AppleGameStart ags = new AppleGameStart();

	public StartController() {

    	ags.AppleStartMain();

        // 시작하기 버튼
        ags.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ags.dispose(); // 시작 화면 닫기
                new AppleMapMenu().AppleMainMenu(); // 게임 실행
            }
        });

        // 랭킹 확인 버튼
        ags.getRankingButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Member> rankingList = new MemberService().selectRanking();
                new GameRanking(rankingList); // 새 창 열기
            }
        });

        // 종료 버튼
        ags.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ags.setVisible(true);
    }
	
//	public void GameStart() {
//		
//		ags.getStartButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ags.dispose(); // 시작 화면 닫기
//                new AppleMapMenu().AppleMainMenu(); // 게임 실행
//            }
//        });
//		
//	}
//	
//	public void GameRanking() {
//		
//		ags.getRankingButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                List<Member> rankingList = new MemberService().topRanking();
//                JFrame frame = new JFrame("랭킹");
//                GameRanking.showOnFrame(frame, rankingList);
//            }
//        });
//	}
//	
//	public void GameExit() {
//		
//		ags.getExitButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//	}
	

}
