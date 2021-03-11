package gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import element.Obstacle;
import element.Source;
import element.Souris;
import map.Grille;

import process.ElementManager;

public class SimulationDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Grille grille;
	private ElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public SimulationDisplay(Grille grille, ElementManager manager) {
		this.grille = grille;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(grille, g);

		for (Souris souris : manager.getSouris()) {
			paintStrategy.paint(souris, g);
		}

		for (Obstacle obstacle : manager.getObstacles()) {
			paintStrategy.paint(obstacle, g);
		}

		for (Source source : manager.getSources()) {
			paintStrategy.paint(source, g);
		}

	}

}