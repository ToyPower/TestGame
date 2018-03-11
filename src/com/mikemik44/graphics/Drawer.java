package com.mikemik44.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;

public class Drawer {

	private double x, y;
	// hold all the draw data
	private ArrayList<Object[]> draws = new ArrayList<Object[]>();

	public void move(double x, double y) {

		this.x += x;
		this.y += y;

	}

	public void setOffset(double x, double y) {

		this.x = x;
		this.y = y;

	}

	// this does draws
	/**
	 * This will draw a rectangle that follows the camera
	 * 
	 * @param g
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawRectangle(Color c, double x, double y, double width, double height) {
		Object[] data = new Object[7];
		data[0] = "Rectangle";
		data[1] = "draw";
		data[2] = c;
		data[3] = x + this.x;
		data[4] = y + this.y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	/**
	 * this will clear any drawable data to be reset
	 */
	public void clear() {

		draws.clear();

	}

	/**
	 * This will fill a rectangle that follows the camera
	 * 
	 * @param g
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void fillRectangle(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "Rectangle";
		data[1] = "fill";
		data[2] = c;
		data[3] = x + this.x;
		data[4] = y + this.y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	/**
	 * 
	 * This will both fill and draw a rectangle that follows the camera
	 * 
	 * @param g
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawAndFillRectangle(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "Rectangle";
		data[1] = "fillanddraw";
		data[2] = c;
		data[3] = x + this.x;
		data[4] = y + this.y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	/**
	 * 
	 * this will draw a rectangle without following camera
	 * 
	 * @param g
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawStaticRectangle(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "staticRectangle";
		data[1] = "draw";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	/**
	 * this will fill a rectangle without following the camera
	 * 
	 * @param g
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void FillStaticRectangle(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "staticRectangle";
		data[1] = "fill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	/**
	 * This will fill and draw a rectangle without following the camera
	 * 
	 * @param g
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawAndFillStaticRectangle(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "staticRectangle";
		data[1] = "fillanddraw";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	/**
	 * This will draw a string that follows the camera
	 * 
	 * @param msg
	 * @param x
	 * @param y
	 */
	public void drawString(Color c, String msg, double x, double y) {

		Object[] data = new Object[5];
		data[0] = "string";
		data[1] = c;
		data[2] = msg;
		data[3] = x + this.x;
		data[4] = y + this.y;
		draws.add(data);

	}

	/**
	 * This will draw a string that doesn't the camera
	 * 
	 * @param msg
	 * @param x
	 * @param y
	 */
	public void drawStaticString(Color c, String msg, double x, double y) {

		Object[] data = new Object[5];
		data[0] = "staticstring";
		data[1] = c;
		data[2] = msg;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void drawLine(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[6];
		data[0] = "line";
		data[1] = c;
		data[2] = x + this.x;
		data[3] = y + this.y;
		data[4] = x + width + this.x;
		data[5] = y + height + this.y;
		draws.add(data);

	}

	public void drawStaticLine(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[6];
		data[0] = "staticline";
		data[1] = c;
		data[2] = x;
		data[3] = y;
		data[4] = x + width;
		data[5] = y + height;
		draws.add(data);

	}

	public void drawPolygon(Color c, double[] x, double[] y) {
		for (int i = 0; i < x.length; i++) {

			x[i] += this.x;

		}
		for (int i = 0; i < y.length; i++) {

			y[i] += this.y;

		}
		Object[] data = new Object[5];
		data[0] = "polygon";
		data[1] = "draw";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void fillPolygon(Color c, double[] x, double[] y) {
		for (int i = 0; i < x.length; i++) {

			x[i] += this.x;

		}
		for (int i = 0; i < y.length; i++) {

			y[i] += this.y;

		}
		Object[] data = new Object[5];
		data[0] = "polygon";
		data[1] = "fill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void drawAndFillPolygon(Color c, double[] x, double[] y) {
		for (int i = 0; i < x.length; i++) {

			x[i] += this.x;

		}
		for (int i = 0; i < y.length; i++) {

			y[i] += this.y;

		}
		Object[] data = new Object[5];
		data[0] = "polygon";
		data[1] = "drawandfill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void drawStaticPolygon(Color c, double[] x, double[] y) {
		Object[] data = new Object[5];
		data[0] = "staticpolygon";
		data[1] = "draw";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void fillStaticPolygon(Color c, double[] x, double[] y) {
		Object[] data = new Object[5];
		data[0] = "staticpolygon";
		data[1] = "fill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void drawAndFillStaticPolygon(Color c, double[] x, double[] y) {
		Object[] data = new Object[5];
		data[0] = "staticpolygon";
		data[1] = "drawandfill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		draws.add(data);

	}

	public void drawImage(Image image, double x, double y) {

		Object[] data = new Object[4];
		data[0] = "image";
		data[1] = image;
		data[2] = x + this.x;
		data[3] = y + this.y;
		draws.add(data);
	}

	public void drawImageAndResize(Image image, double x, double y, double width, double height) {

		Object[] data = new Object[6];
		data[0] = "image";
		data[1] = image;
		data[2] = x + this.x;
		data[3] = y + this.y;
		data[4] = width;
		data[5] = height;
		draws.add(data);
	}

	public void drawStaticImage(Image image, double x, double y) {

		Object[] data = new Object[4];
		data[0] = "staticimage";
		data[1] = image;
		data[2] = x;
		data[3] = y;
		draws.add(data);
	}

	public void drawStaticImageAndResize(Image image, double x, double y, double width, double height) {

		Object[] data = new Object[6];
		data[0] = "staticimage";
		data[1] = image;
		data[2] = x;
		data[3] = y;
		data[4] = width;
		data[5] = height;
		draws.add(data);

	}

	public void drawOval(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "oval";
		data[1] = "draw";
		data[2] = c;
		data[3] = x + this.x;
		data[4] = y + this.y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	public void fillOval(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "oval";
		data[1] = "fill";
		data[2] = c;
		data[3] = x + this.x;
		data[4] = y + this.y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}
	
	public void drawAndFillOval(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "oval";
		data[1] = "drawandfill";
		data[2] = c;
		data[3] = x + this.x;
		data[4] = y + this.y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	public void drawStaticOval(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "staticoval";
		data[1] = "draw";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	public void fillStaticOval(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "staticoval";
		data[1] = "fill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}
	
	public void drawAndFillStaticOval(Color c, double x, double y, double width, double height) {

		Object[] data = new Object[7];
		data[0] = "staticoval";
		data[1] = "drawandfill";
		data[2] = c;
		data[3] = x;
		data[4] = y;
		data[5] = width;
		data[6] = height;
		draws.add(data);

	}

	// oval

	/**
	 * will display all the graphic data to the screen
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		ArrayList<Object[]> used = new ArrayList<Object[]>();
		for (Object[] data : draws) {
			Object[] section = data;
			for (Object[] data2 : draws) {

				if (!used.contains(data2)) {
					if (used.contains(section)) {

						section = data2;

					} else if (section[0].toString().contains("static") && !data2[0].toString().contains("static")) {

						section = data2;

					}
				}

			}
			String name = section[0].toString().replace("static", "");
			if (name.equals("Rectangle")) {

				Color c = (Color) section[2];
				int x = (int) ((double) section[3]);
				int y = (int) ((double) section[4]);
				int width = (int) ((double) section[5]);
				int height = (int) ((double) section[6]);
				g.setColor(c);
				if (section[1].toString().equals("draw")) {
					g.drawRect(x, y, width, height);
				} else if (section[1].toString().equals("fill")) {
					g.fillRect(x, y, width, height);
				} else if (section[1].toString().equals("fillanddraw")) {
					g.fillRect(x, y, width, height);
					g.setColor(Color.GRAY);
					g.drawRect(x, y, width, height);

				}

			} else if (name.equals("string")) {
				Color c = (Color) section[1];
				String msg = section[2].toString();
				int x = (int) ((double) section[3]);
				int y = (int) ((double) section[4]);
				g.setColor(c);
				g.drawString(msg, x, y);

			} else if (name.equals("line")) {

				Color c = (Color) section[1];
				int x = (int) ((double) section[2]);
				int y = (int) ((double) section[3]);
				int width = (int) ((double) section[4]);
				int height = (int) ((double) section[5]);
				g.setColor(c);
				g.drawLine(x, y, width, height);

			} else if (name.equals("polygon")) {

				Color c = (Color) section[2];
				double[] x = (double[]) section[3];
				double[] y = (double[]) section[4];
				Polygon p = new Polygon();
				for (int xx = 0; xx < x.length; xx++) {
					p.addPoint((int) x[xx], (int) y[xx]);

				}

				g.setColor(c);
				if (section[1].toString().equals("draw")) {

					g.drawPolygon(p);

				} else if (section[1].toString().equals("fill")) {

					g.fillPolygon(p);

				} else if (section[1].toString().equals("drawandfill")) {

					g.fillPolygon(p);
					g.setColor(Color.GRAY);
					g.drawPolygon(p);

				}

			} else if (name.equals("image")) {

				Image img = (Image) section[1];
				int x = (int) ((double) section[2]);
				int y = (int) ((double) section[3]);
				if (section.length == 6) {

					int width = (int) ((double) section[4]);
					int height = (int) ((double) section[5]);
					g.drawImage(img, x, y, width, height, null);

				} else {

					g.drawImage(img, x, y, null);

				}
			} else if (name.equals("oval")) {
				
				Color c = (Color) section[2];
				int x = (int) ((double) section[3]);
				int y = (int) ((double) section[4]);
				int width = (int) ((double) section[5]);
				int height = (int) ((double) section[6]);
				g.setColor(c);
				if (section[1].toString().equals("draw")) {
					
					g.drawOval(x, y, width, height);
					
				} else if (section[1].toString().equals("fill")) {
					
					g.fillOval(x, y, width, height);
					
				} else if (section[1].toString().equals("drawandfill")) {
					
					g.fillOval(x, y, width, height);
					g.setColor(Color.gray);
					g.drawOval(x, y, width, height);
					
				}
			}

			used.add(section);

		}

	}

}
