package element;

import map.Block;

public class Obstacle extends Element{
	private String type;
	/*String murs or piege*/
	public Obstacle(Block position,String type) {
		super(position);
		this.type=type;
	}
	
}
