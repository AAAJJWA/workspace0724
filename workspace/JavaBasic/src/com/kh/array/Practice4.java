package com.kh.array;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[] students = new int[28];
		
		for(int i = 0; i < students.length; i++) {
			students[i] = sc.nextInt();
		}
			
		boolean[] check = new boolean[30];
		
		for(int i = 0; i < students.length; i++) {
			for(int j = 1; j <= 30; j++) {
				if(students[i] == j) {
					check[j-1] = true;
					break;
				}
			}
		}
		
		
		
		for(int i = 0; i < check.length; i++) {
			if(check[i] == false) {
				System.out.println(i+1);
			}
		}
		
		sc.close();
	}

}
