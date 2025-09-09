package com.kh.pratice.controll;

import java.util.Scanner;

public class Pracitce1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int point;
		char rank = 'A';
		
		System.out.println("점수를 입력하세요 : ");
		point = sc.nextInt();
		
		if(point >= 90) {
			rank = 'A';
		}
		else if(point >= 80) {
			rank = 'B';
		}
		else if(point >= 70) {
			rank = 'C';
		}
		else if(point >= 60) {
			rank = 'D';
		}
		else if(point >= 0) {
			rank = 'F';
		}
		else System.out.println("음수는 점수가 아닙니다");
		
		sc.close();

		System.out.printf("당신의 성적은 %c입니다", rank);
		
	}

}
