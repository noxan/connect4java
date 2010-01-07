package com.googlecode.connect4java.gui.card;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.googlecode.connect4java.field.FieldInterface;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.GameListener;

/**
 * 
 * @author noxan
 * @version 0.7.16
 * @since 0.5.11
 */
public class GameCard extends AbstractCard {
	private static final long serialVersionUID = -1775250517657176595L;
	
	public GameCard(MainGui gui) {
		super(gui, new GameListener(gui));
		
		setLayout(new BorderLayout());
		
		initComponents();
	}
	
	@Override
	protected void initComponents() {
		
	}
	/**
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		int top = 75;
		int left = MainGui.MARGIN;
		int right = MainGui.MARGIN;
		int bottom = MainGui.MARGIN;
		
		int width = getWidth()-left-right;
		int height = getHeight()-top-bottom;
		
		paintGrid(g2, top, right, bottom, left, width, height);
	}
	/**
	 * 
	 * @param g2
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 * @param width
	 * @param height
	 */
	private void paintGrid(Graphics2D g2, int top, int right, int bottom, int left, int width, int height) {		
		g2.setColor(new Color(0, 0, 0, 128));
		g2.fillRect(left, top, width, height);
		
		g2.setColor(new Color(128, 128, 128, 128));
		float dx = (float) width/FieldInterface.FIELD_WIDTH;
		for(int ix=0;ix<=FieldInterface.FIELD_WIDTH;ix++) {
			int x = (int) (Math.floor(ix*dx))+left;
			g2.drawLine(x, top, x, height+top);
		}
		float dy = (float) height/FieldInterface.FIELD_HEIGHT;
		for(int iy=0;iy<=FieldInterface.FIELD_HEIGHT;iy++) {
			int y = (int) Math.floor(iy*dy)+top;
			g2.drawLine(left, y, width+left, y);
		}
	}
}
