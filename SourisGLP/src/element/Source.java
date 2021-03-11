package element;

import map.Block;

public class Source extends Element{
	private int nourriture;

	public Source(Block position, int nourriture) {
		super(position);
		this.nourriture = nourriture;
	}

	public int getNourriture() {
		return nourriture;
	}

	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}
	
}
