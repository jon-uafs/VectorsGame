package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Highscore {
	
	public void loadFile() {
	    String fileName = "highscores.txt";

	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        int count = 0;
	        while ((line = reader.readLine()) != null && count < users.length) {
	            if (line.isBlank()) {
	                continue;
	            }
	            String[] parts = line.split(",");
	            if (parts.length >= 2) {
	                String name = parts[0].trim();
	                int turns = Integer.parseInt(parts[1].trim());
	                users[count] = new User(turns, name);
	                count++;
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Could not read the file: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        System.out.println("Found invalid number in file: " + e.getMessage());
	    }

}
