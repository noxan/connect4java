package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.googlecode.connect4java.gui.card.GameCard;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.6.12
 */
public class GameListener extends AbstractListener<GameCard> implements MouseListener {
	public GameListener(GameCard card) {
		super(card);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	/**
	 * @since 0.8.17
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println(e.getX()+"-"+e.getY());
			
//		gui.showCard(GuiCard.MENU);
	}

	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
}
