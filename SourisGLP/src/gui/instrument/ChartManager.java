package gui.instrument;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


import configuration.SimulationConfiguration;
import element.Souris;
import gui.MainGUI;
import map.Grille;
import process.ElementManager;
import process.SimulationBuilder;

public class ChartManager {
	private ElementManager manager;
	private int males=0;
	private int femeles=0;
	private int egoistes=0;
	private int cooperatives=0;
	private int receptives=0;
	private int nihilistes=0;

	public ChartManager(ElementManager manager) {
		
		for (Iterator<Souris> it=manager.getSouris().iterator();it.hasNext();) {
			Souris souris=it.next();
			if(souris.getSexe()=="male") {
				males++;
			}
			if(souris.getSexe()=="femele"){
				femeles++;
			}
			if(souris.getComportement().getCommunication().getDiffuser().getType()=="egoiste") {
				egoistes++;
			}
			if(souris.getComportement().getCommunication().getDiffuser().getType()=="cooperative") {
				cooperatives++;
			}
			if(souris.getComportement().getCommunication().getReceptionner().getType()=="receptive") {
				receptives++;
			}
			if(souris.getComportement().getCommunication().getReceptionner().getType()=="nihiliste") {
				nihilistes++;
			}
		}
	}

	public JFreeChart getTypeCountBar() {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(SimulationConfiguration.NUMBER_SOURIS, "souris", "Souris");
		dataset.setValue(SimulationConfiguration.NUMBER_OBSTACLE, "obstacles", "Obstacle");
		dataset.setValue(SimulationConfiguration.NUMBER_SOURCE, "sources", "Source");
	
		dataset.setValue(males, "sexe", "Male");
		dataset.setValue(femeles, "sexe", "Femele");
		dataset.setValue(egoistes, "diffuser", "Egoiste");
		dataset.setValue(cooperatives, "diffuser", "Cooperative");
		dataset.setValue(receptives, "receptionner", "Receptive");
		dataset.setValue(nihilistes, "receptionner", "Nihiliste");

		return ChartFactory.createBarChart("", "Node type", "Count", dataset, PlotOrientation.VERTICAL, true, true, false);
	}

}
