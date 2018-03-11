package com.mikemik44.level;

import java.awt.Color;
import java.awt.Graphics;

import com.mikemik44.managers.KeyManager;
import com.mikemik44.types.Window;

public class Level1 extends Level {
	
	private int lastFrames = 0;
	
	public boolean debug = false;

	public Level1(Window w) {
		super(w);

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {

		drawer.drawAndFillRectangle(Color.RED, 100, 100, 100, 100);

		if (debug) {
			
			drawer.FillStaticRectangle(new Color(100,50,50,50), 0, 0, w.getWidth()/3, w.getHeight()/2);
			drawer.drawStaticString(Color.WHITE, "FPS:" + lastFrames, 10, 10);
			
		}
		
		drawer.draw(g);
		drawer.clear();

	}

	@Override
	public void update(int lastFrames) {
		this.lastFrames = lastFrames;
		KeyManager km = w.getKeyManager();
		if (km.isKeyDown("w")) {

			drawer.move(0, -1.5);

		}

		if (km.isKeyDown("s")) {

			drawer.move(0, 1.5);

		}

		if (km.isKeyDown("a")) {

			drawer.move(-1.5, 0);

		}

		if (km.isKeyDown("d")) {

			drawer.move(1.5, 0);

		}
		if (km.isKeyPressed("f3")) {
			
			debug = !debug;
			
		}

	}

}
