package test;

import gui.MainGUI;


public class TestSourisSimulation {
	public static void main(String[] args) {

		MainGUI gameMainGUI = new MainGUI("Mousimulation");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
