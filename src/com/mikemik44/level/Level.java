package com.mikemik44.level;

import java.awt.Graphics;

import com.mikemik44.graphics.Drawer;
import com.mikemik44.main.Main;
import com.mikemik44.types.Window;

public abstract class Level {

	protected Window w;
	protected Drawer drawer = new Drawer();
	
	public Level(Window w) {
		
		this.w = w;
		
	}
	
	public abstract void init();
	
	public abstract void render(Graphics g);
	
	public abstract void update(int lastFrames);
	
	public static void setLevel(Level l) {
		
		Main.current = l;
		Main.current.init();
		
	}
	
}
