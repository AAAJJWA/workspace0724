package com.kh.jdbc.apple.model.vo;

public class Apple {
	
	private int row;
	private int col;
	private int num;
	
	public Apple(int row, int col, int num) {
		super();
		this.row = row;
		this.col = col;
		this.num = num;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
}
