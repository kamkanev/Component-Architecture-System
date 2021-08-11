package entities;

import components.Component;

public class Player extends Entity{

	public Player() {
		super();
	}
	
	@Override
	public String toString() {
		String res = "";
		for(Component c : myComponents) {
			res+= c.toString() + "\n";
		}
		
		return "---------------\n" + (res.isEmpty() ? "Empty" : res ) + "\n---------------";
	}
	
}
