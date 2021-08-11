package components;

public class LiveComponent extends Component {
	
	private String name = "UdefineD";
	private int health = 100;
	
	public LiveComponent(String name) {
		super();
		this.name = name;
	}
	
	public LiveComponent(String name, int health) {
		super();
		this.name = name;
		this.health = health;
	}
	
	@Override
	public String toString() {
		return name + " >>> " + health;
	}

}
