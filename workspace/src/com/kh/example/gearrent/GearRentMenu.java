package com.kh.example.gearrent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GearRentMenu {
	
	GearRentController gc = new GearRentController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== KH 장비 대여 관리 ===");
			System.out.print("1) 장비등록 2) 회원등록 3) 대여 4) 반납 5) 태그검색 \n");
			System.out.println("6) 키워드검색 7) 전체장비 8) 대여중목록 9) 종료");
			System.out.print("메뉴 : ");
			String num = sc.nextLine();
			
			switch(num) {
			case "1":
				addDevice();
				break;
			case "2":
				addMember();
				break;
			case "3":
				borrow();
				break;
			case "4":
				returnItem();
				break;
			case "5":
				findByTag();
				break;
			case "6":
				findByKeyword();
				break;
			case "7":
				printAllDevices();
				break;
			case "8":
				printActiveLoans();
				break;
			case "9":
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}	
		}
	}
	
	public void addDevice() {
		
		System.out.print("유형(1:Camera, 2:Laptop) : ");
		String num2 = sc.nextLine();
		
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("name : ");
		String name = sc.nextLine();
		System.out.print("category : ");
		String category = sc.nextLine();
		System.out.print("tags : ");
		String tag = sc.nextLine();
		tag = tag.replace(" ", "");
		String[] tag2 = tag.split(",");
		Set<String> tags = new HashSet<>(Arrays.asList(tag));
		tags.addAll(Arrays.asList(tag));
		
		switch(num2) {
		case "1":
			Camera ca = new Camera(id, name, category, tags);
			if(id.equals()) {
				
			}
			else {
				gc.addDevice(ca);
				System.out.println("등록 완료");
			}
			break;
		case "2":
			Laptop lt = new Laptop(id, name, category, tags);
			if(id.equals()) {
				
			}
			else {
				gc.addDevice(lt);
				System.out.println("등록 완료");
			}
			break;	
		}
		
	}
	
	public void addMember() {
		
	}
	
	public void borrow() {
		
	}
	
	public void returnItem() {
		
	}
	
	public void findByTag() {
		
	}
	
	public void findByKeyword() {
		
	}
	
	public void printAllDevices() {
		
	}
	
	public void printActiveLoans() {
		
	}
}
