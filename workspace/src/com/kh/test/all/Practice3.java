package com.kh.test.all;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] alphabet = new char[26];
		int[] sum = new int[26];
		int maxsum = 0;
		int maxnum = 0;
		
		String str = new String();
		
		str = sc.next();
		str = str.toUpperCase();
		
		if(str.length() < 1 || str.length() > 1000000) {
			return;
		}
		
		// 대문자 알파벳 배열 생성
		for(int i = 0; i < 26; i++) {
			alphabet[i] = (char)('A' + i);
			sum[i] = 0;
		}
		
		// 입력 문자열의 사용한 알파벳 개수 확인
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < alphabet.length; j++) {
				if(str.charAt(i) == alphabet[j]) {
					sum[j] += 1;
				}
			}
		}
		
		boolean dup = false;
		
		for(int i = 0; i < 26; i++) {
//			System.out.print(alphabet[i] + " " + sum[i]);
			
			if(maxsum < sum[i]) {
				maxsum = sum[i];
				maxnum = i;
			}
			else if((maxsum == sum[i]) && (sum[i] != 0)) {
//				System.out.print(" " + maxsum + " " + sum[i]);
				dup = true;
			}
//			System.out.println();
		}
		
//		System.out.println(maxsum);
//		System.out.println(dup);
		System.out.println(dup == true ? "?" : alphabet[maxnum] );
		
		
		// 강사님 해설
//		int[] count = new int[26];
//		for(int i = 0; i < str.length(); i++) {
//			int index = str.charAt(i) - 'A';
//			count[index]++;
//		}
//		
//		int max = 0, index = 0;
//		boolean isDupl = false;
//		
//		for(int i = 0; i < count.length; i++) {
//			
//			if(count[i] > max) {
//				max = count[i];
//				index = i;
//				isDupl = false;
//			}
//			else if(count[i] == max) {
//				isDupl = true;
//			}
//		}
//		System.out.println(isDupl ? "?" : (char)(index + 'A'));		
		
		sc.close();
		
	}

}
