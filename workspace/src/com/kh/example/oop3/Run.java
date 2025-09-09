package com.kh.example.oop3;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.inform();
		
		Book b2 = new Book("신나는 자바", "KH", "최지원");
		b2.inform();
		
		Book b3 = new Book("스프링의 기초", "한빛", "김수민");
		b3.inform();
	}

}
