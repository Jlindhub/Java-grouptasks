import java.util.ArrayList;

/**
 * All things are game objects. Game objects hold a dynamic list of game objects called contents.
 */
public abstract class GameObject {
	private String name;
	private String description;
	private final ArrayList<GameObject> contents;

	private GameObject(String name, String description, ArrayList<GameObject> contents) {
		this.name = name;
		this.description = description;
		this.contents = contents;
	}
	public GameObject(String name, String description) {
		this(name, description, new ArrayList<GameObject>());
	}
	public GameObject(String name) {
		this(name, "", new ArrayList<GameObject>());
	}

	public final String readName() {
		return this.name;
	}
	public GameObject giveName(String name) {
		this.name = name;
		return this;
	}

	public final String readDescription() {
		return this.description;
	}
	public GameObject giveDescription(String description) {
		this.description = description;
		return this;
	}

	public final GameObject readItem(String name) {
		for (var item : contents) {
			if (item.name.equals(name)) {
				return item;
			}
		}
		return null;
	}
	public GameObject giveItem(GameObject item) {
		contents.add(item);
		return this;
	}
	public GameObject takeItem(GameObject item) {
		contents.remove(item);
		return this;
	}
}
