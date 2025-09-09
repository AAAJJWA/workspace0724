package com.kh.loop;

import java.util.Scanner;

public class Dowhile {

	/*
	 * do-while문
	 * 
	 * do {
	 * 		실행할 코드
	 * } while(조건식);
	 * */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		int num;
//		do {
//			System.out.println("서비스 번호를 입력하세요");
//			System.out.println("1. 추가");
//			System.out.println("2. 삭제");
//			System.out.println("3. 종료");
//			
//			System.out.println("입력 : ");
//			num = sc.nextInt();
//			
//			switch(num) {
//			case 1:
//				//추가하는 로직
//				System.out.println("추가되었습니다");
//				break;
//			case 2:
//				//삭제하는 로직
//				System.out.println("삭제되었습니다");
//				break;
//			case 3:
//				System.out.println("종료합니다");
//				return;
//			default: System.out.println("잘못 입력하셨습니다");
//			}
//			System.out.println("입력 : ");
//			num = sc.nextInt();
//		} while(num != 3); 
		
		// 사용자가 입력한 수를 계속해서 더하는 프로그램 작성
		// 단, 사용자가 0을 입력하면 종료
		
		int num;
		int num2 = 0;
		
		do {
			num = sc.nextInt();
			num2 += num;
			System.out.println("합 : " + num2);
		} while (num != 0);
		
	}

}
