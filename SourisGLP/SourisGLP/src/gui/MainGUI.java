package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import configuration.SimulationConfiguration;
import map.Grille;
import process.SimulationBuilder;
import process.ElementManager;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Grille grille;

	private final static Dimension preferredSize = new Dimension(SimulationConfiguration.WINDOW_WIDTH, SimulationConfiguration.WINDOW_HEIGHT);

	private ElementManager manager;

	private SimulationDisplay dashboard;

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		grille = SimulationBuilder.buildMap();
		manager = SimulationBuilder.buildInitMobile(grille);
		dashboard = new SimulationDisplay(grille, manager);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(SimulationConfiguration.SIMULATION_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			manager.nextRound();
			dashboard.repaint();
		}
	}


	/*private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}*/

}
