package com.kh.polymorphism;

public class CheeseCake extends Cake{
	
	public void milky() {
		System.out.println("CheeseCake milky");
	}
	
	@Override
	public void yummy() {
		System.out.println("CheeseCake yummy");
	}
	
}
