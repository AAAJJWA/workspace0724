package com.kh.practice.loop;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("Case #$d: %d", i, (a+b));
		}
		
		sc.close();

	}

}
