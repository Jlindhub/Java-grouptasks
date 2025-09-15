package dag_6.adventure_game;

/**
 * A door consists of a Room which is its destination, and a directional keyword which is its trigger.
 */
public class GameDoor {
	private GameRoom destination;
	private String keyword;
	private char key;

	public GameRoom getDestination() {
		return destination;
	}

	public String getKeyword() {
		return keyword;
	}

	public char getKey() {
		return key;
	}

	public GameDoor(GameRoom destination, String keyword, char key) {
		this.destination = destination;
		this.keyword = keyword;
		this.key = key;
	}

	public GameDoor(GameRoom destination, String keyword) {
		this(destination, keyword, keyword.charAt(0));
	}
}
