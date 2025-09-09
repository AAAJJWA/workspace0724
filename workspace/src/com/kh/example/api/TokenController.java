package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str, " ");
		
		StringBuilder sb = new StringBuilder();
		
		while(stn.hasMoreTokens()) {
	    	sb.append(stn.nextToken());
		}
		
		return sb.toString();
	}
	
//	public String firstCap(String input) {
//		char[] arr = input.toCharArray();
//		arr[0] = input.toUpperCase().charAt(0);
//		
//		String capstr = "";
//		
//		for(char st : arr) {
//			capstr = capstr + st;
//		}
//		return capstr;
//	}
	
	public String firstCap(String input) {
		char first = input.toUpperCase().charAt(0);
		
		return first + input.substring(1);
	}
	
	public int findChar(String input, char one) {
		
		int count = 0;
		
		char[] arr = input.toCharArray();
		
		for(char st : arr) {
			if(st == one) {
				count++;
			}
		}
		
		return count;
	}
}
