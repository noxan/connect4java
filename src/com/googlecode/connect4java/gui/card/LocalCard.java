package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import jkit.pref.PreferenceChangeEvent;
import jkit.pref.PreferenceChangeListener;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.LocalListener;

/**
 * 
 * @author richard.stromer
 * @version 1.0.27
 * @since 0.1
 */
public class LocalCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private JPanel slot1_panel;
	private JComboBox slot1_box;
	private DefaultComboBoxModel slot1_boxModel;
	private JButton slot1_colorButton;
	
	private JPanel slot2_panel;
	private JComboBox slot2_box;
	private DefaultComboBoxModel slot2_boxModel;
	private JButton slot2_colorButton;
	
	private JPanel game_panel;
	
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
		TableLayout layout = new TableLayout(new double[][] {{5, TableLayout.PREFERRED, 5, TableLayout.PREFERRED}, {TableLayout.FILL, 5}});
		
		slot1_panel = new JPanel(layout);
		slot1_panel.setOpaque(false);
		TitledBorder slot1_border = new TitledBorder("Slot1");
		slot1_border.setTitleColor(Color.WHITE);
		slot1_panel.setBorder(slot1_border);
		
		slot1_boxModel = new DefaultComboBoxModel(new String[]{Main.pref.get("player.name", "Player")});
		slot1_box = new JComboBox(slot1_boxModel);
		slot1_box.setEditable(true);
		slot1_box.addItemListener(listener);
		slot1_panel.add(slot1_box, "1,0");
		
		slot1_colorButton = new JButton();
		slot1_colorButton.setBackground(new Color(Main.pref.getInt("player.color", 255)));
		slot1_colorButton.setActionCommand("$b_color1");
		slot1_colorButton.addActionListener(listener);
		slot1_panel.add(slot1_colorButton, "3,0");
		
		add(slot1_panel, "1,1 , 5,1");
		
		
		
		slot2_panel = new JPanel(layout);
		slot2_panel.setOpaque(false);
		TitledBorder slot2_border = new TitledBorder("Slot2");
		slot2_border.setTitleColor(Color.WHITE);
		slot2_panel.setBorder(slot2_border);
		
		slot2_boxModel = new DefaultComboBoxModel(new String[]{"Local Player", "Computer (Easy)", "Computer (Normal)", "Computer (Hard)"});
		slot2_box = new JComboBox(slot2_boxModel);
		slot2_box.setEnabled(false);
		slot2_box.addItemListener(listener);
		slot2_panel.add(slot2_box, "1,0");
		
		slot2_colorButton = new JButton();
		slot2_colorButton.setBackground(new Color(Main.pref.getInt("computer.color", -65536)));
		slot2_colorButton.setActionCommand("$b_color2");
		slot2_colorButton.addActionListener(listener);
		slot2_panel.add(slot2_colorButton, "3,0");
		
		add(slot2_panel, "1,3 , 5,3");
		
		game_panel = new JPanel();
		game_panel.setOpaque(false);
		TitledBorder game_border = new TitledBorder("Game");
		game_border.setTitleColor(Color.WHITE);
		game_panel.setBorder(game_border);
		
		add(game_panel, "1,5 , 5,5");
		
		Main.pref.addPreferenceChangeListener(new PreferenceChangeListener() {
			@Override
			public void preferenceChange(PreferenceChangeEvent evt) {
				if("player.color".equals(evt.getKey().toString())) {
					slot1_colorButton.setBackground(new Color(Main.pref.getInt("player.color", 255)));
				} else if("computer.color".equals(evt.getKey().toString())) {
					slot2_colorButton.setBackground(new Color(Main.pref.getInt("computer.color", -65536)));
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
		return slot1_box.equals(obj);
	}
	public String getPlayerName() {
		return slot1_box.getSelectedItem().toString();
	}
	public String getComputerName() {
		return slot2_box.getSelectedItem().toString();
	}
}
