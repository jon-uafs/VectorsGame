package game;

public class Player {
	
	private int score_;
	private String name_;
	private String playerSymbol_;
	
	public Player() 
	{
		this.score_ = 0;
		this.name_ = "Computer";
		this.playerSymbol_ = "c";
	}
	
	public Player(String name) 
	{
		this.score_ = 0;
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
	
	
	public String getSymbol() 
	{
		return this.playerSymbol_;
	}
}
