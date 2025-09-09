package com.kh.example.api;

import java.util.Scanner;

public class Tokenmenu {
	
	TokenController tc = new TokenController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		while(true) {
		System.out.println("1. 지정 문자열");
		System.out.println("2. 입력 문자열");
		System.out.println("3. 프로그램 끝내기");
		
		int i = sc.nextInt();
		sc.nextLine();
		
			switch(i) {
				case 1:
					tokenMenu();
					break;
				case 2:
					inputMenu();
					break;
				case 3:
					System.out.println("프로그램을 종료합니다");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			}
		}
		
	}
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		System.out.println("토큰 처리 전 글자 : " + str);
		System.out.println("토큰 처리 전 개수 : " + str.length());
		
		System.out.print("토큰 처리 후 글자 : " + tc.afterToken(str));
		System.out.println("토큰 처리 후 개수 : " + tc.afterToken(str).length());
		
		System.out.println("모두 대문자로 변환 : " + str.toUpperCase());
		
	}
	
	public void inputMenu() {
		
		System.out.print("문자열을 입력하세요 : ");
		String str1 = sc.next();
		
		System.out.println("첫 글자 대문자 : " + tc.firstCap(str1));
		
		System.out.print("찾을 문자 하나를 입력하세요 : ");
		char ch1 = sc.next().charAt(0);
		sc.nextLine();
		System.out.println(ch1 + " 문자가 들어간 개수 : " + tc.findChar(str1, ch1));
		
	}
	
}
