import java.util.ArrayList;
/**
 * Characters have a number of functions to interact with the world. They can carry items, and move from room to room
 * via doors.
 */
public class GameCharacter extends GameObject {
	private GameRoom location;

	public GameCharacter(String name, String description, GameRoom location) {
		super(name, description);
		this.location = location;
	}
	public GameCharacter(String name, String description) {
		super(name, description);
	}
	public GameCharacter(String name) {
		super(name);
	}

	public void Take(String itemName) {
		GameObject coveted = location.readItem(itemName);
		if (coveted != null) {
			this.giveItem(coveted);
			location.takeItem(coveted);
		}
	}

	public GameObject setLocation(GameRoom location) {
		this.location = location;
		return this;
	}

	public void Go(String direction) {
		location = location.exit(direction);
	}
}
