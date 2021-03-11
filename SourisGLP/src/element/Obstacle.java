package element;

import map.Block;

public class Obstacle extends Element{
	private String type;
	/*String mur, piege or source*/
	public Obstacle(Block position,String type) {
		super(position);
		this.type=type;
	}
	public String getType() {
		return type;
	}
	
}
