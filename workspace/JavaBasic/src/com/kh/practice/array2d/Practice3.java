package com.kh.practice.array2d;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		
		int num, x, y, sum;
		sum = 0;
		
		num = sc.nextInt();
		
		// x ≤ i < x+10, y ≤ j < y+10
		for(int i = 0; i < num; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int k = 0; k < 100; k++) {
				for(int o = 0; o < 100; o++) {
					if(x <= k && x+10 > k) {
						if(y <= o && y+10 > o) {
							arr[k][o] = 1;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int k = 0; k < 100; k++) {
				if(arr[i][k] == 1) {
					sum += 1;
				}
			}
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
