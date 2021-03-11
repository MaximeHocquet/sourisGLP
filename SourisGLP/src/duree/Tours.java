package duree;

import java.util.ArrayList;

import element.Souris;

public class Tours {
	private int nombreTours;
	private ArrayList<Souris> population;
	public Tours(int nombreTours,ArrayList<Souris> population) {
		this.nombreTours=nombreTours;
		this.population=population;
	}
	public void exterminatePopulation() {
		if(population.size()==0) {
			nombreTours=0;
		}
	}
	public int getNombreTours() {
		return nombreTours;
	}
	public void setPopulation(ArrayList<Souris> population) {
		this.population=population;
	}
	
	
}
