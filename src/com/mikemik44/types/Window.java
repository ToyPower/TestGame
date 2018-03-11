package com.mikemik44.types;

import java.awt.Canvas;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.mikemik44.components.WindowComponent;
import com.mikemik44.managers.KeyManager;
import com.mikemik44.managers.MouseManager;
import com.sun.prism.paint.Color;

public class Window {
	
	//holds if our frame is closed or not (i am saying if it isnt visible its closed)
	private boolean closed = true;
	
	//our frames
	private JFrame j;
	private Canvas c;
	
	//our managers
	private KeyManager km = new KeyManager();
	private MouseManager mm = new MouseManager();
	
	//our clear color
	private Color clear = Color.BLACK;
	
	//holds our window component
	private WindowComponent wc;
	
	public Window(String title, int width, int height) {
		
		j.setTitle(title);
		c.setSize(width, height);
		c.addKeyListener(km);
		c.addMouseListener(mm);
		c.addMouseMotionListener(mm);
		j.add(c);
		j.pack();
		Window w = this;
		//this controlls what happens when we close our window
		j.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				
				closed = true;
				if (wc != null) {
					
					wc.onClose(w);
					
				} else {
					//this makes it so it closes out right away
					System.exit(0);
					
				}
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				
				
			}
		});
		//this controlls what happens when we resize our window
		j.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				
				//this changed the canvas to be same size of the new resized width and height
				c.setSize(j.getWidth(), j.getHeight());
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				
				
			}
			
		});
		
		//this puts the window into the center of the screen
		j.setLocationRelativeTo(null);
		
	}

}
