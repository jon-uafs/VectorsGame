package game;

public class Player {
	
	private int score_;
	private String name_;
	private String playerSymbol_;
	private boolean isTurn_;
	
	public Player() 
	{
		this.score_ = 0;
		this.name_ = "Computer";
		this.isTurn_ = false;
		this.playerSymbol_ = "c";
	}
	
	public Player(String name) 
	{
		this.score_ = 0;
		this.isTurn_ = false;
		this.name_ = name;
		this.playerSymbol_ = "x";
	}
	
	public void setScore(int score) 
	{
		this.score_ = score;
	}
	
	public int getScore() 
	{
		return this.score_;
	}
	
	public void setName(String name) 
	{
		this.name_ = name;
	}
	
	public String getName() 
	{
		return this.name_;
	}
	
	
	public void setIsTurn(boolean isTurn) 
	{
		this.isTurn_ = isTurn;
	}
	
	public boolean getIsTurn() 
	{
		return this.isTurn_;
	}
	
	public String getSymbol() 
	{
		return this.playerSymbol_;
	}
}
