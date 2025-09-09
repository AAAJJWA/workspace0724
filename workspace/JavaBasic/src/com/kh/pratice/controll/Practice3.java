package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int age, price;
		String grade, day;
		
		System.out.println("나이를 입력하세요 : ");
		age = sc.nextInt();
		System.out.println("요일을 입력하세요 : ");
		day = sc.next();
		
		if (age >= 0 && age <= 12) {
			price = 5000;
			grade = "어린이";
		}
		else if (age <= 18) {
			price = 7000;
			grade = "청소년";
		}
		else {
			price = 10000; 
			grade = "성인";
		}
		
		switch(day) {
		case "토": 
		case "일": 
			price = price - (price / 5) ;
			break; 
		}
		System.out.println(grade + "요금입니다 (주말 할인 적용)");
		System.out.println("최종 요금은 " + price + "원입니다");
		
		sc.close();
	}

}
