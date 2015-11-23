package com.twevent.battleship;

import java.util.Scanner;

class Position{
	int x;
	int y;
	Position(int i, int j){
		this.x=i;
		this.y=j;
	}
}


class BattleShipGame{
	private Player player1;
	private Player player2;
	
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	BattleShipGame(){
		System.out.println("Welcome to BattleShip Game!");
	}
	public void initBattleAreas(int m, int n, Ship[] s){
		player1.initBattleArea(m, n, s);
		player2.initBattleArea(m, n, s);
	}	
	
	public void startGame(Scanner in){
		Player currentPlayer=player1;
		Player otherPlayer;
		while(checkAlive(player1) && checkAlive(player2)){
			System.out.println(currentPlayer.getName() + " - fire the missile");
			String temp=in.next();
			Position pos=getPosition(temp);

			if(pos!=null){
				otherPlayer=currentPlayer.getName().equals("Player1")?player2:player1;
				boolean res=hit(otherPlayer, pos);
				//if true use same player otherwise switch player
				if(!res){ 
					currentPlayer=otherPlayer;
				}
			}
			else {
				System.out.println("Invalid input..Please fire again!");
			}
		}
		System.out.println(currentPlayer.getName() + " wins the game.");
	}
	
	public boolean hit(Player p, Position pos){
		boolean result=false;
		//result=true if ship is there, so update to -1
		
		int[][] temp=p.getBattleArea();
		if(temp[pos.x][pos.y]==1) {
			temp[pos.x][pos.y]=-1;
			result=true;
			p.setBattleArea(temp);
			System.out.println("hits");
			p.showBattleArea();
		}			
		return result;
	}

	//will return corresponding position in battle field matrix area
	public Position getPosition(String temp){
		char[] c=temp.toCharArray();
		int xBattle=player1.getBattleArea().length;
		int yBattle=player1.getBattleArea()[0].length;
		
		if(c.length<=2) {
			int x=c[0]-'A';
			int y=c[1]-'1';
			if(x<=xBattle && y<=yBattle) return new Position(x,y);
		}
		return null;
	}
	
	public boolean checkAlive(Player p){
		//check if matrix does not contain 1, it should have 0 or -1
		//if 1 then return true else false
		for(int[] row : p.getBattleArea()) {
			for (int i : row) {
	            if(i==1) return true;
	        }
        }
		return false;
	}
}
