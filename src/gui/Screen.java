package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Screen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		g.fillOval(10, 10, 100, 100);
		BufferedImage bf = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
		for(int i = 0;i<500;i++) {
			bf.setRGB(i, i, 0xFF_FF_00_00);
			bf.setRGB(499-i, i, i);
		}
		g.drawImage(bf, 0, 0, null);
	}
}
