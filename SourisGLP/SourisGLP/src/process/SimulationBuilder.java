package process;

import configuration.SimulationConfiguration;
import map.Grille;

public class SimulationBuilder {
	public static Grille buildMap() {
		return new Grille(SimulationConfiguration.LINE_COUNT, SimulationConfiguration.COLUMN_COUNT);
	}

	public static ElementManager buildInitMobile(Grille grille) {
		ElementManager manager = new ElementManager(grille);

		/*first round*/
		for (int i=0;i<SimulationConfiguration.NUMBER_SOURIS;i++) {
			manager.generateSouris();
		}
		
		for(int i=0;i<SimulationConfiguration.NUMBER_OBSTACLE;i++) {
			manager.generateObstacle();
			
		}
		for(int i=0;i<SimulationConfiguration.NUMBER_SOURCE;i++) {
			manager.generateSource();
		
		}
		return manager;
	}

}
