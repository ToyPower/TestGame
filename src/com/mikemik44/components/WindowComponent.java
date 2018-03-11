package com.mikemik44.components;

import java.awt.Graphics;

import com.mikemik44.types.Window;

public abstract class WindowComponent {

	public abstract void onClose(Window w);
	
	public abstract void onRender(Graphics g, Window w);
	
	public abstract void onInit(Window w);
	
	public abstract void onUpdate(Window w);
	
}
