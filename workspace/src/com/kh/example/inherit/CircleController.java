package com.kh.example.inherit;

public class CircleController {
	
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {	// 면적
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString() + " / " + (Math.PI * (double)radius * (double)radius);
	}
	
	public String calcCircum(int x, int y, int radius) {	// 둘레
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString() + " / " + (Math.PI * (double)radius * 2);
	}
}
