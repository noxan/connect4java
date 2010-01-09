package com.googlecode.connect4java.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.googlecode.connect4java.gui.card.AbstractCard;

/**
 * 
 * @author richard.stromer
 * @version 0.8.17
 * @since 0.6.12
 *
 * @param <E>
 */
public abstract class AbstractListener<E extends AbstractCard> implements ActionListener {
	protected AbstractCard card;
	
	public AbstractListener(E e) {
		card = e;
	}
	
	public abstract void actionPerformed(ActionEvent e);
}
