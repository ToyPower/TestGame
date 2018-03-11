package com.mikemik44.types;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.mikemik44.components.WindowComponent;
import com.mikemik44.managers.KeyManager;
import com.mikemik44.managers.MouseManager;

public class Window {

	// holds the default title
	private String default_Title = "";

	// holds if our frame is closed or not (i am saying if it isnt visible its
	// closed)
	private boolean closed = true;

	// our frames
	private JFrame j = new JFrame();
	private Canvas c = new Canvas();

	// our managers
	private KeyManager km = new KeyManager();
	private MouseManager mm = new MouseManager();

	// our clear color
	private Color clear = Color.BLACK;

	// holds our window component
	private WindowComponent wc;

	public Window(String title, int width, int height) {
		default_Title = title;
		j.setTitle(title);
		c.setSize(width, height);
		c.addKeyListener(km);
		c.addMouseListener(mm);
		c.addMouseMotionListener(mm);
		j.add(c);
		j.pack();
		Window w = this;
		// this controlls what happens when we close our window
		j.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

			}

			@Override
			public void windowClosing(WindowEvent arg0) {

				closed = true;
				if (wc != null) {

					wc.onClose(w);

				} else {
					// this makes it so it closes out right away
					System.exit(0);

				}
				
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
		// this controlls what happens when we resize our window
		j.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {

			}

			@Override
			public void componentMoved(ComponentEvent arg0) {

			}

			@Override
			public void componentResized(ComponentEvent arg0) {

				// this changed the canvas to be same size of the new resized
				// width and height
				c.setSize(j.getWidth(), j.getHeight());

			}

			@Override
			public void componentShown(ComponentEvent arg0) {

			}

		});

		// this puts the window into the center of the screen
		j.setLocationRelativeTo(null);

	}

	// this will display the window and call the init method
	public void show() {

		j.setVisible(true);
		closed = false;
		// this will create a buffer strategy for us to use
		c.createBufferStrategy(3);
		// this will make it so we can use key as soon as window is up
		c.requestFocus();
		if (wc != null) {
			
			wc.onInit(this);
			
		}

	}

	// this does the rendering and updates
	public void update() {

		if (wc != null) {

			wc.onUpdate(this);

		}
		// this is a back image just to make it so it flickers less
		BufferedImage img = new BufferedImage(j.getWidth(), j.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.getGraphics();
		g.setColor(this.clear);
		g.fillRect(0, 0, j.getWidth(), j.getHeight());
		g.setColor(Color.white);
		if (wc != null) {

			wc.onRender(g, this);

		}
		g.dispose();
		BufferStrategy bs = c.getBufferStrategy();
		g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, j.getWidth(), j.getHeight(), null);
		g.dispose();
		bs.show();

	}

	// this will hide the window
	public void hide() {

		j.setVisible(false);
		closed = true;

	}

	// this will remove everything form the window
	public void dispose() {

		km.dispose();
		mm.dispose();
		km = null;
		mm = null;
		clear = null;
		wc = null;
		j.dispose();
		c = null;
		j = null;

	}

	// getters
	public KeyManager getKeyManager() {

		return km;

	}

	public MouseManager getMouseManager() {

		return mm;

	}

	public String getTitle() {

		return j.getTitle();

	}

	public String getDefaultTitle() {

		return default_Title;

	}

	public int getWidth() {

		return j.getWidth();

	}

	public int getHeight() {

		return j.getHeight();

	}
	
	public boolean IsClosed() {
		
		return closed;
		
	}

	// setters
	public void setSize(int width, int height) {

		j.setSize(width, height);

	}

	public void setLocation(int x, int y) {

		j.setLocation(x, y);

	}

	public void setWindowComponent(WindowComponent wc) {

		this.wc = wc;

	}

	public void setTitle(String title) {

		j.setTitle(title);

	}

	public void setClearColor(Color color) {

		clear = color;

	}

}
