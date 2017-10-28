package com.bayviewglen.backtracking;

public class Queen {
	private int row;
	private int col;
	public Queen(int row, int col) {
		this.row = row;
		this.col = col;
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
	
	public boolean conflict(Queen b) {
		boolean output = false;
		if (this.getCol() == b.getCol()) {
			output = true;
		} else if (this.getRow() == b.getRow()) {
			output = true;
		} else if (Math.abs(b.getCol()-this.getCol()) == Math.abs(b.getRow()-this.getRow())) {
			output = true;
		}
		return output;
	}
}