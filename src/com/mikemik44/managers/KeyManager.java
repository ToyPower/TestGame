package com.mikemik44.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyManager implements KeyListener {

	// the storage of keys
	ArrayList<String> keyPress = new ArrayList<String>();
	ArrayList<String> keyDown = new ArrayList<String>();

	//this will remove the keymanager components
	public void dispose() {
		
		keyPress = null;
		keyDown = null;
		
	}
	
	// getters
	
	public boolean isKeyDown(String key) {
		
		return keyDown.contains(key.toLowerCase());
		
	}
	
	public boolean isKeyPressed(String key) {
		
		return keyPress.contains(key.toLowerCase());
		
	}

	// used
	@Override
	public void keyPressed(KeyEvent e) {

		String key = KeyEvent.getKeyText(e.getKeyCode()).toLowerCase();

		// if the key wasnt already in it
		if (!keyDown.contains(key)) {

			keyDown.add(key);
			keyPress.add(key);

		} else if (keyPress.contains(key)) {

			// remove the key if it made it to this step
			keyPress.remove(key);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		String key = KeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
		//remove all keys if it contains it
		if (keyDown.contains(key)) {

			keyDown.remove(key);

		}
		if (keyPress.contains(key)) {

			keyPress.remove(key);

		}

	}

	// unused
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
