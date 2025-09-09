package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1, num2, num3;
		
		System.out.println("입력 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		boolean res1, res2, res3, checknum1, checknum2, checknum3;
		
		res1 = num1 == num2;
		res2 = num2 == num3;
		res3 = num1 == num3;
		
		checknum1 = num1 > 0 && num1 <= 6;
		checknum2 = num2 > 0 && num2 <= 6;
		checknum3 = num3 > 0 && num3 <= 6;
		
		if(checknum1 && checknum2 && checknum3) {
			if(res1 && res2) {
				System.out.println(10000 + num1 * 1000 +"원");
			}
			else if(num1 == num2 || num2 == num3) {
				if(res1) {
					System.out.println(1000 + num1 * 100 +"원");
				}
				else if(res2) {
					System.out.println(1000 + num2 * 100 +"원");
				}
				else System.out.println(1000 + num3 * 100 +"원");	
			}
			else {
				int max = Math.max(num1, num2);
				max = Math.max(max, num3);
				System.out.println(max * 100 +"원");
			}
		}
		else System.out.println("주사위의 눈이 아닙니다");
		
		sc.close();
	}

}
