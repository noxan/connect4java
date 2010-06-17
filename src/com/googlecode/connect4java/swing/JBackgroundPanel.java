package com.googlecode.connect4java.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.googlecode.connect4java.core.Core;

/**
 * 
 * @author richard.stromer
 * @version 1.1b2(r31)
 * @since 0.5.11
 */
public class JBackgroundPanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 8067592209747352630L;
	
	private Thread thread;
	
	private int time;
	private float limit = 50.0f;
	
	private Color start;
	private Color active;
	private Color end;
	
	
	public JBackgroundPanel() {
		this(new Color(0, 0, 0));	
	}
	public JBackgroundPanel(Color start) {
		super();
		this.start = start;
		this.active = start;
		this.time = 500;
	}
	
	
	private void start() {
		thread = new Thread(this);
		thread.start();
	}
	private void stop() throws InterruptedException {
		if(thread!=null && thread.isAlive()) {
			thread.interrupt();
			thread.join();
		}
	}
	private Color calcActiveColor(int step) {
		float f = (float)step/limit;
		return new Color(
			(int) (start.getRed()+(f*(end.getRed()-start.getRed()))),
			(int) (start.getGreen()+(f*(end.getGreen()-start.getGreen()))), 
			(int) (start.getBlue()+(f*(end.getBlue()-start.getBlue())))
		);
	}
	
	@Override
	public void run() {
		int step = 0;
		while(!thread.isInterrupted() && step<limit) {
			try {
				active = calcActiveColor(step);
				this.repaint();
				step++;
				Thread.sleep(time);
			} catch (InterruptedException e) {
				thread.interrupt();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getSize().width;
		int height = getSize().height;
		
		GradientPaint gp = new GradientPaint(0f, 0f, Color.BLACK, 0f, (float)height, active);
		g2.setPaint(gp);
		g2.fillRect(0, 0, width, height);
		
		g2.setFont(new Font("Verdana", Font.PLAIN, 32));
		g2.setColor(active);
		g2.drawString(Core.TITLE, width-228, 40);
	}
	
	public void nextColor(Color color) {
		nextColor(color, 50);
	}
	public void nextColor(Color color, int time) {
		try {
			stop();
			this.start = this.active;
			this.end = color;
			this.time = time;
			start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Sets the number of steps.
	 * @since 0.8.17
	 * @param limit number of steps
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
