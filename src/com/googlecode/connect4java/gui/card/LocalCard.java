package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.googlecode.connect4java.core.Core;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.LocalListener;

/**
 * 
 * @author richard.stromer
 * @version 0.1.29b1
 * @since 0.1
 */
public class LocalCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private JPanel player1Panel;
	private JComboBox player1NameBox;
	private DefaultComboBoxModel player1NameBoxModel;
	private JComboBox player1TypeBox;
	private DefaultComboBoxModel player1TypeBoxModel;
	private JButton player1ColorButton;
	
	private JPanel player2Panel;
	private JComboBox player2NameBox;
	private DefaultComboBoxModel player2NameBoxModel;
	private JComboBox player2TypeBox;
	private DefaultComboBoxModel player2TypeBoxModel;
	private JButton player2ColorButton;
	
	private JPanel gamePanel;
	
	private JButton startButton;
	private JButton backButton;
	
	public LocalCard(MainGui gui) {
		super(gui);
		double[][] size = {{MainGui.MARGIN, TableLayout.PREFERRED, TableLayout.FILL, 100, 5, 100,  MainGui.MARGIN}, 
				{100, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	protected void initComponents() {
		LocalListener listener = new LocalListener(this);
		TableLayout layout = new TableLayout(new double[][] {{5, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, 5}, 
				{0, TableLayout.FILL, 5}});
		
		player1Panel = new JPanel(layout);
		player1Panel.setOpaque(false);
		TitledBorder slot1_border = new TitledBorder("Slot1");
		slot1_border.setTitleColor(Color.WHITE);
		player1Panel.setBorder(slot1_border);
		
		player1TypeBoxModel = new DefaultComboBoxModel(new String[]{"Human", "Computer"});
		player1TypeBox = new JComboBox(player1TypeBoxModel);
		player1TypeBox.setEnabled(false);
		player1Panel.add(player1TypeBox, "1,1");
		
		player1NameBoxModel = new DefaultComboBoxModel(new String[]{Core.pref.get("player.name", "Player1")});
		player1NameBox = new JComboBox(player1NameBoxModel);
		player1NameBox.setEditable(true);
		player1NameBox.addItemListener(listener);
		player1Panel.add(player1NameBox, "3,1");
		
		player1ColorButton = new JButton();
		player1ColorButton.setBackground(new Color(Core.pref.getInt("player.color", 255)));
		player1ColorButton.setActionCommand("$b_color1");
		player1ColorButton.addActionListener(listener);
		player1Panel.add(player1ColorButton, "5,1");
		
		add(player1Panel, "1,1 , 5,1");
		
		
		
		player2Panel = new JPanel(layout);
		player2Panel.setOpaque(false);
		TitledBorder slot2_border = new TitledBorder("Slot2");
		slot2_border.setTitleColor(Color.WHITE);
		player2Panel.setBorder(slot2_border);
		
		player2TypeBoxModel = new DefaultComboBoxModel(new String[]{"Human", "Computer"});
		player2TypeBoxModel.setSelectedItem("Computer");
		player2TypeBox = new JComboBox(player2TypeBoxModel);
		player2TypeBox.setEnabled(false);
		player2Panel.add(player2TypeBox, "1,1");
		
		player2NameBoxModel = new DefaultComboBoxModel(new String[]{"Player2"});
		player2NameBox = new JComboBox(player2NameBoxModel);
		player2NameBox.setEditable(true);
		player2NameBox.addItemListener(listener);
		player2Panel.add(player2NameBox, "3,1");
		
		player2ColorButton = new JButton();
		player2ColorButton.setBackground(new Color(Core.pref.getInt("computer.color", -65536)));
		player2ColorButton.setActionCommand("$b_color2");
		player2ColorButton.addActionListener(listener);
		player2Panel.add(player2ColorButton, "5,1");
		
		add(player2Panel, "1,3 , 5,3");
		
		gamePanel = new JPanel(new TableLayout(new double[][]{{5, TableLayout.PREFERRED, 5}, {0, TableLayout.PREFERRED, 5}}));
		gamePanel.setOpaque(false);
		TitledBorder game_border = new TitledBorder("Game");
		game_border.setTitleColor(Color.WHITE);
		gamePanel.setBorder(game_border);
		JLabel infoLabel = new JLabel("<html><font color=#ffffff>comming soon...</font></html>");
		gamePanel.add(infoLabel, "1,1");
		
		add(gamePanel, "1,5 , 5,5");
		
		Core.pref.addPreferenceChangeListener(new PreferenceChangeListener() {
			@Override
			public void preferenceChange(PreferenceChangeEvent evt) {
				if("player.color".equals(evt.getKey().toString())) {
					player1ColorButton.setBackground(new Color(Core.pref.getInt("player.color", 255)));
				} else if("computer.color".equals(evt.getKey().toString())) {
					player2ColorButton.setBackground(new Color(Core.pref.getInt("computer.color", -65536)));
				}
			}
		});
		
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "3,7");
		
		startButton = new JButton("Start");
		startButton.setActionCommand("$b_start");
		startButton.addActionListener(listener);
		add(startButton, "5,7");
	}
	public boolean equalsSlotBox1(Object obj) {
		return player1NameBox.equals(obj);
	}
	public String getPlayerName() {
		return player1NameBox.getSelectedItem().toString();
	}
	public String getComputerName() {
		return player2NameBox.getSelectedItem().toString();
	}
	
	@Override
	public void update() {
	}
}
