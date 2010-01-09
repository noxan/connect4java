package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Graphics;

import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.GameListener;
import com.googlecode.connect4java.swing.JGamePanel;
import com.googlecode.connect4java.swing.JRoundPanel;

/**
 * 
 * @author richard.stromer
 * @version 0.8.19
 * @since 0.5.11
 *
 */
public class GameCard extends AbstractCard {
	private static final long serialVersionUID = -1775250517657176595L;
	
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
		
		roundpanel = new JRoundPanel();
		add(roundpanel, "1,1");
		gamepanel = new JGamePanel();
		gamepanel.addMouseListener(listener);
		add(gamepanel, "1,3 , 2,3");
	}
	/**
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
	public JGamePanel getGamePanel() {
		return gamepanel;
	}
}

