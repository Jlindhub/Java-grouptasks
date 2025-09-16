/**
 * A door consists of a Room which is its destination, and a directional keyword which is its trigger.
 */
public class GameDoor {
	private GameRoom destination;
	private String keyword;
	private char key;

	public GameDoor(GameRoom destination, String keyword, char key) {
		this.destination = destination;
		this.keyword = keyword;
		this.key = (char) Character.toUpperCase((int) key);
	}
	public GameDoor(GameRoom destination, String keyword) {
		this(destination, keyword, keyword.charAt(0));
	}
	public GameDoor() { this(null, "", '\0'); }

	public GameRoom getDestination() {
		return this.destination;
	}
	public String getKeyword() {
		return this.keyword;
	}
	public char getKey() { return this.key; }

	public GameDoor setDestination(GameRoom destination) {
		this.destination = destination;
		return this;
	}
	public GameDoor setKeyword(String keyword) {
		this.keyword = keyword;
		return this;
	}
	public GameDoor setKey(char key) {
		this.key = key;
		return this;
	}
}
