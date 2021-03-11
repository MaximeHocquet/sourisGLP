package map;

public class Grille {
	private Block[][] blocks;
	
	private int lignesCount;
	private int colonnesCount;
	
	public Grille(int lignesCount, int colonnesCount) {
		this.colonnesCount=colonnesCount;
		this.lignesCount=lignesCount;
		
		blocks= new Block[lignesCount][colonnesCount];
		
		for(int ligneIndex=0; ligneIndex<lignesCount;ligneIndex++) {
			for(int colonneIndex=0; colonneIndex<colonnesCount;colonneIndex++) {
				blocks[ligneIndex][colonneIndex]= new Block(ligneIndex,colonneIndex,"vide");
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}


	public int getColonnesCount() {
		return colonnesCount;
	}

	public int getLignesCount() {
		return lignesCount;
	}
	
	public Block getBlock(int ligne, int colonne) {
		return blocks[ligne][colonne];
	}
	

	public boolean isOnTop(Block block) {
		int ligne = block.getLigne();
		return ligne==0;
	}
	
	public boolean isOnBottom(Block block) {
		int ligne = block.getLigne();
		return ligne==lignesCount -1;
	}
	
	public boolean isOnLeftBorder(Block block) {
		int colonne= block.getColonne();
		return colonne==0;
	}
	public boolean isOnRightBorder(Block block) {
		int colonne=block.getColonne();
		return colonne == colonnesCount-1;
	}
}
