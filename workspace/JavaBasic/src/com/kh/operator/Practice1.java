package com.kh.operator;

import java.util.Scanner;

public class Practice1 {
	
	/*
	 * 키보드로 가로, 세로값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
	 * 면적 : 가로 * 세로
	 * 둘레 : (가로 + 세로) * 2
	 * 
	 * [출력]
	 * 가로 : (키보드로 입력)
	 * 세로 : (키보드로 입력)
	 * 
	 * 면적 : ~
	 * 둘레 : ~
	 * +소수점 2번째 자리까지 출력
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		float x, y;
		System.out.println("가로 : ");
		x = sc.nextFloat();
		System.out.println("세로 : ");
		y = sc.nextFloat();
		
		System.out.printf("면적 : %.2f" + (x * y));
		System.out.printf("둘레 : %.2f" + ((x+y)*2));

	}

}
