public class GameItem {
	private String name;
	private String description;

	public String name(){
		return name;
	}

    public String readItem() {
        return description;
    }

	public GameItem(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
