package com.kh.test.all;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean fal = false;
		
		String str = new String();
		
		str = sc.next();
		
		if(str.length() < 1 || str.length() > 100) {
			return;
		}
//		for(int i = 0, j = str.length()-1; i < j; i++, j--)		이렇게도 가능
		for(int i = 0; i <= (str.length() / 2); i++) {	
			fal = str.charAt(i) == str.charAt(str.length() - (i+1));
			
			if(fal == false) {
				break;
			}
			
		}
		
		System.out.println(fal == true ? 1 : 0);
		
		
		sc.close();
		
	}

}
