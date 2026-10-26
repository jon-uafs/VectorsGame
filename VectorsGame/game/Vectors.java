package game;

import java.util.Scanner;

public class Vectors {
	
	public String[][] gameGrid = new String[8][8];
	public Scanner console = new Scanner(System.in);
	Player player1 = new Player();
	Player player2 = new Player();
	
	public void run() 
	{
		drawIntro();
		System.out.println("Please enter Player 1's name: ");
		playerInput();
		
		
	}
	
	public void popArray(String[][] gameGrid) 
	{
		String value = "x";
		
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++) 
			{
				gameGrid[i][j] = value;
			}
		}
	}
	
	public String playerInput() 
	{
		String input = console.next();
		
		return input;
	}
	
	public void drawIntro() 
	{
		System.out.println("*************************");
		System.out.println("- V E C T O R S         *");
		System.out.println("*************************");
		System.out.println("High Score: Jon - 150"); //Update with actual info
	}
	
	
	public void drawGame() 
	{
		popArray(gameGrid);
		
		drawIntro();
		System.out.println("*************************");
		System.out.printf("-Player Score: %d  Last Round:  10\n",player1.getScore()); // Update with actual info
		System.out.printf("-Computer Score: %d  Last Round: 3\n",player2.getScore()); // Update with actual info
		System.out.println("*************************");
		System.out.println("-Turn 7 of 20");				// Update with actual info
		System.out.println("*************************");
		System.out.println("  0   1   2   3   4   5   6   7");
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 0\n",gameGrid[0][0],gameGrid[0][1],gameGrid[0][2],gameGrid[0][3],gameGrid[0][4],gameGrid[0][5],gameGrid[0][6],gameGrid[0][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 1\n",gameGrid[1][0],gameGrid[1][1],gameGrid[1][2],gameGrid[1][3],gameGrid[1][4],gameGrid[1][5],gameGrid[1][6],gameGrid[1][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 2\n",gameGrid[2][0],gameGrid[2][1],gameGrid[2][2],gameGrid[2][3],gameGrid[2][4],gameGrid[2][5],gameGrid[2][6],gameGrid[2][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 3\n",gameGrid[3][0],gameGrid[3][1],gameGrid[3][2],gameGrid[3][3],gameGrid[3][4],gameGrid[3][5],gameGrid[3][6],gameGrid[3][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 4\n",gameGrid[4][0],gameGrid[4][1],gameGrid[4][2],gameGrid[4][3],gameGrid[4][4],gameGrid[4][5],gameGrid[4][6],gameGrid[4][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 5\n",gameGrid[5][0],gameGrid[5][1],gameGrid[5][2],gameGrid[5][3],gameGrid[5][4],gameGrid[5][5],gameGrid[5][6],gameGrid[5][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 6\n",gameGrid[6][0],gameGrid[6][1],gameGrid[6][2],gameGrid[6][3],gameGrid[6][4],gameGrid[6][5],gameGrid[6][6],gameGrid[6][7]);
		System.out.println("---------------------------------");
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s | %s | 7\n",gameGrid[7][0],gameGrid[7][1],gameGrid[7][2],gameGrid[7][3],gameGrid[7][4],gameGrid[7][5],gameGrid[7][6],gameGrid[7][7]);
		System.out.println("---------------------------------");
		
		
	}

}
