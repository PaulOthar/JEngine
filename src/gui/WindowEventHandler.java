package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowEventHandler implements WindowListener{
	//Impelemented Methods
	
	public void windowOpened(WindowEvent e) {
		System.out.println("Window Opened :D");
	}

	public void windowClosing(WindowEvent e) {
		int q = JOptionPane.showConfirmDialog(null, "Are you sure you want to close this window?", "Confirm window closing", 0, JOptionPane.PLAIN_MESSAGE,null);
		if(q==0) {
			System.out.println("Closing");
			System.exit(0);
		}
		System.out.println(e.toString());
	}

	public void windowClosed(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {
		System.out.println("Window Smol :(");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("Window not Smol :)");
	}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}
	
	public String toString() {
		return ":)";
	}
}
