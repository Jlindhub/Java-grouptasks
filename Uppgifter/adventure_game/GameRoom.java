import java.util.ArrayList;

/**
 * A room has a description text that will be written to the screen, and a number of exits.
 */
public class GameRoom extends GameObject {
	private final ArrayList<GameDoor> exits;

	public GameRoom(String name, String description, ArrayList<GameDoor> exits) {
		super(name, description);
		this.exits = exits;
	}
	public GameRoom(String name, String description) {
		super(name, description);
		this.exits = new ArrayList<GameDoor>();
	}
	public GameRoom(String name) {
		super(name);
		this.exits = new ArrayList<GameDoor>();
	}

	public GameRoom addDoor(GameDoor door) {
		this.exits.add(door);
		return this;
	}

	public GameRoom exit(String direction) {
		for (var exit : exits) {
			boolean matchesWord = exit.getKeyword().equalsIgnoreCase(direction.toUpperCase());
			boolean matchesKey = exit.getKey() == (char) Character.toUpperCase((int) direction.charAt(0));
			if (matchesWord || matchesKey) {
				return exit.getDestination();
			}
		}
		return null;
	}
}
