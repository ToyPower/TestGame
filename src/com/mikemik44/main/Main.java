package com.mikemik44.main;

import java.awt.Graphics;

import com.mikemik44.components.ThreadComponent;
import com.mikemik44.components.WindowComponent;
import com.mikemik44.graphics.Drawer;
import com.mikemik44.level.Level;
import com.mikemik44.level.Level1;
import com.mikemik44.managers.ThreadManager;
import com.mikemik44.types.Window;

public class Main {

	public static Window main;
	// the max fps
	private int maxFPS = 60;
	private int lastFrames = 0;
	private Drawer drawer = new Drawer();
	
	public static Level current;

	public Main() {

		main = new Window("Test", 800, 600);
		main.setWindowComponent(new WindowComponent() {
			
			
			@Override
			public void onClose(Window w) {
				ThreadManager.closeAll();
				System.exit(0);

			}

			@Override
			public void onRender(Graphics g, Window w) {
				if (current != null) {
					
					current.render(g);
					
				}
				drawer.draw(g);
				drawer.clear();
			}

			@Override
			public void onInit(Window w) {
				Level.setLevel(new Level1(w));
			}

			@Override
			public void onUpdate(Window w) {
				if (current != null) {
					
					current.update(lastFrames);
					
				}
			}

		});
		main.show();
		// call and run a thread
		new ThreadManager(new ThreadComponent() {

			@Override
			public void run() {

				int frames = 0;
				double delta = 0;
				double lastTime = System.nanoTime();
				double lt = System.currentTimeMillis();
				double nps = 1e9 / maxFPS;
				int next = 1;

				while (!main.IsClosed()) {

					double now = System.nanoTime();
					delta += (now - lastTime) / nps;
					lastTime = now;
					while (delta >= 1) {
						delta--;
						main.update();
						frames++;

					}

					if ((System.currentTimeMillis() - lt) / 1000 >= next) {

						next++;
						lastFrames = frames;
						frames = 0;

					}

				}

			}

		}, "Display", true);

	}

	public static void main(String[] args) {

		new Main();

	}

}
