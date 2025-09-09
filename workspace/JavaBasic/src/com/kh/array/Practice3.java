package com.kh.array;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M, i, j, k;
		
		System.out.print("바구니 개수 : ");
		int[] basket = new int[sc.nextInt()];
		
		System.out.print("공 개수 : ");
		M = sc.nextInt();
		
		for(int x = 0; x < M; x++) {
			System.out.print("시작 바구니 번호 : ");
			i = sc.nextInt();
			System.out.print("끝 바구니 번호 : ");
			j = sc.nextInt();
			System.out.print("공의 번호 : ");
			k = sc.nextInt();
			
			for(int y = i - 1; y < j; y++) {
				basket[y] = k;
			}
			System.out.println();
		}
		
		for(int bk : basket) {
			System.out.print(bk + " ");
		}
		
		sc.close();
		
	}

}
