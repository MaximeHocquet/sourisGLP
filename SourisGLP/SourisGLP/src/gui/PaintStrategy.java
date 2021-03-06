package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.List;

import javax.swing.ImageIcon;

import configuration.SimulationConfiguration;
import element.Obstacle;
import element.Source;
import element.Souris;
import map.Block;
import map.Grille;


public class PaintStrategy {
	public void paint(Grille grille, Graphics graphics) {
		int blockSize = SimulationConfiguration.BLOCK_SIZE;
		Block[][] blocks = grille.getBlocks();

		for (int lineIndex = 0; lineIndex < grille.getLignesCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < grille.getColonnesCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(Color.GRAY);
					graphics.fillRect(block.getColonne() * blockSize, block.getLigne() * blockSize, blockSize, blockSize);
				}
			}
		}
	}

	public void paint(Souris souris, Graphics graphics) {
		Block position = souris.getPosition();
		int blockSize = SimulationConfiguration.BLOCK_SIZE;

		int y = position.getLigne();
		int x = position.getColonne();

		ImageIcon image= new ImageIcon("../SourisGLP/src/images/souris.png");
		Image img=image.getImage();
    
		graphics.drawImage( img, x*blockSize, y*blockSize,blockSize,blockSize, null);
	}

	public void paint(Obstacle obstacle, Graphics graphics) {
		Block position = obstacle.getPosition();
		int blockSize = SimulationConfiguration.BLOCK_SIZE;

		int y = position.getLigne();
		int x = position.getColonne();
		
		ImageIcon image= new ImageIcon("../SourisGLP/src/images/obstacle.png");
		Image img=image.getImage();
    
		graphics.drawImage( img, x*blockSize, y*blockSize,blockSize,blockSize, null);
	}

	public void paint(Source source, Graphics graphics) {
		Block position = source.getPosition();
		int blockSize = SimulationConfiguration.BLOCK_SIZE;

		int y = position.getLigne();
		int x = position.getColonne();

		ImageIcon image= new ImageIcon("../SourisGLP/src/images/source.png");
		Image img=image.getImage();
    
		graphics.drawImage( img, x*blockSize, y*blockSize,blockSize,blockSize, null);
	}

}