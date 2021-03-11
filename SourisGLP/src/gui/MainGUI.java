package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import configuration.SimulationConfiguration;
import duree.Tours;
import gui.instrument.ChartManager;
import map.Grille;
import process.SimulationBuilder;
import process.ElementManager;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private JPanel statsPanel = new JPanel();
	
	private Grille grille;
	
	private final static Dimension preferredSize = new Dimension(SimulationConfiguration.WINDOW_WIDTH, SimulationConfiguration.WINDOW_HEIGHT);
		
	private ElementManager manager;
	
	private ChartManager chartManager;
	
	private ChartPanel typeCountBar;
	
	private SimulationDisplay dashboard;
	
	

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
		
		grille = SimulationBuilder.buildMap();
		manager = SimulationBuilder.buildInitMobile(grille);
		dashboard = new SimulationDisplay(grille, manager);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard);
		
		statsPanel.setLayout(new GridLayout(1, 3));
		
		chartManager = new ChartManager(manager);
		typeCountBar = new ChartPanel(chartManager.getTypeCountBar());

		statsPanel.add(typeCountBar);

		
		contentPane.add(statsPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		int duree=0;
		Tours tours=new Tours(SimulationConfiguration.SIMULATION_DURATION,null);
		
		while (duree!=SimulationConfiguration.SIMULATION_DURATION) {
			try {
				Thread.sleep(SimulationConfiguration.SIMULATION_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			tours.setPopulation(manager.getSouris());
			tours.exterminatePopulation();
			if(tours.getNombreTours()!=0) {
				manager.nextRound();
				dashboard.repaint();
				duree++;
			}
			else {
				duree=SimulationConfiguration.SIMULATION_DURATION;
			}
		}
	}
}
