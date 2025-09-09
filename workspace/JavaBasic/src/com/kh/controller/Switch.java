package com.kh.controller;

import java.util.Scanner;

public class Switch {
	
	/*
	 * switch 문도 if 문과 동일하게 조건문
	 * 
	 * 다만, switch 문은 값이 정확하게 일치(동등비교) 하는 경우에만 사용 됨
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * [표현식]
		 * switch(비교대상(정수, 문자, 문자열)){
		 * case 값1 : 실행코드;
		 * case 값2 : 실행코드;
		 * ...
		 * default : 위의 값이 전부 일치하지 않았을 때 실행할 코드;
		 * }
		 * */

		/*
		 * 정수를 입력해서 1일 경우 빨간색
		 * 2일경우 파란색
		 * 3일경우 초록색
		 * 다른경우 모두 잘못입력했습니다 를 출력
		 * */
		
//		Scanner sc = new Scanner(System.in);
//		
//		int num;
//		System.out.println("정수 입력 : ");
//		num = sc.nextInt();
//		
//		switch(num) {
//		case 1:
//			System.out.println("빨간색");
//			break;
//		case 2:
//			System.out.println("파란색");
//			break;
//		case 3:
//			System.out.println("초록색");
//			break;
//		default : System.out.println("잘못 입력했습니다");
//		}
		
		/*
		 * 과일을 구매하는 프로그램을 작성하자
		 * 구매하고자 하는 과일을 입력하면
		 * 그에 맞는 가격이 출력되는 프로그램
		 * 
		 * [출력]
		 * 구매하고자 하는 과일(사과(2000), 바나나(3000), 딸기(5000) : 
		 * ~의 가격은 ~입니다 / 잘못입력하셧습니다
		 * */
		
//		Scanner sc = new Scanner(System.in);
//		
//		String fruit;
//		System.out.println("구매하고자 하는 과일 (사과(2000), 바나나(3000), 딸기(5000) : ");
//		fruit = sc.next();
//		
//		switch(fruit) {
//		case "사과":
//			System.out.printf("%s의 가격은 %d입니다", fruit, 2000);
//			break;
//		case "바나나":
//			System.out.printf("%s의 가격은 %d입니다", fruit, 3000);
//			break;
//		case "딸기":
//			System.out.printf("%s의 가격은 %d입니다", fruit, 5000);
//			break;
//		default: System.out.println("잘못 입력하셨습니다");
//		}
		
		
		/*
		 * 월을 입력받아서 해당 월에 마지막 일이 며칠인지를 출력하는 프로그램 작성
		 * 
		 * [출력]
		 * 월을 입력하세요 : 
		 * ~월은 ~일까지 있습니다
		 * 1, 3, 5, 7, 8, 10, 12 -> 31일
		 * 2 -> 28일
		 * 4, 6, 9, 11 -> 30일
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월을 입력하세요 : ");
		
		int day1, day2, day3, month;
		day1 = 31;
		day2 = 28;
		day3 = 30;
		
		month = sc.nextInt();
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(month + "월은 " + day1 + "일까지 있습니다");
			break;
		case 2:
			System.out.println(month + "월은 " + day2 + "일까지 있습니다");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(month + "월은 " + day3 + "일까지 있습니다");
			break;
		default: System.out.println(month + "해당 월은 존재하지 않습니다");
		}
		
		
		System.out.println();
	}

}
