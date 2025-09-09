package com.kh.inherit;

public class TV extends Product{
	
	private int inch;

	public TV(int inch) {
		super();
	}
	
	
	

	public TV(String pName, int price, String brand, int inch) {
		super();
		this.inch = inch;
	}




	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
	
	
}
