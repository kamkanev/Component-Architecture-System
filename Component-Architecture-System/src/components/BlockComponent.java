package components;

public class BlockComponent extends Component {
	
	private boolean isDestrucktable = true;
	private String name = "Dirt";
	private int texture = 0;
	
	public BlockComponent(String name) {
		super();
		this.name = name;
	}
	
	public BlockComponent(String name, boolean canBreak) {
		
		super();
		this.name = name;
		this.isDestrucktable = canBreak;
	}
	
	@Override
	public String toString() {
		return name + " can" + (isDestrucktable ? "" : "not") + " break";
	}

}
