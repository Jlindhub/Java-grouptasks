package dag_6.adventure_game;

import java.util.ArrayList;

/**
 * Characters have a number of functions to interact with the world. They can carry items, and move from room to room
 * via doors.
 */
public class GameCharacter {
	private ArrayList<GameItem> inventory;
	private GameRoom location;

	public void Take(String itemName) {

	}

	public void Go(String direction) {
		GameRoom destination = location.exit(direction);
		if (destination != null) {
			location = destination;
		}
	}
}
