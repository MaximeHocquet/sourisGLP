package element;

import map.Block;

public class Souris extends Element{
	private String sexe;
	private Comportement comportement;
	private Memoire memoire;
	private SourisNourriture nourriture;
	
	public Souris(Block position,String sexe, Comportement comportement,SourisNourriture nourriture,
			Memoire memoire) {
		super(position);
		this.sexe = sexe;
		this.comportement = comportement;
		this.memoire = memoire;
	}
	
	public SourisNourriture getNourriture() {
		return nourriture;
	}

	public void setNourriture(SourisNourriture nourriture) {
		this.nourriture = nourriture;
	}

	public String getSexe() {
		return sexe;
	}
	public Comportement getComportement() {
		return comportement;
	}
	public Memoire getMemoire() {
		return memoire;
	}
}
