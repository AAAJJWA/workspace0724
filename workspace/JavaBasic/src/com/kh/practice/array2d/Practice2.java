package com.kh.practice.array2d;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		int num, x, num1, num2;
		num1 = 0;
		num2 = 0;
		x = Integer.MIN_VALUE;
		
		// 배열 값 입력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = (num = sc.nextInt());
			}
		}
		
		// 최댓값확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(x < arr[i][j]) {
					x = arr[i][j];
				}
			}
		}
		
		//최댓값 행 번호, 열 번호 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(x == arr[i][j]) {
					num1 = i + 1;
					num2 = j + 1;
				}
			}
		}
		System.out.println(x);
		System.out.print(num1 + " " + num2);
		
		sc.close();
	}

}
