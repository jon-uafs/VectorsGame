package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Highscores {
	
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

}
