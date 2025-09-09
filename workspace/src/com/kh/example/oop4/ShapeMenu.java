package com.kh.example.oop4;

import java.util.Scanner;

public class ShapeMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	
	
	public void inputMenu() {
		while(true) {
			System.out.println("==== 도형 프로그램 ====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴번호 : ");
		
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 3:
				triangleMenu();
				break;
			case 4:
				squareMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못된 번호입니다 다시 입력하세요");
			}
		}
	}
	
	public void triangleMenu() {
		while(true) {
			System.out.println();
			System.out.println("==== 삼각형 ====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.println("메뉴번호 : ");
		
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				inputSize(3, 2);
			case 2:
				inputSize(3, 3);
			case 3:
				printInformation(3);
			case 9:
				return;
			}
		}
	}
	
	public void squareMenu() {
		System.out.println();
		System.out.println("==== 사각형 ====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 면적");
		System.out.println("3. 사각형 색칠");
		System.out.println("4. 사각형 정보");
		System.out.println("9. 메인으로");
		System.out.println("메뉴번호 : ");
	
		int select = sc.nextInt();
		sc.nextLine();
	}
	
	public void inputSize(int type, int menuNum) {
		// type -> 3 : 삼각형 / 4 : 사각형
		// menuNum -> 1 : 둘레, 2 : 넓이, 3 : 색상
		
		if(type == 3) {
			switch(menuNum) {
			case 1: {
				System.out.print("높이 : ");
				double height = sc.nextDouble();
				System.out.println("너비 : ");
				double width = sc.nextDouble();
				double perimeter = scr.calcArea(height, width);
				System.out.println("사각형의 둘레 : " + perimeter);
				
				break;
				}
			case 2: {
				System.out.print("높이 : ");
				double height = sc.nextDouble();
				System.out.println("너비 : ");
				double width = sc.nextDouble();
				
				double area;
					if(type == 3) {
						area = tc.calcArea(height, width);
						System.out.println("삼각형의 넓이 : " + area);
					}
					else {
						area = scr.calcArea(height, width);
						System.out.println("사각형의 넓이 : " + area);
					}
				break;
				}
			case 3: {
				System.out.println("색깔을 입력하세요 : ");
				String color = sc.next();
				sc.nextLine();
				
					if(type == 3) { 
						tc.paintColor(color);
					}
					else {
						scr.paintColor(color);
					}
				
				break;
				}
				
			}
		} 
		else if(type == 4) {
			
		}
		
	}
	
	public void printInformation(int type) { 
		System.out.println(type == 3 ? tc.print() : scr.print()) ;
	}
}
