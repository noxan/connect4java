package com.googlecode.connect4java.gui.card;

import info.clearthought.layout.TableLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;

import com.googlecode.connect4java.Main;
import com.googlecode.connect4java.gui.GuiCard;
import com.googlecode.connect4java.gui.MainGui;
import com.googlecode.connect4java.gui.listener.LocalListener;

/**
 * 
 * @author noxan
 * @version 0.6.12
 * @since 0.1
 */
public class LocalCard extends AbstractCard {
	private static final long serialVersionUID = 1L;
	
	private DefaultComboBoxModel slotBoxModel1;
	private JComboBox slotBox1;
	private DefaultComboBoxModel slotBoxModel2;
	private JComboBox slotBox2;
	
	private JButton startButton;
	private JButton backButton;
	
	public LocalCard(MainGui gui) {
		super(gui, new LocalListener(gui));
		double[][] size = {{MainGui.MARGIN, 0.5, 5, TableLayout.PREFERRED, TableLayout.FILL, 100, 5, 100,  MainGui.MARGIN}, 
				{100, TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, MainGui.MARGIN}};
		setLayout(new TableLayout(size));
		
		initComponents();
	}
	
	protected void initComponents() {
		slotBoxModel1 = new DefaultComboBoxModel(new String[]{"<Spielername>"});
		slotBox1 = new JComboBox(slotBoxModel1);
		slotBox1.setEnabled(false);
		add(slotBox1, "1,1");
		
		slotBoxModel2 = new DefaultComboBoxModel(new String[]{"Computer (Easy)", "Computer (Normal)", "Computer (Hard)", "Local Player"});
		slotBox2 = new JComboBox(slotBoxModel2);
		
		add(slotBox2, "1,3");
		
		
		final JButton colorButton1 = new JButton();
		
		
		final int color1 = Integer.valueOf(Main.pref.get("player1.color", "255")); 
		colorButton1.setBackground(new Color(color1));
		colorButton1.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				Color res = JColorChooser.showDialog(null, "Player1: Color", new Color(color1));
				if(res!=null) {
					Main.pref.put("player1.color", Integer.toString(res.getRGB()));
					colorButton1.setBackground(res);
				}
			}
		});
		add(colorButton1, "3,1");
		JButton colorButton2 = new JButton();
		colorButton2.setBackground(Color.RED);
		add(colorButton2, "3,3");
		
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gui.showCard(GuiCard.MENU);
			}
		});
		add(backButton, "5,5");
		
		startButton = new JButton("Start");
		add(startButton, "7,5");
	}
}
