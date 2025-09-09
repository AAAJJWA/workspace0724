package com.kh.loop;

import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * while문
		 * 
		 * [표현법]
		 * 
		 * while(조건식) {
		 * 		반복할 코드
		 * 		[탈출이 가능한 구죠]
		 * }
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
//		int i = 0;
//		
//		for(i = 0 ; i < 10; i++) {
//			System.out.println("안녕하세요");
//		}
//		
//		while(i < 10) {
//			System.out.println("안녕하세요");
//			i++; //조건에 영향을 주는 증감
//		}
		
		// 사용자가 0을 입력할 때까지 반복해서 입력받아 그대로 출력 -> for
		/*
		 * for(int n = sc.nextInt(); n != 0; n = sc.nextInt()) {
		 * 		System.out.println(n);
		 * }
		 * */
		
//		int n = sc.nextInt();
//		while(n != 0) {
//			System.out.println(n);
//			n = sc.nextInt();
//		}
		
		// 랜덤값(1~100 하나 생성
		// (1~랜덤값까지의 합)
		
//		int random = (int)(Math.random() * 100) + 1;
//		int sum = 0;
//		
//		for(int i = 1; i <= random; i++) {
//			sum += i;
//		}
		
		// 사용자가 0을 입력할 때까지 랜덤값을 하나씩 생성해서 
		// 모두 더한 값을 출력해라
		
//		int choice = sc.nextInt();
//		int sum = 0;
//		
//		while(choice != 0) {	// 0일때까지
//			int random = (int)(Math.random() * 100) + 1;
//			sum += random;
//			choice = sc.nextInt();
//		}
//		
//		System.out.println("지금까지의 총 합 : " + sum);
		
		// -------------------------
		
		int num;
		
		System.out.println("서비스 번호를 입력하세요");
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 종료");
		
		System.out.println("입력 : ");
		num = sc.nextInt();
		while(num != 3) {
			switch(num) {
			case 1:
				//추가하는 로직
				System.out.println("추가되었습니다");
				break;
			case 2:
				//삭제하는 로직
				System.out.println("삭제되었습니다");
				break;
			case 3:
				System.out.println("종료합니다");
				return;
			default: System.out.println("잘못 입력하셨습니다");
			}
			System.out.println("입력 : ");
			num = sc.nextInt();
		}
	}	

}
