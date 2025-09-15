package dag_6.adventure_game;

public class GameItem {
	private String name;
	private String description;

	public String name() {
		return name;
	}

	public GameItem(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
