package com.kh.example.oop7;

import java.util.Scanner;

public class ProductMenu {
	
	private ProductController pc = new ProductController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		int num, price;
		String pName, brand;
		
		System.out.println("===== 상품 관리 메뉴 =====");
		
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 전체 조회");
		System.out.println("9. 프로그램 종료 ");
		System.out.print("메뉴 번호 : ");
		num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		case 1:
			System.out.print("추가할 상품명 : ");
			pName = sc.nextLine();
			System.out.print("추가할 가격 : ");
			price = sc.nextInt();
			System.out.print("추가할 브랜드 : ");
			brand = sc.next();
			sc.nextLine();
			
			pc.insertProduct(pName, price, brand);
			break;
		case 2:
			Product[] pro = pc.selectProduct();
			for(Product p : pro) {
				if(p == null)
					break;
				System.out.println(p.inform());
			}
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		
	}
}
