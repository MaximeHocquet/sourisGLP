package element;

import map.Block;

public class Souris extends Element{
	private String sexe;
	private Comportement comportement;
	private Memoire memoire;
	private int nourriture;

	public Souris(Block position,String sexe, Comportement comportement, int nourriture, Memoire memoire) {
		super(position);
		this.sexe = sexe;
		this.comportement = comportement;
		this.memoire = memoire;
		this.nourriture=nourriture;
	}
	
	public int getNourriture() {
		return nourriture;
	}
	
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}
	
	public void increment() {
		nourriture++;
	}
	public void decrement() {
		nourriture--;
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
