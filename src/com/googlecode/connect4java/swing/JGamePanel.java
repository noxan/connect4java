package com.googlecode.connect4java.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.field.DefaultField;
import com.googlecode.connect4java.field.FieldValue;
import com.googlecode.connect4java.game.GameInterface;

/**
 * 
 * @author richard.stromer
 * @version 1.1b4(r34)
 * @since 0.8.17
 */
public class JGamePanel extends JPanel {
	private static final long serialVersionUID = 4166852389806002331L;
	public static final int FIELD_PADDING = 5;
	private GameInterface game;
	
	public JGamePanel(GameInterface game) {
		super();
		this.game = game;
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		paintGrid(g2, getWidth() - 1, getHeight() - 1);
		paintField(g2, getWidth() - 1, getHeight() - 1);
	}
	
	private void paintField(Graphics2D g2, int width, int height) {
		float dx = (float) width / game.getField().getWidth();
		float dy = (float) height / game.getField().getHeight();
		
		for(int ix = 0; ix < game.getField().getWidth(); ix++) {
			int x = (int) (ix * dx);
			for(int iy = 0; iy < game.getField().getHeight(); iy++) {
				int y = (int) (Math.abs(iy - game.getField().getHeight() + 1) * dy);
				FieldValue value = game.get(ix, iy);
				if(value != null && value != FieldValue.EMPTY) {
					if(value == FieldValue.PLAYER1) {
						g2.setColor(game.getPlayer(0).getColor());
					} else {
						g2.setColor(game.getPlayer(1).getColor());
					}
					if(game.isWin()) {
						if(!game.getField().getWinTokens().contains(new Point(ix, iy))) {
							g2.setColor(new Color(Core.pref.getInt("drawn.color", -2139062144)));
						}
					}
					g2.fillOval(x + FIELD_PADDING, y + FIELD_PADDING, (int) dx - 2 * FIELD_PADDING, (int) dy - 2 * FIELD_PADDING);
				}
			}
		}
	}
	
	/**
	 * Paints the background grid.
	 * 
	 * @param g2
	 * @param width
	 * @param height
	 */
	private void paintGrid(Graphics2D g2, int width, int height) {
		g2.setColor(new Color(0, 0, 0, 128));
		g2.fillRect(0, 0, width, height);
		
		g2.setColor(new Color(128, 128, 128, 128));
		float dx = (float) width / DefaultField.FIELD_WIDTH;
		for(int ix = 0; ix <= DefaultField.FIELD_WIDTH; ix++) {
			int x = (int) (Math.ceil(ix * dx));
			g2.drawLine(x, 0, x, height);
		}
		float dy = (float) height / DefaultField.FIELD_HEIGHT;
		for(int iy = 0; iy <= DefaultField.FIELD_HEIGHT; iy++) {
			int y = (int) Math.ceil(iy * dy);
			g2.drawLine(0, y, width, y);
		}
	}
}
