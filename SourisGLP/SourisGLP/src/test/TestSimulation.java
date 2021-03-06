package test;

import gui.MainGUI;


public class TestSimulation {
	public static void main(String[] args) {

		MainGUI gameMainGUI = new MainGUI("Mousimulation");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
