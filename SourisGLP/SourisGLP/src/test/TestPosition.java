package test;

import configuration.SimulationConfiguration;
import map.Block;
import map.Grille;
import process.ElementManager;

public class TestPosition {
	
	
	public static int randomColonne(int maxColonne) {
		return (int) (Math.random()*(maxColonne+1));
	}
	
	public static int randomLigne(int maxLigne) {
		return (int) (Math.random()*(maxLigne+1));
	}
	
	public static Block generatePosition(int maxColonne,int maxLigne) {
		Block position=new Block(randomColonne(maxColonne),randomLigne(maxLigne),"vide");

			return position;

	}
	
	
	public static void main(String[] args) {
		int i=0;
		Grille grille= new Grille(SimulationConfiguration.LINE_COUNT, SimulationConfiguration.COLUMN_COUNT);
		ElementManager manager=new ElementManager(grille);

		
			Block position=generatePosition(SimulationConfiguration.LINE_COUNT,SimulationConfiguration.COLUMN_COUNT);

				System.out.println(position.toString());
	}
	
}
