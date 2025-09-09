package com.kh.example.inherit;

public class RectangleController {
	
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {	// 면적
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r.toString() + " / " + (width * height);
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {	// 둘레
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r.toString() + " / " + (2 * (width + height));
	}
}
