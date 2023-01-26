package gui;

import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.MouseInputListener;

public abstract class InputHandler implements MouseInputListener, KeyListener {
	private char[] keysHeld;
	private int keyHeldFreeSlot;
	private char lastHeld;

	private Point[] lastClicked;
	private boolean[] isHoldingClick;

	public InputHandler() {
		this.keysHeld = new char[10];
		this.keyHeldFreeSlot = 0;
		this.lastHeld = '\0';
		this.lastClicked = new Point[3];
		this.isHoldingClick = new boolean[3];
	}

	public InputHandler(Component component) {
		component.addMouseListener(this);
		component.addMouseMotionListener(this);
		component.addKeyListener(this);
	}

	// Functionality Methods

	public void holdKey(char key) {
		if (key == this.lastHeld) {
			return;
		}
		this.lastHeld = key;
		for (int i = 0; i < this.keyHeldFreeSlot + 1; i++) {
			if (this.keysHeld[i] == key) {
				return;
			}
		}
		this.keysHeld[this.keyHeldFreeSlot] = key;
		this.keyHeldFreeSlot++;
	}

	public void releaseKey(char key) {
		if (key == this.lastHeld) {
			lastHeld = '\0';
		}
		boolean isPressed = false;
		for (int i = 0; i < keyHeldFreeSlot + 1; i++) {
			if (isPressed) {
				keysHeld[i - 1] = keysHeld[i];
			} else if (keysHeld[i] == key) {
				isPressed = true;
			}
		}
		if (isPressed) {
			keyHeldFreeSlot--;
		}
	}

	public void printKeysHeld() {
		int i = 0;
		System.out.println(String.format("%c:%c%c%c%c%c%c%c%c%c%c", lastHeld, keysHeld[i++], keysHeld[i++],
				keysHeld[i++], keysHeld[i++], keysHeld[i++], keysHeld[i++], keysHeld[i++], keysHeld[i++], keysHeld[i++],
				keysHeld[i++]));
	}

	// Implemented Methods

	public void mousePressed(MouseEvent e) {
		lastClicked[e.getButton() - 1] = e.getPoint();
		isHoldingClick[e.getButton() - 1] = true;
	}

	public void mouseReleased(MouseEvent e) {
		isHoldingClick[e.getButton() - 1] = false;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() != lastHeld) {
			holdKey(e.getKeyChar());
			printKeysHeld();
		}
	}

	public void keyReleased(KeyEvent e) {
		releaseKey(e.getKeyChar());
		printKeysHeld();
	}

	// Getters and Setters

	public char[] getKeysHeld() {
		return keysHeld;
	}

	public void setKeysHeld(char[] keysHeld) {
		this.keysHeld = keysHeld;
	}

	public int getKeyHeldFreeSlot() {
		return keyHeldFreeSlot;
	}

	public void setKeyHeldFreeSlot(int keyHeldFreeSlot) {
		this.keyHeldFreeSlot = keyHeldFreeSlot;
	}

	public char getLastHeld() {
		return lastHeld;
	}

	public void setLastHeld(char lastHeld) {
		this.lastHeld = lastHeld;
	}

	public Point[] getLastClicked() {
		return lastClicked;
	}

	public void setLastClicked(Point[] lastClicked) {
		this.lastClicked = lastClicked;
	}

	public boolean[] getIsHoldingClick() {
		return isHoldingClick;
	}

	public void setIsHoldingClick(boolean[] isHoldingClick) {
		this.isHoldingClick = isHoldingClick;
	}

}
