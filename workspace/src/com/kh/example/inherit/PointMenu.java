package com.kh.example.inherit;

import java.util.Scanner;

public class PointMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		
		int num;
		
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
		}
	}
	
	public void circleMenu() {
		
		int num;
		
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
			case 1:
				calcCircum();
				break;
			case 2: 
				calcCircleArea();
				break;
			case 9:
				mainMenu();
				return;
			default:
		}
		
	}
	
	public void rectangleMenu() {
		
		int num;
		
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
			case 1:
				calcPerimeter();
				break;
			case 2: 
				calcRectArea();
				break;
			case 9:
				mainMenu();
				return;
			default:
		}

		
	}
	
	private void calcCircleArea() {
		int x, y, radius;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		System.out.print("반지름 : ");
		radius = sc.nextInt();
		sc.nextLine();
		
		System.out.println("면적 : " + cc.calcArea(x, y, radius));	// 면적
	}
	
	private void calcCircum() {
		int x, y, radius;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		System.out.print("반지름 : ");
		radius = sc.nextInt();
		sc.nextLine();
		
		System.out.println("둘레 : " + cc.calcCircum(x, y, radius));	// 둘레
	}
	
	private void calcPerimeter() {
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		System.out.print("너비 : ");
		width = sc.nextInt();
		System.out.print("높이 : ");
		height = sc.nextInt();
		sc.nextLine();
		
		System.out.println("둘레 : " + rc.calcPerimeter(x, y, height, width));	// 둘레
	}
	
	private void calcRectArea() {
		int x, y, width, height;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		System.out.print("너비 : ");
		width = sc.nextInt();
		System.out.print("높이 : ");
		height = sc.nextInt();		
		sc.nextLine();
		
		System.out.println("둘레 : " + rc.calcArea(x, y, height, width));	// 면적
	}
}
