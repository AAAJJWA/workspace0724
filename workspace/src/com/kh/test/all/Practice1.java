package com.kh.test.all;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] count = {1, 1, 2, 2, 2, 8};
		int[] find = new int[count.length];
				
		for(int i = 0; i < count.length; i++) {
			find[i] = sc.nextInt();
			
			System.out.print(count[i] - find[i] + " ");
			
		}
		
		
		sc.close();
		
	}

}
