package duree;

public class Tours {
	private int nombreTours;
	private Population population;
	public Tours(int nombreTours) {
		this.nombreTours=nombreTours;
	}
	public void exterminatePopulation() {
		if(population.index()==0) {
			nombreTours=0;
		}
	}
	
}
