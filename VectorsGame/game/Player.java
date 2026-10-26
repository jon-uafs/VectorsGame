package game;

public class Player {
	
	private int score_;
	private int turn_;
	private String name_;
	
	public Player() 
	{
		this.score_ = 0;
		this.turn_ = 0;
		this.name_ = "Computer";
	}
	
	public void setScore(int score) 
	{
		this.score_ = score;
	}
	
	public int getScore() 
	{
		return this.score_;
	}

}
