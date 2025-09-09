package com.kh.example.oop4;

public class SquareController {
	private Shape s = new Shape();

	public Shape getS() {
		return s;
	}

	public void setS(Shape s) {
		this.s = s;
	}
	
	public double calcPerimeter(double height, double width) {
		s = new Shape(4, height, width); // TODO 타입 알 수 없음
		return s.getWidth() * 2 + s.getHeight() * 2;
	}
	
	public double calcArea(double height, double width) {
		s = new Shape(4, height, width);
		return s.getWidth() * s.getHeight();
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print() {
		return "사각형 " + s.information();
	}

}
