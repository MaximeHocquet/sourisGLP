package map;

public class Block {
	private int colonne;
	private int ligne;
	private String statut;
	
	public Block(int ligne, int colonne, String statut) {
		this.colonne=colonne;
		this.ligne=ligne;
		this.statut=statut;
	}
	

	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Block [colonne=" + colonne + ", ligne=" + ligne + ", statut=" + statut + "]";
	}
	public int getColonne() {
		return colonne;
	}
	
	public int getLigne() {
		return ligne;
	}
}
