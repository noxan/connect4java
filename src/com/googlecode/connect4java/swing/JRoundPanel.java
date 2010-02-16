package com.googlecode.connect4java.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.googlecode.connect4java.field.FieldEvent;
import com.googlecode.connect4java.field.FieldListener;
import com.googlecode.connect4java.game.GameInterface;

/**
 * @author richard.stromer
 * @version 1.0.27
 * @since 0.8.17
 */
public class JRoundPanel extends JPanel implements FieldListener {
	private static final long serialVersionUID = -5398739716808518120L;
	private final Color border = new Color(128, 128, 128);
	private GameInterface game;
	
	public JRoundPanel(GameInterface game) {
		super();
		this.game = game;
		setOpaque(false);
		game.addFieldListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if(game.isWin()) {
			paintWin(g2, getWidth(), getHeight());
		} else {
			paintRound(g2, getWidth(), getHeight());
		}
	}
	
	private void paintBackground(Graphics2D g2, int width, int height) {
		g2.setColor(border);
		g2.fillRect(0, 0, width, height);
		g2.setColor(new Color(0, 0, 0, 128));
		g2.fillRect(1, 1, width - 2, height - 2);
	}
	
	private void paintWin(Graphics2D g2, int width, int height) {
		paintBackground(g2, width, height);
		
		g2.setColor(Color.WHITE);
		g2.drawString("Win!", 10, 15);
	}
	
	private void paintRound(Graphics2D g2, int width, int height) {
		paintBackground(g2, width, height);
		
		g2.setColor(border);
		g2.drawRect(2, 2, width - 5, 22);
		g2.setColor(game.getActive().getColor());
		g2.fillRect(3, 3, width - 6, 21);
		
		g2.setColor(border);
		g2.drawRect(2, 26, width - 5, 22);
		g2.setColor(game.getInactive().getColor());
		g2.fillRect(3, 27, width - 6, 21);
		
		g2.setColor(Color.BLACK);
		g2.drawString(game.getActive().getName(), 8, 17);
		g2.drawString(game.getInactive().getName(), 8, 42);
	}

	@Override
	public void handleFieldEvent(FieldEvent event) {
//		repaint();
		if(event.isWin()) {
			System.out.println("win...");
		}
	}
}
