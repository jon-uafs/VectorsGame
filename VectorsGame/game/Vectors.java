package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vectors {
	
	Scoring scoring = new Scoring();
	Highscores hs = new Highscores();
	
	public String[][] gameGrid = new String[8][8];
	public Scanner console = new Scanner(System.in);
	Player player1;
	Player player2 = new Player();
	ComputerPlayer comp = new ComputerPlayer();
	int currentTurn;
	int maxTurns = 20;
	
	public void run() 
	{
		String playerInput = "";
		
		try {
			
			drawIntro();
			
			while(playerInput.isBlank() || playerInput.isEmpty()) 
			{
				System.out.println("Please enter Player 1's name: ");
				playerInput = playerInput();
				
				if (playerInput.isEmpty()) 
				{
					System.out.println("You gotta type something.");				
				}
				else 
				{
					player1 = new Player(playerInput);
				}
			}
			
			playerInput = "";
			
			popArray(gameGrid);
			
			player1.setIsTurn(true);
			
			while(currentTurn <= maxTurns) 
			{
				drawGame();
				System.out.println("Please enter coordinates for where would like to place your marker: ");
				player1Turn();
				
				player2Turn();
				
				currentTurn++;
				
			}
			
			System.out.println("Player Final Score: " + player1.getScore());
			System.out.println("Computer Final Score: " + player2.getScore());
			
			
			if(player1.getScore() > player2.getScore()) 
			{
				System.out.println("Congrats! You beat the AI! Thanks for scoring a point for humanity.");
			}
			else 
			{
				System.out.println("You lost to the computer. AI is going to take over. We're doomed. Thanks for that.");
			}
		
		}
		catch(NullPointerException e) 
		{
			System.out.println("Stop typing weird stuff");
			System.out.println(e.getMessage());
		}
		 catch (InputMismatchException e) 
		{
        	e.toString();
            System.out.println("Invalid input. Please enter numbers only.");
        }
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("You entered coordinates that are out of bounds. Try again.");
			System.out.println(e.toString());
		}
		catch(Exception e) 
        {
        	System.out.println(e.toString());
        	System.out.print("I'm not sure what you did, but it was wrong.");
        }
		
	}
	
	public void popArray(String[][] gameGrid) 
	{
		String value = "-";
		
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
		String input = console.nextLine().trim();
		
		return input;
	}
	
	public boolean validCheck(String input) 
	{
		boolean isValid = false;
		boolean correctLength = false;
		boolean correctType = false;
		boolean inBounds = false;
		char compare;
		char[] inputArray = input.toCharArray();
		
		
		if (input.length() == 2) 
		{
			correctLength = true;
		}
		
		for(int i = 0; i < inputArray.length; i++) 
		{
			compare = inputArray[i];
			if(!Character.isDigit(compare)) 
			{
				correctType = false;
				break;
			}else {
				correctType = true;				
			}
		}
		
		if (inputArray[0] >= '0' && inputArray[0] <= '7' && inputArray[1] >= '0' && inputArray[1] <= '7') 
			{
			    inBounds = true;
			}
		
		
		if (correctLength && correctType && inBounds) 
		{
			isValid = true;
		}		
				
		return isValid;
	}
	
	public void player1Turn() 
	{
	    boolean validMove = false;

	    while (!validMove) 
	    {
	        String playerInput = playerInput();

	        if (playerInput.isEmpty()) 
	        {
	            System.out.println("You gotta type something.");
	            continue;
	        }

	        if (!validCheck(playerInput)) 
	        {
	            System.out.println("Invalid format. Please enter two digits between 0 and 7 (e.g., '02').");
	            continue;
	        }

	        int coordRow = playerInput.charAt(0) - '0';
	        int coordCol = playerInput.charAt(1) - '0';

	        if (!gameGrid[coordRow][coordCol].equals("-")) 
	        {
	            System.out.println("That spot is already occupied! Pick another.");
	            continue;
	        }

	        gameGrid[coordRow][coordCol] = player1.getSymbol();
	        validMove = true;
	    }

	    player1.setScore(scoring.calculateTotalScore(gameGrid, player1.getSymbol()));
	    player1.setIsTurn(false);
	    player2.setIsTurn(true);
	}
	
	public void player2Turn() 
	{
		int[] moveCoords = new int[2];
		moveCoords = comp.findBlockingMove(gameGrid);
		
		int coordRow = moveCoords[0];
		int coordCol = moveCoords[1];
		
		if(!(moveCoords[0] == -1)) 
		{
			gameGrid[coordRow][coordCol] = player2.getSymbol();
		}
		
		player2.setScore(scoring.calculateTotalScore(gameGrid, player2.getSymbol()));
		
		player2.setIsTurn(false);
		player1.setIsTurn(true);
		
	}
	
	public void drawIntro() 
	{
		System.out.println("*************************");
		System.out.println("- V E C T O R S         *");
		System.out.println("*************************");
		System.out.print("High Score: ");
		hs.readHighScores();
		System.out.println();
	}
	
	
	public void drawGame() 
	{	
		System.out.println("*************************");
		System.out.printf("-%s's Score: %d  Last Round:  10\n",player1.getName(),player1.getScore());
		System.out.printf("-Computer Score: %d  Last Round: 3\n",player2.getScore()); 
		System.out.println("*************************");
		System.out.printf("-Turn %d of %d\n",currentTurn,maxTurns);
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
