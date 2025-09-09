package com.kh.array;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.print("정수의 개수 : ");
		num1 = sc.nextInt();
		
		int[] numArray = new int[num1];
		
		for(int i = 0; i < numArray.length; i++) {
			numArray[i] = (int)(Math.random() * 1000000) - 1000000;
		}
		
		int min = 0, max = 0;
		for(int i = 0; i < numArray.length; i++) {
			
			for(int j = 0; j < numArray.length; j++) {
				
				if(numArray[i] < numArray[j]) {
					min = numArray[i];
				}
				
				if(numArray[i] < numArray[j]) {
					max = numArray[j];
				}
			}
		}
		
		System.out.print(min + " " + max);
		
		sc.close();
		
	}

}
