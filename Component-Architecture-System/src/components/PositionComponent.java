package components;

public class PositionComponent extends Component {
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
	public PositionComponent(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public PositionComponent(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + " ; " + y + " ; " + z + " )";
	}

}
