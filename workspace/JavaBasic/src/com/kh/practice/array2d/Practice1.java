package com.kh.practice.array2d;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		int[][] arr2 = new int[N][M];
		
		int num;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = (num = sc.nextInt());
			}
		}
		
//		System.out.println("1번 배열");
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr2[i][j] = (num = sc.nextInt());
			}
		}
		
//		System.out.println("2번 배열");
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(arr2[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println("------출력---------");
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print((arr[i][j] + arr2[i][j]) + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
