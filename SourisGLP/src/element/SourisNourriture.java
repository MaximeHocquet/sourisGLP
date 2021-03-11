package element;

public class SourisNourriture {
	private int nourriture;
	public SourisNourriture(int nourriture){
		this.nourriture=nourriture;
	}
	public int getUniteNourriture() {
		return nourriture;
	}
	public void increment() {
		nourriture++;
	}
	public void decrement() {
		nourriture--;
	}
}
