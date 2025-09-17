import java.util.ArrayList;
/**
 * <h6>Puzzle game, inspired by Colossal Cave Adventure and Myst</h6>
 * <p>
 * The game consists of<br>
 * • {@link GameCharacter characters}<br>
 * • {@link GameRoom rooms}<br>
 * • {@link GameObject items}<br>
 * The player character is the Id of the player by which they move through and interact with the world. A room has a
 * number of exits accessed by directional keywords, and items are things in the world that can be used by or carried
 * by characters.
 * </p>
 *
 * Redesign idea:<br>
 * All things are... things. GameObject implements this concept. All game objects can hold other game objects in a
 * dynamic list of contents. Rooms are a type of game object that have doors and can not be put into another object's contents.
 * A door is not really a game object, they don't have contents, but hold a reference to a room and a keyword invoked for transit.
 * An object that can use doors to move itself from the contents of one room to the contents of another room is called a mob.
 * The player controls one such mob, and its contents we call inventory.
 */
public class Main {
	private final ArrayList<GameCharacter> characters;
	private final ArrayList<GameRoom> rooms;
	private final ArrayList<GameObject> items;

    // The Id is always the first
    private GameCharacter player() {
			return characters.getFirst();
    }

    public Main() {
			this.characters = new ArrayList<GameCharacter>();
			this.rooms = new ArrayList<GameRoom>();
			this.items = new ArrayList<GameObject>();
    }
// TODO: Implement some kind of helper functions to simplify adding rooms, characters and items to the game
// TODO: Implement player verbs and input prompt
// TODO: Implement a game loop which displays the name and description of the player's current location
// as well as the input prompt
		public void run() {

		}

    public static void main(String[] args) {
			var description = """
			A large circular room with non-descript wooden doors in each
			of the cardinal directions (east, west, north, and south).
			A stone plinth stands in the middle of the room.
			""";
			var name = "Nexus";
			GameRoom startingArea = new GameRoom(name, description);
			startingArea.addDoor(
				new GameDoor(
					new GameRoom(
						"Kitchen",
						"""
						This kitchen is rather cramped. Dirty dishes stand piled high
						on every surface.
						
						The door from which you came is west.
						"""
					).addDoor(new GameDoor(startingArea, "West")),
					"East"
				)
			);
			GameCharacter player = new GameCharacter("Wanderer", "You have no memories of this body", startingArea);
			Main game = new Main();
			game.characters.add(player);
			game.rooms.add(startingArea);
			game.run();
	}
}
