import java.util.ArrayList;
/**
 * <h6>Puzzle game, inspired by Colossal Cave Adventure and Myst</h6>
 * <p>
 * The game consists of<br>
 * • {@link GameCharacter characters}<br>
 * • {@link GameRoom rooms}<br>
 * • {@link GameItem items}<br>
 * The player character is the Id of the player by which they move through and interact with the world. A room has a
 * number of exits accessed by directional keywords, and items are things in the world that can be used by or carried
 * by characters.
 * </p>
 */
public class Main {
	private ArrayList<GameCharacter> characters;
	private ArrayList<GameRoom> rooms;
	private ArrayList<GameItem> items;

    // The Id is always the first
    private GameCharacter player() {
			return characters.getFirst();
    }

    public Main(ArrayList<GameCharacter> characters, ArrayList<GameRoom> rooms, ArrayList<GameItem> items) {
			this.characters = characters;
			this.rooms = rooms;
			this.items = items;
    }

		public void run() {

		}

    public static void main(String[] args) {
			var description = """
			A large circular room with non-descript wooden doors in each
			of the cardinal directions (east, west, north, and south).
			A stone plinth stands in the middle of the room.
			""";
			//var roomExit = new GameDoor();
			/* Hmm, now I have to refer to another already made room... before I can make the exit
			 * to this room...??? These parts are all dependent on each other!
			*/
			//GameRoom startingArea = new GameRoom();
			//Main game = new Main();
			//game.run();
	}
}
