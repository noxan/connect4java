package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import com.googlecode.connect4java.game.GameInterface;
import com.googlecode.connect4java.game.LocalGame;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.GameListener;
import com.googlecode.connect4java.swing.JGamePanel;
import com.googlecode.connect4java.swing.JRoundPanel;

/**
 * @author richard.stromer
 * @version 1.0.28
 * @since 0.5.11
 */
public class GameCard extends AbstractCard {
	private static final long serialVersionUID = -1775250517657176595L;
	private GameInterface game;
	private JGamePanel gamepanel;
	private JRoundPanel roundpanel;
	
	public GameCard(MainGui gui) {
		super(gui);
		
		double[][] size = {{MainGui.MARGIN, 200, TableLayout.FILL, MainGui.MARGIN},
				{MainGui.MARGIN / 2, 51, MainGui.MARGIN / 2, TableLayout.FILL, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	@Override
	protected void initComponents() {
		GameListener listener = new GameListener(this);
		game = new LocalGame(getGui(), this);
		roundpanel = new JRoundPanel(game);
		add(roundpanel, "1,1");
		gamepanel = new JGamePanel(game);
		gamepanel.addMouseListener(listener);
		add(gamepanel, "1,3 , 2,3");
	}
	
	@Override
	public void update() {
		gamepanel.repaint();
		roundpanel.repaint();
	}
	
	public void reset() {
		game.reset();
	}
	
	public GameInterface getGame() {
		return game;
	}
	
	public JGamePanel getGamePanel() {
		return gamepanel;
	}
	
	public JRoundPanel getRoundPanel() {
		return roundpanel;
	}
}
