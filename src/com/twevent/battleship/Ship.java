package com.twevent.battleship;

class Ship{
	int i;
	int j;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	Ship(int p, int q){
		this.i=p;
		this.j=q;
	}
}

