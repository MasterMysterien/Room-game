package Game;

import java.util.ArrayList;

public class OneRoomGame {
	public static Player player;
	
	public static boolean editor = false;
	
	public static ArrayList<Level> levels = new ArrayList<>();
	
	public static int level = 0; 
	
	public static void main(String[] args) {
		levels.add(new Level("Files/LevelOne"));
		
		player = new Player(600, 100, 30, 30, 3);
		
		new Frame();
		
		new Movement();
		
		

	}

}
