package gui;

import javax.swing.JFrame;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Screen screen;
	
	public Window(String name) {
		super(name);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(500, 500);
		this.addWindowListener(new WindowEventHandler());
		
		this.screen = new Screen();
		this.add(screen);
	}
	
}
