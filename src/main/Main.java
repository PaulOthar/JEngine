package main;

import gui.Window;

public class Main {
	public static void main(String[] args) {
		Window w = new Window(null);
		w.setVisible(true);
		System.out.println(w.getWindowListeners()[0]);
	}
}