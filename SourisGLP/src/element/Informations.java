package element;

import java.util.ArrayList;

public class Informations {
	private ArrayList<Source> sources;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Souris> souris;
	
	public Informations(Source source) {
		this.sources.add(source);
	}
	public Informations(Obstacle obstacle) {
		this.obstacles.add(obstacle);
	}
	
	public Informations(Souris souris) {
		this.souris.add(souris);
	}
}
