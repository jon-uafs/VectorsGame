package game;

public class ComputerPlayer {
    public int bestRow = -1;
    public int bestCol = -1;
    
    Scoring scoring = new Scoring();

    public int[] findBlockingMove(String[][] board) {
       
    	String humanSymbol = "x";
    	String compSymbol = "c";
    	String emptySymbol = "-";
    	int[] result = new int[2];
    	
    	
    	int currentHumanScore = scoring.calculateTotalScore(board, humanSymbol);
        
        
        int maxPointsPrevented = 0;
        int fallbackRow = -1;
        int fallbackCol = -1;

        bestRow = -1;
        bestCol = -1;

        for (int r = 0; r < 8; r++) 
        {
            for (int c = 0; c < 8; c++) 
            {
                if (board[r][c].equals(emptySymbol)) 
                {
                    if (fallbackRow == -1) 
                    {
                        fallbackRow = r;
                        fallbackCol = c;
                    }

                    board[r][c] = compSymbol;

                    int newHumanScore = scoring.calculateTotalScore(board, humanSymbol);
                    int pointsPrevented = currentHumanScore - newHumanScore;

                    if (pointsPrevented > maxPointsPrevented) 
                    {
                        maxPointsPrevented = pointsPrevented;
                        bestRow = r;
                        bestCol = c;
                    }

                    board[r][c] = emptySymbol;
                }
            }
        }

        if (bestRow == -1) {
            bestRow = fallbackRow;
            bestCol = fallbackCol;
        }
        
        result[0] = bestRow;
        result[1] = bestCol;
        
        return result;
    }


}
