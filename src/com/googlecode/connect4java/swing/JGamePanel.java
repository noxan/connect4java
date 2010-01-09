package com.googlecode.connect4java.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.googlecode.connect4java.field.FieldInterface;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.8.17
 */
public class JGamePanel extends JPanel {
	private static final long serialVersionUID = 4166852389806002331L;

	public JGamePanel() {
		super();
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		paintGrid(g2, getWidth()-1, getHeight()-1);
	}
	
	
	/**
	 * 
	 * @param g2
	 */
	private void paintGrid(Graphics2D g2, int width, int height) {
		g2.setColor(new Color(0, 0, 0, 128));
		g2.fillRect(0, 0, width, height);
		
		g2.setColor(new Color(128, 128, 128, 128));
		float dx = (float) width/FieldInterface.FIELD_WIDTH;
		for(int ix=0;ix<=FieldInterface.FIELD_WIDTH;ix++) {
			int x = (int) (Math.ceil(ix*dx));
			g2.drawLine(x, 0, x, height);
		}
		float dy = (float) height/FieldInterface.FIELD_HEIGHT;
		for(int iy=0;iy<=FieldInterface.FIELD_HEIGHT;iy++) {
			int y = (int) Math.ceil(iy*dy);
			g2.drawLine(0, y, width, y);
		}
	}
}
