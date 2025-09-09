package com.kh.array;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.print("배열 크기 : ");
		num1 = sc.nextInt();
		System.out.print("정수 X : ");
		num2 = sc.nextInt();
		
		int[] numArray = new int[num1];
		
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = (int)(Math.random() * 10000) + 1;
		}
		
//		for(int num : numArray) {
//			if(num < num2) {
//				System.out.print(num + " ");
//			}
//		}
		
		for(int i = 0; i < numArray.length; i++) {
			if(numArray[i] < num2) {
				System.out.print(numArray[i] + " ");
			}
		}
		
		
		sc.close();

	}

}
