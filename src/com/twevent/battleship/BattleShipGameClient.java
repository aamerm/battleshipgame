package com.twevent.battleship;
import java.util.Scanner;

public class BattleShipGameClient {

	public static void main(String[] args) {
		BattleShipGame game1= new BattleShipGame();
		Scanner in=new Scanner(System.in);
		game1.setPlayer1(new Player("Player1"));
		game1.setPlayer2(new Player("Player2"));
		
		System.out.println("Enter the size of battle area M*N");
		int m=in.nextInt();
		int n=in.nextInt();
		
		System.out.println("Enter number of ships and their size in A*B");
		int ships=in.nextInt();			
		Ship[] temp=new Ship[ships];
		for(int i=0;i<ships;i++){
			temp[i]=new Ship(in.nextInt(), in.nextInt());
		}
		
		System.out.println("Preparing the BattleField...");
		game1.initBattleAreas(m, n, temp);
	
		int[][] b1=game1.getPlayer1().getBattleArea();
		b1[1][0]=1;b1[1][1]=1;b1[1][2]=1;
		b1[3][0]=1;b1[3][1]=1;b1[4][0]=1;b1[4][1]=1;
		b1[5][2]=1;b1[5][3]=1;b1[5][4]=1;b1[5][5]=1;
		game1.getPlayer1().showBattleArea();
		
		System.out.println("...................");
		int[][] b2=game1.getPlayer2().getBattleArea();
		b2[0][0]=1;b2[0][1]=1;b2[0][2]=1;
		b2[3][2]=1;b2[3][3]=1;b2[4][2]=1;b2[4][3]=1;
		b2[1][5]=1;b2[2][5]=1;b2[3][5]=1;b2[4][5]=1;
		game1.getPlayer2().showBattleArea();
		
		System.out.println("Game begins...");
		game1.startGame(in);		
	}

}
