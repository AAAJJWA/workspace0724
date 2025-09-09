package com.kh.operator;

import java.util.Scanner;

public class Practice2 {
	
	/*
	 * 키보드로 정수 두개를 입력받아 두 수의 합, 차, 곱, 나누기, 나머지 값을 출력
	 * 
	 * [출력]
	 * 첫번째 정수 : 
	 * 두번째 정수 :
	 * 
	 * 더하기 :
	 * 빼기 :
	 * 곱하기 :
	 * 나누기 :
	 * 나머지 :
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("더하기 : " + (num1 + num2));
		System.out.println("빼기 : " + (num1 - num2));
		System.out.println("곱하기 : " + (num1 * num2));
		System.out.println("나누기 : " + (num1 / num2));
		System.out.println("나머지 : " + (num1 % num2));

	}

}
