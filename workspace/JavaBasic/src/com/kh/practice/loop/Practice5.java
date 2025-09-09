package com.kh.practice.loop;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, num;
		
		while(true) {
			System.out.printf("정수 입력 : ");
			num = sc.nextInt();
			if(num < 0) {break;}
			sum += num;
		}
		
		System.out.println("총 합 : " + sum);
	}

}
