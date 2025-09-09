package com.kh.abstractclass;

public class Run {
	
	/*
	 * 추상 클래스 : 하나 이상의 추상메서드를 포함하는 클래스
	 * 
	 * abstract 키워드를 명시적으로 class 앞에 붙여서 
	 * 객체 생성 불가 -> 반드시 상속하여 구현 후 사용
	 * 
	 * 용도
	 * 1. 필수기능(일반메서드) + 형식(추상메서드)를 동시
	 * 2. 상속을 통해 자식클래스에서 반드시 구현해야할
	 * 3. 코드 재사용성과 일관성을 높임
	 * 
	 * */
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		
		dog.speak();
		dog.move();
		dog.breathe();
		
		Animal cat = new Cat();
		
		cat.speak();
		cat.move();
		cat.breathe();
	}
}
