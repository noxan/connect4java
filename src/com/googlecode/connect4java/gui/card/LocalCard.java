package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import jkit.pref.PreferenceChangeEvent;
import jkit.pref.PreferenceChangeListener;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.LocalListener;

/**
 * 
 * @author richard.stromer
 * @version 0.8.20
 * @since 0.1
 */
public class LocalCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private DefaultComboBoxModel slotBoxModel1;
	private JComboBox slotBox1;
	private JButton colorButton1;
	private DefaultComboBoxModel slotBoxModel2;
	private JComboBox slotBox2;
	private JButton colorButton2;
	
	private JButton startButton;
	private JButton backButton;
	
	public LocalCard(MainGui gui) {
		super(gui);
		double[][] size = {{MainGui.MARGIN, 0.5, 5, TableLayout.PREFERRED, TableLayout.FILL, 100, 5, 100,  MainGui.MARGIN}, 
				{100, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	protected void initComponents() {
		LocalListener listener = new LocalListener(this);
		
		slotBoxModel1 = new DefaultComboBoxModel(new String[]{Main.pref.get("player.name", "Player")});
		slotBox1 = new JComboBox(slotBoxModel1);
		slotBox1.setEditable(true);
		slotBox1.addItemListener(listener);
		add(slotBox1, "1,1");
		
		slotBoxModel2 = new DefaultComboBoxModel(new String[]{"Computer (Easy)", "Computer (Normal)", "Computer (Hard)", "Local Player"});
		slotBox2 = new JComboBox(slotBoxModel2);
		slotBox2.addItemListener(listener);
		
		add(slotBox2, "1,3");
		
		
		colorButton1 = new JButton();
		colorButton1.setBackground(new Color(Main.pref.getInt("player.color", 255)));
		colorButton1.setActionCommand("$b_color1");
		colorButton1.addActionListener(listener);
		add(colorButton1, "3,1");
		colorButton2 = new JButton();
		colorButton2.setActionCommand("$b_color2");
		colorButton2.setBackground(new Color(Main.pref.getInt("computer.color", -65536)));
		colorButton2.addActionListener(listener);
		add(colorButton2, "3,3");
		
		Main.pref.addPreferenceChangeListener(new PreferenceChangeListener() {
			@Override
			public void preferenceChange(PreferenceChangeEvent evt) {
				if("player.color".equals(evt.getKey().toString())) {
					colorButton1.setBackground(new Color(Main.pref.getInt("player.color", 255)));
				} else if("computer.color".equals(evt.getKey().toString())) {
					colorButton2.setBackground(new Color(Main.pref.getInt("computer.color", -65536)));
				}
			}
		});
		
		backButton = new JButton("Back");
		backButton.setActionCommand("$b_back");
		backButton.addActionListener(listener);
		add(backButton, "5,5");
		
		startButton = new JButton("Start");
		startButton.setActionCommand("$b_start");
		startButton.addActionListener(listener);
		add(startButton, "7,5");
	}
	public boolean equalsSlotBox1(Object obj) {
		return slotBox1.equals(obj);
	}
	public String getPlayerName() {
		return slotBox1.getSelectedItem().toString();
	}
	public String getComputerName() {
		return slotBox2.getSelectedItem().toString();
	}
}
