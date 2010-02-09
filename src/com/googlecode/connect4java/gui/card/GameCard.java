package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Graphics;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.game.GameInterface;
import com.googlecode.connect4java.game.LocalGame;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.GameListener;
import com.googlecode.connect4java.swing.JGamePanel;
import com.googlecode.connect4java.swing.JRoundPanel;

/**
 * 
 * @author richard.stromer
 * @version 1.0.23
 * @since 0.5.11
 *
 */
public class GameCard extends AbstractCard {
	private static final long serialVersionUID = -1775250517657176595L;
	
	public GameInterface game;
	
	protected JGamePanel gamepanel;
	protected JRoundPanel roundpanel;
	
	public GameCard(MainGui gui) {
		super(gui);
		
		double[][] size = {{MainGui.MARGIN, 200, TableLayout.FILL, MainGui.MARGIN}, 
				{MainGui.MARGIN/2, 51, MainGui.MARGIN/2, TableLayout.FILL, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	@Override
	protected void initComponents() {
		GameListener listener = new GameListener(this);
		game = new LocalGame(gui, this);
		
		//sample...
//		Field field = new Field();
//		field.add((short) 0, FieldValue.PLAYER1);
//		field.add((short) 0, FieldValue.PLAYER2);
//		field.add((short) 0, FieldValue.PLAYER1);
//		field.add((short) 0, FieldValue.PLAYER2);
//		field.add((short) 1, FieldValue.PLAYER2);
//		field.add((short) 1, FieldValue.PLAYER1);
//		field.add((short) 2, FieldValue.PLAYER2);
		
		roundpanel = new JRoundPanel();
		add(roundpanel, "1,1");
		gamepanel = new JGamePanel(game.getField());
		gamepanel.addMouseListener(listener);
		add(gamepanel, "1,3 , 2,3");
		Main.pref.addPreferenceChangeListener(listener);
	}
	/**
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void reset() {
		game.getField().reset();
	}
	
	public JGamePanel getGamePanel() {
		return gamepanel;
	}
	public JRoundPanel getRoundPanel() {
		return roundpanel;
	}
}

