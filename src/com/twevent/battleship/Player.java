package com.twevent.battleship;

import java.util.Random;

class Player{
	private int[][] battleArea;
	private Ship[] ships;
	String name;
	Player(String s){
		this.name=s;
	}
	
	public int[][] getBattleArea() {
		return battleArea;
	}
	public void setBattleArea(int[][] battleArea) {
		this.battleArea = battleArea;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void initBattleArea(int m, int n, Ship[] s){
		battleArea=new int[m][n];
		ships=s;		
		//placeShips(m,n);
	}
	
	public void placeShips(int m, int n){
		Random r =new Random();		
		int x,y;
		for(int i=0;i<ships.length;i++){
			x=r.nextInt(m-ships[i].getI()+1); //random starting x value from possible values, depends on ship x coordinate
			y=r.nextInt(n-ships[i].getJ()+1); //random starting y value from possible values, depends on ship y coordinate
			
			for(int p=x;p<ships[i].getI();p++)
				for(int q=y;q<ships[i].getJ();q++)
					this.battleArea[p][q]=i+1;
		}
	}
	
	public void showBattleArea(){
		for(int[] row : battleArea) {
			for (int i : row) {
	            System.out.print(i);
	            System.out.print("\t");
	        }
	        System.out.println();
        }
	}
}
