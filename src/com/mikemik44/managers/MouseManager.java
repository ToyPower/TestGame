package com.mikemik44.managers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MouseManager implements MouseListener, MouseMotionListener{

	private ArrayList<String> buttonDown = new ArrayList<String>();
	private ArrayList<String> buttonPressed = new ArrayList<String>();
	private int x, y;
	
	//this will remove the mousemanager stuff
	public void dispose() {
		
		buttonDown = null;
		buttonPressed = null;
		
	}
	
	//getters
	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
	public boolean isButtonDown(String button) {
		
		return buttonDown.contains(button.toLowerCase());
		
	}
	
	public boolean isButtonPressed(String button) {
		
		return buttonPressed.contains(button.toLowerCase());
		
	}
	
	//used
	@Override
	public void mouseMoved(MouseEvent e) {
		
		this.x = e.getX();
		this.y = e.getY();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		String key = e.getButton() + "";
		//if key is left
		if (key == "1") {
			
			key = "left";
			
		}
		//if key is middle click
		if (key == "2") {
			
			key = "middle";
			
		}
		//if the key is right
		if (key == "3") {
			
			key = "right";
			
		}
		//check to make sure it does not already contain the button
		if (!buttonDown.contains(key)) {
			
			//add to both down and pressed
			buttonPressed.add(key);
			buttonDown.add(key);
			
		} else if (buttonDown.contains(key)) {
			
			//if the buttonPressed contains the key romove it
			buttonPressed.remove(key);
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		String key = e.getButton() + "";
		//if key is left
		if (key == "1") {
			
			key = "left";
			
		}
		//if key is middle click
		if (key == "2") {
			
			key = "middle";
			
		}
		//if the key is right
		if (key == "3") {
			
			key = "right";
			
		}
		//removes the key if button contains it
		if (buttonDown.contains(key)) {
			
			buttonPressed.remove(key);
			
		} 
		if (buttonDown.contains(key)) {
			
			//if the buttonPressed contains the key romove it
			buttonPressed.remove(key);
			
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String key = e.getButton() + "";
		//if key is left
		if (key == "1") {
			
			key = "left";
			
		}
		//if key is middle click
		if (key == "2") {
			
			key = "middle";
			
		}
		//if the key is right
		if (key == "3") {
			
			key = "right";
			
		}
		//check to make sure it does not already contain the button
		if (!buttonDown.contains(key)) {
			
			//add to both down and pressed
			buttonPressed.add(key);
			buttonDown.add(key);
			
		} else if (buttonDown.contains(key)) {
			
			//if the buttonPressed contains the key romove it
			buttonPressed.remove(key);
			
		}
		
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		this.x = e.getX();
		this.y = e.getY();
		
	}

	//not used

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
		
	}

}
