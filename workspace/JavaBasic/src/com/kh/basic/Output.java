package com.kh.basic;

public class Output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("안녕하세요");
		
		//System.out.prinf(문자열포맷, 값1, 값2, 값3, 값4)
		String name = "최지원";
		int age = 17;
		System.out.printf("저는 %s이고 나이는 %d입니다", name, age);
		System.out.println("저는 " + name + "이고 나이는 " + age + "살 입니다");
		
		// 포맷 키워드
		/* %d 정수
		 * %c 문자
		 * %s 문자열
		 * %f 실수
		 * 
		 * */

	}

}
