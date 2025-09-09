package com.kh.controller;

import java.util.Scanner;

public class Practice1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 나이를 입력받아
		 * 13세 이하면 : 어린이
		 * 13세 초과 19세 이하 : 청소년
		 * 19세 초과 : 성인
		 * 
		 * [출력]
		 * 나이를 입력 :
		 * ~은 ~에 속합니다
		 * */
		
		int age;
		String ad;
		
		System.out.println("나이를 입력 : ");
		age = sc.nextInt();
		
		if (age <= 13) {
			ad = "어린이";
		}
		else if(age <= 19) {
			ad = "청소년";
		}
		else ad = "성인";
		System.out.println(age + "은 " + ad + "에 속합니다");
	}

}
