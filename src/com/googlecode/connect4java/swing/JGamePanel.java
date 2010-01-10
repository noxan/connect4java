package com.googlecode.connect4java.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.field.Field;
import com.googlecode.connect4java.field.FieldInterface;
import com.googlecode.connect4java.field.FieldValue;

/**
 * 
 * @author richard.stromer
 * @version 0.8.20
 * @since 0.8.17
 */
public class JGamePanel extends JPanel {
	private static final long serialVersionUID = 4166852389806002331L;
	
	public static final int FIELD_PADDING = 5; 
	private Field field;
	
	public JGamePanel(Field field) {
		super();
		this.field = field;
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		paintGrid(g2, getWidth()-1, getHeight()-1);
		paintField(g2, getWidth()-1, getHeight()-1);
	}
	
	private void paintField(Graphics2D g2, int width, int height) {
		float dx = (float) width/FieldInterface.FIELD_WIDTH;
		float dy = (float) height/FieldInterface.FIELD_HEIGHT;
		
		for(int ix=0;ix<Field.FIELD_WIDTH;ix++) {
			int x = (int) (ix*dx);
			for(int iy=0;iy<Field.FIELD_HEIGHT;iy++) {
				int y = (int) (Math.abs(iy-Field.FIELD_HEIGHT+1)*dy);
				FieldValue value = field.get(ix, iy);
				if(value!=null && value!=FieldValue.EMPTY) {
					if(value==FieldValue.PLAYER1) {
						g2.setColor(new Color(Main.pref.getInt("player.color", 255)));
					} else {
						g2.setColor(new Color(Main.pref.getInt("computer.color", -65536)));
					}
					g2.fillOval(x+FIELD_PADDING, y+FIELD_PADDING, (int)dx-2*FIELD_PADDING, (int)dy-2*FIELD_PADDING);
				}
			}
		}
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
