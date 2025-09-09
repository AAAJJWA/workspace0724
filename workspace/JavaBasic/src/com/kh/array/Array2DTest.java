package com.kh.array;

import java.util.Scanner;

public class Array2DTest {

	public static void main(String[] args) {
		
		// 사용자에게 행(m)과 열(n)을 입력받아
		// 해당 행과 열의 빙고판을 만들어라
		// 다음 행과 열의 들어갈 문자를 각각 모두 입력받아 저장한 뒤
		// 출력
		
		/*
		 * 행 : 2
		 * 열 : 3
		 * 
		 * 1행 1열 : 바나나
		 * 1행 2열 : 배
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		
//		int m, n;
//		
//		System.out.print("행 : ");
//		m = sc.nextInt();
//		System.out.print("열 : ");
//		n = sc.nextInt();
//		
//		String[][] arr = new String[m][n];
//		
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.println(i + "행 " + j + "열 : ");
//				arr[i][j] = sc.next();
//			}
//		}
//		
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.println(i + "행 " + j + "열 : " + arr[i][j]);
//			}
//		}
		
		// 사용자에게 좌석의 행과 열을 입력받아 2차원 배열을 생성
		// 각 좌석에 들어갈 관객의 이름을 입력받아 저장
		// 모두 입력받았으면 좌석표를 출력
		// 행(줄)의 수 : 
		// 열(좌석)의 수 :
		// 1행 1열 : 철수
		// ...
		// "==========좌석표========="
		// 철수 민수 ...
		
		int m, n;
		
		System.out.print("행(줄)의 수 : ");
		m = sc.nextInt();
		System.out.print("열(좌석)의 수 : ");
		n = sc.nextInt();
		
		String[][] name = new String[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(i + "행 " + j + "열 : ");
				name[i][j] = sc.next();
			}
		}
		
		System.out.println("===========좌석표===========");
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(name[i][j] + " ");
			}
		}
		
		
		sc.close();
		
	}

}
