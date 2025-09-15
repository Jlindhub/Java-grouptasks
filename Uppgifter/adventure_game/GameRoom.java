import java.util.ArrayList;

/**
 * A room has a description text that will be written to the screen, and a number of exits.
 */
public class GameRoom {
	private String description;
	private ArrayList<GameItem> items;
	private ArrayList<GameDoor> exits;

	public String readRoom() {
		return description;
	}

	public GameItem getItem(String itemName) {
		for (var item : items) {
			if (item.name().equals(itemName)) {
				return item;
			}
		}
		return null;
	}

	public GameRoom exit(String direction) {
		for (var exit : exits) {
			if (exit.getKeyword().equals(direction) || exit.getKeyword().charAt(0) == exit.getKey()) {
				return exit.getDestination();
			}
		}
		return null;
	}

	public GameRoom(String description, ArrayList<GameDoor> exits) {
		this.description = description;
		this.exits = exits;
	}
}
