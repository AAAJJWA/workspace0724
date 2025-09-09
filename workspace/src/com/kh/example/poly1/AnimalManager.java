package com.kh.example.poly1;

public class AnimalManager {
	
	public static void main(String[] args) {
		
		Animal[] am = new Animal[5];
		
		am[0] = new Dog("호두", 7, "웰시코기");
		am[1] = new Dog("자두", 5, "시바");
		am[2] = new Cat("사과", 3, "검정색");
		am[3] = new Cat("채드", 1, "흰색");
		am[4] = new Dog("호두", 7, "웰시코기");
		
		for(Animal ani : am) {
			ani.speak();
			if(ani instanceof Dog) {
				String breed = ((Dog)ani).getBreed();
				System.out.println("이 강아지의 견종은 " + breed + "입니다");
			}
			else if(ani instanceof Cat) {
				String color = ((Cat)ani).getColor();
				System.out.println("이 고양이의 색상은 " + color + "입니다");
			}
		}
		
		
	}

}
