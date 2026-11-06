package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Scoring {
	
    public void readHighScores() 
    {
    	String fileName = "highscores.txt";
    	String playerName = "";
    	int playerScore = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",");

                playerName = parts[0].trim();
                playerScore = Integer.parseInt(parts[1].trim());
                System.out.println(playerName + " - " + playerScore);
            }
            
            reader.close();

        } catch (IOException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Found invalid number in file: " + e.getMessage());
        }
    	
    }
    
    
    public int horizontalScan(String[][] array, String searchFor) {
        int totalScore = 0;

        for (int row = 0; row < 8; row++) {
            int currentRun = 0;

            for (int col = 0; col < 8; col++) 
            {
                if (searchFor.equals(array[row][col])) {
                    currentRun++;
                    if (currentRun == 5) {
                        totalScore += 5;
                        currentRun = 0;
                    }
                } else {
                    if (currentRun >= 3) {
                        totalScore += currentRun;
                    }
                    currentRun = 0;
                }
            }
            if (currentRun >= 3) {
                totalScore += currentRun;
            }
        }

        return totalScore;
    }
    
    public int verticalScan(String[][] array, String searchFor) {
        int totalScore = 0;

        for (int col = 0; col < 8; col++) {
            int currentRun = 0;

            for (int row = 0; row < 8; row++) {
                if (searchFor.equals(array[row][col])) {
                    currentRun++;

                    if (currentRun == 5) {
                        totalScore += 5;
                        currentRun = 0;
                    }
                } else {
                    if (currentRun >= 3) {
                        totalScore += currentRun;
                    }
                    currentRun = 0;
                }
            }

            if (currentRun >= 3) {
                totalScore += currentRun;
            }
        }

        return totalScore;
    }
    
    public int diagonalDownRightScan(String[][] array, String searchFor) {
        int totalScore = 0;

        for (int startCol = 0; startCol <= 5; startCol++) {
            int currentRun = 0;
            int r = 0;
            int c = startCol;

            while (r < 8 && c < 8) {
                if (searchFor.equals(array[r][c])) {
                    currentRun++;
                    if (currentRun == 5) {
                        totalScore += 5;
                        currentRun = 0;
                    }
                } else {
                    if (currentRun >= 3) {
                        totalScore += currentRun;
                    }
                    currentRun = 0;
                }
                r++;
                c++;
            }
            if (currentRun >= 3) {
                totalScore += currentRun;
            }
        }

        for (int startRow = 1; startRow <= 5; startRow++) {
            int currentRun = 0;
            int r = startRow;
            int c = 0;

            while (r < 8 && c < 8) {
                if (searchFor.equals(array[r][c])) {
                    currentRun++;
                    if (currentRun == 5) {
                        totalScore += 5;
                        currentRun = 0;
                    }
                } else {
                    if (currentRun >= 3) {
                        totalScore += currentRun;
                    }
                    currentRun = 0;
                }
                r++;
                c++;
            }
            if (currentRun >= 3) {
                totalScore += currentRun;
            }
        }

        return totalScore;
    }
    
    public int diagonalDownLeftScan(String[][] array, String searchFor) {
        int totalScore = 0;

        for (int startCol = 2; startCol < 8; startCol++) {
            int currentRun = 0;
            int r = 0;
            int c = startCol;

            while (r < 8 && c >= 0) {
                if (searchFor.equals(array[r][c])) {
                    currentRun++;
                    if (currentRun == 5) {
                        totalScore += 5;
                        currentRun = 0;
                    }
                } else {
                    if (currentRun >= 3) {
                        totalScore += currentRun;
                    }
                    currentRun = 0;
                }
                r++;
                c--;
            }
            if (currentRun >= 3) {
                totalScore += currentRun;
            }
        }

        for (int startRow = 1; startRow <= 5; startRow++) {
            int currentRun = 0;
            int r = startRow;
            int c = 7;

            while (r < 8 && c >= 0) {
                if (searchFor.equals(array[r][c])) {
                    currentRun++;
                    if (currentRun == 5) {
                        totalScore += 5;
                        currentRun = 0;
                    }
                } else {
                    if (currentRun >= 3) {
                        totalScore += currentRun;
                    }
                    currentRun = 0;
                }
                r++;
                c--;
            }
            if (currentRun >= 3) {
                totalScore += currentRun;
            }
        }

        return totalScore;
    }
    
    public int calculateTotalScore(String[][] gameGrid, String playerSymbol) {
        return horizontalScan(gameGrid, playerSymbol)
             + verticalScan(gameGrid, playerSymbol)
             + diagonalDownRightScan(gameGrid, playerSymbol)
             + diagonalDownLeftScan(gameGrid, playerSymbol);
    }
}